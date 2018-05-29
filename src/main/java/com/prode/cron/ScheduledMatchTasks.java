package com.prode.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledMatchTasks {

    @Scheduled(cron = "0 0 16 ?/7 * ?")
    public void setInMatchGameAndSendMail() {

    }

    @Scheduled(cron = "0 0 16 ?/7 * ?")
    public void sendDailyResults() {

    }
}
