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

                                                <c:choose>
                                                    <c:when test="${rounds.round == 1}">
                                                        <li role="presentation" class="active">
                                                            <a href="#ronda${rounds.round}" aria-controls="ronda1" role="tab" data-toggle="tab">Ronda ${rounds.round}</a>
                                                        </li>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <li role="presentation">
                                                            <a href="#ronda${rounds.round}" aria-controls="ronda1" role="tab" data-toggle="tab">Ronda ${rounds.round}</a>
                                                        </li>
                                                    </c:otherwise>
                                                </c:choose>


                                            </c:forEach>
                                        </ul>

                                        <div class="tab-content" id="form">



                                            <c:forEach items="${results.rounds}" var="rounds">

                                                <c:choose>
                                                    <c:when test="${rounds.round == 1}">
                                                <div role="tabpanel" class="tab-pane active" id="ronda${rounds.round}">

                                                </c:when>
                                                    <c:otherwise>
                                                    <div role="tabpanel" class="tab-pane" id="ronda${rounds.round}">

                                                    </c:otherwise>
                                                </c:choose>

                                                    <div class="contenido_tab" id>
                                                        <div class="titulo">Ronda ${rounds.round}</div>
                                                        <ul class="ronda_lista">

                                                            <c:choose>
                                                            <c:when test="${ fn:length(rounds.matches) != 0}">

                                                            <c:forEach items="${rounds.matches}" var="round">
                                                                <input type="hidden" id="matchId" value="${round.match.id}">
                                                                <input type="hidden" id="userId" value="${round.matchUser.user.id}">
                                                                <li id="myMatch">
                                                                    <div class="tabla_contenedor">
                                                                        <div class="fila partido">
                                                                            <div class="celda"><img src="${round.match.teamHome.flag}"></div>
                                                                            <div class="celda">${round.match.teamHome.name}</div>
                                                                            <div class="celda">
                                                                                <input <c:if test="${round.match.matchState.id != 1}"><c:out value="disabled='disabled'"/></c:if> value="${round.matchUser.goalHome}" type="number" min="0" max="99"/>
                                                                            </div>
                                                                            <div class="celda"> Pronostico </div>
                                                                            <div class="celda">
                                                                                <input <c:if test="${round.match.matchState.id != 1}"><c:out value="disabled='disabled'"/></c:if> value="${round.matchUser.goalAway}" type="number" min="0" max="99"/>
                                                                            </div>
                                                                            <div class="celda">${round.match.teamAway.name}</div>
                                                                            <div class="celda"><img src="${round.match.teamAway.flag}"></div>

                                                                        </div>
                                                                        <c:choose>
                                                                            <c:when test="${rounds.round > 3}">
                                                                                <div class="fila penales">
                                                                                    <div class="celda"></div>
                                                                                    <div class="celda"></div>
                                                                                    <div class="celda">
                                                                                        <input <c:if test="${round.match.matchState.id != 1}"><c:out value="disabled='disabled'"/></c:if> value="${round.matchUser.penaltyGoalHome}" type="number" min="0" max="99"/>
                                                                                    </div>
                                                                                    <div class="celda"> Penales </div>
                                                                                    <div class="celda">
                                                                                        <input <c:if test="${round.match.matchState.id != 1}"><c:out value="disabled='disabled'"/></c:if> value="${round.matchUser.penaltyGoalAway}" type="number" min="0" max="99"/>
                                                                                    </div>
                                                                                    <div class="celda"></div>
                                                                                    <div class="celda"></div>
                                                                                </div>
                                                                            </c:when>
                                                                        </c:choose>
                                                                    </div>
                                                                    <c:choose>
                                                                        <c:when test="${! empty round.match.goalAway && ! empty round.match.goalHome }">
                                                                            <c:choose>
                                                                                <c:when test="${! empty round.match.penaltyGoalHome && ! empty round.match.penaltyGoalAway }">
                                                                                    <div class="text-center resultado_partido"> Resultado partido: <b>${round.match.teamHome.name} ${round.match.goalHome} (${round.match.penaltyGoalHome}) - (${round.match.penaltyGoalAway}) ${round.match.teamAway.name} ${round.match.goalAway}</b></div>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <div class="text-center resultado_partido"> Resultado partido: <b>${round.match.teamHome.name} ${round.match.goalHome} - ${round.match.teamAway.name} ${round.match.goalAway}</b></div>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <div class="text-center resultado_partido">Info: <b> <fmt:formatDate value="${round.match.date}" timeZone="GMT+0" pattern="yyyy-MM-dd hh:mm a" /> </b></div>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </li>
                                                            </c:forEach>
                                                            </c:when>
                                                                <c:otherwise>

                                                                    <div class="titulo" style="border-bottom: 0px solid">Aun no hemos cargado esta ronda</div>
                                                                    <div class="titulo" style="border-bottom: 0px solid">Se iran cargando a medida que se resuelvan las rondas anteriores</div>

                                                                </c:otherwise>
                                                            </c:choose>

                                                        </ul>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                            <div><button id="botonEditarFix" class="btn btn-lg btn-iniciar">Editar Fixture  <i id="spinnerEditarFix" class="fa fa-spinner fa-spin hide"></i> </button></div>
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


    <div class="modal fade" id="modalExitoGuardar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="gridSystemModalLabel">Aviso</h4>
                </div>
                <div class="modal-body text-center aviso_modal">
                    Error al guardar su Fixture<br />Por favor si persiste este mensaje contacte al administrador de la pp
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-cerrar" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>