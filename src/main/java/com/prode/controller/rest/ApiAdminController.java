package com.prode.controller.rest;

import com.prode.Utils.AuthorizationApi;
import com.prode.entity.Match;
import com.prode.enums.TeamEnum;
import com.prode.service.MatchService;
import com.prode.service.MessengerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiAdmin")
public class ApiAdminController {

    @Autowired
    private MessengerService messengerService;

    @Autowired
    private MatchService matchService;

    @Value("${admin.api.client.id}")
    private String clientId;

    @Value("${admin.api.client.secret}")
    private String clientSecret;

    private final static String UNDAUTHORIZED = "usted no esta autorizado para realizar esta peticion";

    private final static String teamAvailable = "Russia,SaudiArabia,Egypt,Uruguay,Portugal,Spain,Morocco,Iran,France," +
            "Australia,Peru,Denmark,Argentina,Iceland,Croatia,Nigeria,Brazil,Switzerland,CostaRica,Serbia,Germany,Mexico," +
            "Sweden,SouthKorea,Belgium,Panama,Tunisia,England,Poland,Senegal,Colombia,Japan";

    @RequestMapping(value = "/getRound", method = RequestMethod.GET)
    @ApiOperation(consumes = "application/json", value = "obtener los partidos de una ronda")
    public List<Match> getRound( @ApiParam(value="Ronda del torneo",name = "round", required = true, allowableValues = "1,2,3,4,5,6,7") @RequestParam("round") Integer round,
                                 @ApiParam(value="Contraseña de la api",name = "pass", required = true) @RequestParam("pass") String pass) throws Exception {

        if (AuthorizationApi.ifUserIsAuthenticate(pass, clientId, clientSecret))
            return matchService.findAllByRound(round);
        else
            throw new Exception(UNDAUTHORIZED);

    }

    @RequestMapping(value = "/addMatch", method = RequestMethod.POST)
    @ApiOperation(consumes = "application/json", value = "Agregar un partido nuevo")
    public void addMatch(  @ApiParam(value ="Ronda del torneo", name = "round", required = true, allowableValues = "1,2,3,4,5,6,7") @RequestParam("round") Integer round,
                           @ApiParam(value="Nombre del equipo local",name = "teamHome", required = true, allowableValues = teamAvailable) @RequestParam("teamHome") TeamEnum teamHome,
                           @ApiParam(value="Nombre del equipo visitante",name = "teamAway", required = true, allowableValues = teamAvailable) @RequestParam("teamAway") TeamEnum teamAway,
                           @ApiParam(value="fecha del partido formato YYYY-mm-dd HH:mm",name = "date", required = true) @RequestParam("date") String date,
                           @ApiParam(value="Contraseña de la api",name = "pass", required = true) @RequestParam("pass") String pass) throws Exception {


        if (AuthorizationApi.ifUserIsAuthenticate(pass, clientId, clientSecret))
            matchService.saveMatch(round,teamHome,teamAway, date);
        else
            throw new Exception(UNDAUTHORIZED);

    }

    @RequestMapping(value = "/editMatch", method = RequestMethod.POST)
    @ApiOperation(consumes = "application/json", value = "Editar un partido Existente")
    public void editMatch(  @ApiParam(value="Identificador del partido", name = "matchId", required = true) @RequestParam("matchId") Long matchId,
                            @ApiParam(value="Nombre del equipo local",name = "teamHome", required = true, allowableValues = teamAvailable) @RequestParam("teamHome") TeamEnum teamHome,
                            @ApiParam(value="Nombre del equipo visitante",name = "teamAway", required = true, allowableValues = teamAvailable) @RequestParam("teamAway") TeamEnum teamAway,
                            @ApiParam(value="Goles equipo local", name = "goalHome",required = true) @RequestParam("goalHome") Integer goalHome,
                            @ApiParam(value="Goles equipo visitante", name = "goalAway",required = true) @RequestParam("goalAway") Integer goalAway,
                            @ApiParam(value="Goles equipo local (usar caracter '-' (guion medio) para partidos sin penales)", name = "goalHomePenal",required = false) @RequestParam("goalHomePenal") String goalHomePenal,
                            @ApiParam(value="Goles equipo visitante (usar caracter '-' (guion medio) para partidos sin penales)", name = "goalAwayPenal",required = false) @RequestParam("goalAwayPenal") String goalAwayPenal,
                            @ApiParam(value="Contraseña de la api",name = "pass", required = true) @RequestParam("pass") String pass) throws Exception {

        if (AuthorizationApi.ifUserIsAuthenticate(pass, clientId, clientSecret)){

            if(StringUtils.isNumeric(goalHomePenal) && StringUtils.isNumeric(goalAwayPenal)){
                matchService.updateMatch(matchId, teamHome, teamAway, goalHome, goalAway, Integer.parseInt(goalHomePenal), Integer.parseInt(goalAwayPenal));
            }else{
                matchService.updateMatch(matchId, teamHome, teamAway, goalHome, goalAway, null, null);
            }
        } else
            throw new Exception(UNDAUTHORIZED);

    }

    @RequestMapping(value = "/sendWorkPlace", method = RequestMethod.POST)
    @ApiOperation(consumes = "application/json", value = "envia una notificacion al workplace a grupo pre seteado en la app")
    public void sendWorkPlace(@ApiParam(value="Mensaje del post",name = "message", required = true) @RequestParam("message") String message,
                          @ApiParam(value="Contraseña de la api",name = "pass", required = true) @RequestParam("pass") String pass) throws Exception {

        if (AuthorizationApi.ifUserIsAuthenticate(pass, clientId, clientSecret))
            messengerService.sendNotificationWorkplace(message);
        else
            throw new Exception(UNDAUTHORIZED);
    }


}