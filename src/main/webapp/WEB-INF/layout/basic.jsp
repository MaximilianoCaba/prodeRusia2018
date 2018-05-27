<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><tiles:getAsString name="title"/></title>
    <tiles:insertAttribute name="headerStyles"/>
</head>

<body class="bodyhome">
<sec:authorize access="isAuthenticated()">
    <tiles:insertAttribute name="header"/>

    <c:choose>
        <c:when test="${user==null}">

            <div id="principal">
                <div class="container-fluid slide-home bienvenida" role="home">
                    <div class="tabla_contenedor home">
                        <div class="celda">
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm-12 text-center texto-central">
                                        <div><img src="<c:url value="/"/>img/logo_russia_2018.png"/></div>
                                        <div class="linea2"><spring:message
                                                code="basicLayout.dontUserSnoop.title"/></div>
                                        <div class="linea1" style="border-bottom: 0px solid #fff;"><spring:message
                                                code="basicLayout.dontUserSnoop.description"/></div>
                                        <a href="<c:url value="/"/>logout" class="btn btn-lg btn-iniciar">Cerrar sesi&oacute;n</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </c:when>
        <c:otherwise>
            <tiles:insertAttribute name="body"/>
        </c:otherwise>
    </c:choose>

</sec:authorize>

<sec:authorize access="isAnonymous()">

    <div id="principal">
        <div class="container-fluid slide-home bienvenida" role="home">
            <div class="tabla_contenedor home">
                <div class="celda">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12 text-center texto-central">
                                <div><img src="<c:url value="/"/>img/logo_russia_2018.png"/></div>
                                <div class="linea1">Bienvenido al prode de</div>
                                <div class="linea2">Snoop Consulting</div>
                                <a href="<c:url value="/"/>google/login" class="btn btn-lg btn-iniciar">Iniciar sesi&oacute;n</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


</sec:authorize>
</body>


<tiles:insertAttribute name="footerJavascript"/>

</html>