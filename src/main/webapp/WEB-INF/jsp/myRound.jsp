<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="list-group">


    <c:forEach items="${results.rounds}" var="rounds">
        <div id="travel-body" data-id=${rounds.round} class="container">

            <h1>Ronda ${rounds.round}</h1>

            <div class="row">
                <div class="col-sm-2">Pais Local</div>
                <div class="col-sm-2">Bandera Local</div>
                <div class="col-sm-1">Goles Local</div>
                <div class="col-sm-1">Mi pronostico Local</div>
                <div class="col-sm-1">Mi pronostico Visitante</div>
                <div class="col-sm-1">Goles Visitante</div>
                <div class="col-sm-2">
                    Bandera visitante
                </div>
                <div class="col-sm-2">Pais Visitante</div>
            </div>

            <c:forEach items="${rounds.matches}" var="round">

                <div id="travel-body" data-id=${round.match.id} class="container">


                    <div class="row">
                        <div class="col-sm-2">${round.match.teamHome.name}</div>
                        <div class="col-sm-2">
                            <img src=${round.match.teamHome.flag} class="img-rounded" alt="Cinque Terre" width="50" height="50">
                        </div>
                        <div class="col-sm-1">${round.match.goalHome}</div>
                        <div class="col-sm-1">${round.userMatch.goalHome}</div>
                        <div class="col-sm-1">${round.userMatch.goalAway}</div>
                        <div class="col-sm-1">${round.match.goalAway}</div>
                        <div class="col-sm-2">
                            <img src=${round.match.teamAway.flag} class="img-rounded" alt="Cinque Terre" width="50" height="50">
                        </div>
                        <div class="col-sm-2">${round.match.teamAway.name}</div>
                    </div>



                </div>

            </c:forEach>
        </div>

    </c:forEach>


</div>
