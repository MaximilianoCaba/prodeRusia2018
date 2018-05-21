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

    <style type="text/css">
        .bodyhome {
            background-image: url('<c:url value="/"/>image/brazil_soccer_wcup_argentina_iran-38.jpg');
            background-repeat: no-repeat;
            margin-top: 150px;
        }
    </style>

    <div class="container" style="background: lightgrey; width: 60%">
        <h1 class="text-center" style="font-family: initial;"><spring:message code="basicLayout.welcome"/>
            <p></p>
        </h1>
        <p class="text-center">
        <form action="<c:url value="/"/>google/login" method="GET">
            <div class="login-box-btm text-center">
                <button class="loginBtn loginBtn--google">
                    <spring:message code="basicLayout.login-button"/>
                </button>
            </div>
        </form>
        </p>
    </div>

    </body>

</sec:authorize>

<tiles:insertAttribute name="footerJavascript"/>

</html>