<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div id="principal">
    <div class="slide-home" role="home">
        <div class="tabla_contenedor">
            <div class="fila titulo">
                <div class="celda">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="texto"><i class="glyphicon glyphicon-file hidden-xs"></i><br/>Mi fixture
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="fila contenido">
                <div class="celda">
                    <div class="contenedor_capa">
                        <div class="container">
                            <div class="row">
                                <div class="col-sm-8 col-sm-offset-2">
                                    <div>


                                        <ul class="nav nav-tabs text-center" role="tablist">
                                            <c:forEach items="${results.rounds}" var="rounds">
                                                <li role="presentation" <c:if test="${rounds.round == 1}"><c:out value="class='active'"/></c:if> >
                                                    <a
                                                            href="#ronda${rounds.round}" aria-controls="ronda1"
                                                            role="tab" data-toggle="tab">Ronda ${rounds.round}</a>
                                                </li>
                                            </c:forEach>
                                        </ul>

                                        <div class="tab-content">

                                            <c:forEach items="${results.rounds}" var="rounds">


                                                <div role="tabpanel"<c:if test="${rounds.round == 1}"><c:out value="class='tab-pane active'"/></c:if> class="tab-pane" id="ronda${rounds.round}">

                                                    <div class="contenido_tab">
                                                        <div class="titulo">Ronda ${rounds.round}</div>

                                                        <ul class="ronda_lista">

                                                            <c:forEach items="${rounds.matches}" var="round">

                                                                <li>
                                                                    <div class="tabla_contenedor">
                                                                        <div class="fila partido">
                                                                            <div class="celda"><img
                                                                                    src="${round.match.teamHome.flag}">
                                                                            </div>
                                                                            <div class="celda">${round.match.teamHome.name}</div>


                                                                            <div class="celda">
                                                                                <input <c:if test="${! empty round.match.goalHome}"><c:out value="disabled='disabled'"/></c:if> value="${round.matchUser.goalHome}" type="number"/>
                                                                            </div>

                                                                            <div class="celda">
                                                                                <div class="division"></div>
                                                                            </div>

                                                                            <div class="celda">
                                                                                <input <c:if test="${! empty round.match.goalAway}"><c:out value="disabled='disabled'"/></c:if> value="${round.matchUser.goalAway}" type="number"/>
                                                                            </div>

                                                                            <div class="celda">${round.match.teamAway.name}</div>
                                                                            <div class="celda"><img src="${round.match.teamAway.flag}"></div>

                                                                        </div>

                                                                        <c:choose>
                                                                            <c:when test="${rounds.round > 3}">
                                                                                <div class="fila penales">
                                                                                    <div class="celda"></div>
                                                                                    <div class="celda"></div>

                                                                                    <input <c:if test="${! empty round.match.penaltyGoalHome}"><c:out value="disabled='disabled'"/></c:if> value="${round.matchUser.penaltyGoalHome}" type="number"/>

                                                                                    <div class="celda">Penales</div>

                                                                                    <input <c:if test="${! empty round.match.penaltyGoalAway}"><c:out value="disabled='disabled'"/></c:if> value="${round.matchUser.penaltyGoalAway}" type="number"/>

                                                                                    <div class="celda"></div>
                                                                                    <div class="celda"></div>
                                                                                </div>
                                                                            </c:when>
                                                                        </c:choose>


                                                                    </div>



                                                                    <c:choose>
                                                                        <c:when test="${! empty round.match.goalAway && ! empty round.match.goalHome }">
                                                                            <div class="text-center resultado_partido">
                                                                                Resultado partido:
                                                                                <b>${round.match.teamHome.name} ${round.match.goalHome}
                                                                                    - ${round.match.teamAway.name} ${round.match.goalAway}</b>
                                                                            </div>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <div class="text-center resultado_partido">Info: <b>22-06-2018 14:00 hs Stadium Rusia</b></div>
                                                                        </c:otherwise>
                                                                    </c:choose>

                                                                </li>

                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>