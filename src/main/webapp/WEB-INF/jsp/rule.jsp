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
                                <div class="texto"><i class="glyphicon glyphicon-info-sign hidden-xs"></i><br/>Informacion</div>
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
                                            <li role="presentation" class="active"><a href="#puntos" aria-controls="ronda1" role="tab" data-toggle="tab">Puntos</a></li>
                                            <li role="presentation"><a href="#reglas" aria-controls="ronda1" role="tab" data-toggle="tab">Reglas</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane active" id="puntos">
                                                <div class="contenido_tab">

                                                    <div class="titulo" style="display: block; border-bottom: 0px solid; font-size: 15px;">2 puntos por acertar el resultado completo</div>
                                                    <div class="titulo" style="display: block; border-bottom: 0px solid; font-size: 15px">1 puntos por acertar el resultado parcial</div>
                                                    <div class="titulo" style="display: block; border-bottom: 0px solid; font-size: 15px">2 puntos por acertar el resultado de penales completo</div>
                                                    <div class="titulo" style="display: block; border-bottom: 0px solid; font-size: 15px">1 puntos por acertar el resultado de penales parcial</div>

                                                </div>
                                            </div>


                                            <div role="tabpanel" class="tab-pane" id="reglas">
                                                <div class="contenido_tab">

                                                    <div class="titulo" style="display: block; border-bottom: 0px solid; font-size: 15px">Deberan completar el fixture hasta una hora antes del comienzo del partido. </div>
                                                    <div class="titulo" style="display: block; border-bottom: 0px solid; font-size: 15px">Al finalizar el torneo la persona con mas puntos recibira un fantastico premio que seleccionara el Comite del Mundial</div>

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
    </div>
</div>




