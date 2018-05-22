<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="list-group">

    <c:forEach items="${results.rounds}" var="rounds">
        <div id="travel-body" data-id=${rounds.round} class="container">

            <h1>Ronda ${rounds.round}</h1>

            <form role="form" id="form">
                <input type="hidden" id="round" value="${rounds.round}">
                <c:forEach items="${rounds.matches}" var="round">

                    <div id="travel-body" data-id=${round.match.id} class="container">

                        <input type="hidden" id="matchId" value="${round.match.id}">
                        <input type="hidden" id="userId" value="${round.userMatch.user.id}">

                        <div class="row">
                            <div class="col-sm-2">${round.match.teamHome.name}</div>
                            <div class="col-sm-1">
                                <img src=${round.match.teamHome.flag} class="img-rounded" alt="Cinque Terre" width="50"
                                     height="50">
                            </div>
                            <div class="col-sm-1">${round.match.goalHome}</div>


                            <c:choose>
                                <c:when test="${empty round.match.goalHome}">
                                    <div class="col-sm-1">
                                        <label for="userGoalHome">
                                        </label><input id="userGoalHome" value="${round.userMatch.goalHome}" type="number" name="quantity" min="0" max="99"/>

                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="col-sm-1">
                                        <label for="userGoalHome">

                                        </label><input value="${round.userMatch.goalHome}" disabled="disabled" type="number" name="quantity" min="0" max="99"/>
                                    </div>
                                </c:otherwise>
                            </c:choose>

                            <% // LOGICA PENALES  %>

                            <c:choose>
                                <c:when test="${rounds.round > 3}">

                                    <c:choose>
                                        <c:when test="${empty round.match.penaltyGoalHome}">
                                            <div class="col-sm-1">
                                                <label for="userGoalHome">
                                                </label><input id="userPenaltyGoalHome" value="${round.userMatch.penaltyGoalHome}" type="number" name="quantity" min="0" max="99"/>

                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col-sm-1">
                                                <label for="userGoalHome">
                                                </label><input value="${round.userMatch.penaltyGoalHome}" disabled="disabled" type="number" name="quantity" min="0" max="99"/>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>

                                    <c:choose>
                                        <c:when test="${empty round.match.penaltyGoalAway}">
                                            <div class="col-sm-1">
                                                <label for="userGoalHome">
                                                </label><input id="userPenaltyGoalAway" value="${round.userMatch.penaltyGoalAway}" type="number" name="quantity" min="0" max="99"/>

                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col-sm-1">
                                                <label for="userGoalHome">
                                                </label><input value="${round.userMatch.penaltyGoalAway}" disabled="disabled" type="number" name="quantity" min="0" max="99"/>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>

                                </c:when>
                                <c:otherwise>
                                    <div class="col-sm-1">
                                    </div>
                                    <div class="col-sm-1">
                                    </div>
                                </c:otherwise>
                            </c:choose>


                            <% // LOGICA PENALES  %>


                            <c:choose>
                                <c:when test="${empty round.match.goalAway}">
                                    <div class="col-sm-1">
                                        <label for="userGoalAway">
                                        </label><input id="userGoalAway" value="${round.userMatch.goalAway}" type="number" name="quantity" min="0" max="99"/>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="col-sm-1">
                                        <label for="userGoalAway">
                                        </label><input value="${round.userMatch.goalAway}" disabled="disabled" type="number" name="quantity" min="0" max="99"/>
                                    </div>
                                </c:otherwise>
                            </c:choose>

                            <div class="col-sm-1">${round.match.goalAway}</div>
                            <div class="col-sm-1">
                                <img src=${round.match.teamAway.flag} class="img-rounded" alt="Cinque Terre" width="50"
                                     height="50">
                            </div>
                            <div class="col-sm-2">${round.match.teamAway.name}</div>
                        </div>


                    </div>

                </c:forEach>
            </form>
            <div class="col-xs-12 col-md-6"><a id="botonEditarFix" class="btn btn-success btn-block btn-lg">
                <i id="loadingSpinnerEditarFix" class="fa fa-spinner fa-spin hide"></i>Editar Fixture</a></div>

        </div>

    </c:forEach>


</div>
