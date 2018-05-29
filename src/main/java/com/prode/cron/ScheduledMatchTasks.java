package com.prode.cron;

import com.prode.Utils.DateUtility;
import com.prode.Utils.MessengerUtility;
import com.prode.entity.Match;
import com.prode.entity.MatchState;
import com.prode.entity.MatchUser;
import com.prode.enums.MatchEnum;
import com.prode.repository.MatchRepository;
import com.prode.repository.MatchUserRepository;
import com.prode.response.home.Result;
import com.prode.service.MessengerService;
import com.prode.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledMatchTasks {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchUserRepository matchUserRepository;

    @Autowired
    private MessengerService messengerService;

    @Autowired
    private ResultService resultService;

    @Value("${url.app}")
    private String urlApp;

    @Scheduled(cron = "*/30 * * * * *")
    public void setInMatchGameAndSendMail() {
        System.out.println("se esta corriendo el cron setInMatchGameAndSendMail");

        MatchState matchState = new MatchState();
        matchState.setId(MatchEnum.NOT_STARTED.getIdSqlSchema());
        matchState.setState(MatchEnum.NOT_STARTED.getState());

        List<Match> allMatches = matchRepository.findAllByMatchState(matchState);

        allMatches.forEach(match -> {
            try {
                if(DateUtility.ifLessThanAnHourDiference(match.getTimeAdd3Hours())){

                    List<MatchUser> matchUserList = matchUserRepository.findByMatch(match);

                    MatchState newMatchState = new MatchState();
                    newMatchState.setId(MatchEnum.IN_PROGRESS.getIdSqlSchema());
                    newMatchState.setState(MatchEnum.IN_PROGRESS.getState());
                    match.setMatchState(newMatchState);
                    matchRepository.save(match);

                    String message = MessengerUtility.generateMatchEmailMessage(match, matchUserList);
                    String title = MessengerUtility.generateMatchEmailTitle(match);

                    String messageWorkPlace = MessengerUtility.generateMatchInProgressWorkPlace(match);

                    messengerService.sendNotificationMail(title, message);
                    messengerService.sendNotificationWorkplace(urlApp, messageWorkPlace);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


    }

    @Scheduled(cron = "*/360 * * * * *")
    public void sendDailyResults() throws Exception {
        System.out.println("se esta corriendo el cron sendDailyResults");
        Result result = resultService.getResultRound();
        String message = MessengerUtility.generateRankingWorkPlace(result);

        if(!message.equals("")){
            messengerService.sendNotificationWorkplace(urlApp, message);
        }
    }
}
