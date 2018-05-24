<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><tiles:getAsString name="title"/></title>
    <tiles:insertAttribute name="headerStyles"/>
</head>

<sec:authorize access="isAuthenticated()">
    <body>
    <tiles:insertAttribute name="header"/>

    <c:choose>
        <c:when test="${user==null}">

            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#"><img src="<c:url value="/"/>img/logo5.png" height="50" /></a>
                    </div>
                </div>
            </nav>

            <div class="container">
                <div class="jumbotron">
                    <div class="text-center"><i class="fa fa-5x fa-frown-o" style="color:#d97323;"></i></div>
                    <h1 class="text-center"><spring:message code="basicLayout.dontUserSnoop.title"/><p></p></h1>
                    <p class="text-center"><spring:message code="basicLayout.dontUserSnoop.description"/></p>
                    <p class="text-center">
                    <form action="<c:url value="/"/>logout" method="POST">
                        <div class="login-box-btm text-center">
                            <button class="loginBtn loginBtn--google">
                                <spring:message code="basicLayout.dontUserSnoop.logout.button"/>
                            </button>
                        </div>
                    </form>
                    </p>
                </div>
            </div>

        </c:when>
        <c:otherwise>
            <tiles:insertAttribute name="body"/>
        </c:otherwise>
    </c:choose>
    </body>

</sec:authorize>

<sec:authorize access="isAnonymous()">
    <body class="bodyhome">

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


    </body>

</sec:authorize>

<tiles:insertAttribute name="footerJavascript"/>

</html>