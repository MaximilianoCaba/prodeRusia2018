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
                                <div class="texto"><i class="glyphicon glyphicon-list-alt hidden-xs"></i><br/>Tabla
                                    General
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
                                            <li role="presentation" class="active"><a href="#ronda0" aria-controls="ronda1" role="tab" data-toggle="tab">Tabla general</a></li>
                                            <c:forEach items="${results.roundResult}" var="rounds">
                                                <li role="presentation"><a href="#ronda${rounds.key}" aria-controls="ronda1" role="tab" data-toggle="tab">Ronda ${rounds.key}</a></li>
                                            </c:forEach>
                                        </ul>

                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane active" id="ronda0">
                                                <div class="contenido_tab">
                                                    <div class="titulo">Tabla general</div>
                                                    <c:forEach items="${results.generalResult}" var="user" varStatus="loop">
                                                        <li class="lista_usuarios">
                                                            <div class="tabla_contenedor">
                                                                <div class="celda imagen"><img src="${user.userAvatar}" class="img-avatar" title="Posicion: ${loop.index +1}"></div>
                                                                <div class="celda nombre">${user.userName}</div>
                                                                <div class="celda numero">${user.result}</div>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </div>
                                            </div>

                                            <c:forEach items="${results.roundResult}" var="rounds">
                                                <div role="tabpanel" class="tab-pane" id="ronda${rounds.key}">
                                                    <div class="contenido_tab">
                                                        <div class="titulo">Ronda ${rounds.key}</div>
                                                        <c:forEach items="${rounds.value}" var="user" varStatus="loop">
                                                            <li class="lista_usuarios">
                                                                <div class="tabla_contenedor">
                                                                    <div class="celda imagen"><img src="${user.userAvatar}" class="img-avatar" title="Posicion: ${loop.index +1}"></div>
                                                                    <div class="celda nombre">${user.userName}</div>
                                                                    <div class="celda numero">${user.result}</div>
                                                                </div>
                                                            </li>
                                                        </c:forEach>
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




