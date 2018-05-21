<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/"/>"><spring:message code="header.title"/>
            </a>
        </div>
        <sec:authorize access="isAnonymous()">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <form action="<c:url value="/"/>google/login" method="GET">
                            <div class="login-box-btm text-center">
                                <button class="loginBtn loginBtn--google">
                                    <spring:message code="header.login.button"/>

                                </button>
                            </div>
                        </form>
                    </li>
                </ul>
            </div>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <c:choose>
                <c:when test="${user==null}">
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <form action="<c:url value="/"/>logout" method="POST">
                                    <div class="login-box-btm text-center">
                                        <button class="loginBtn loginBtn--google">
                                            <spring:message code="header.logout.button"/>
                                        </button>
                                    </div>
                                </form>
                            </li>
                        </ul>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" style="padding-bottom: 3px; padding-top: 3px;">
                                    <img src="${user.avatar}" class="img-header"/>
                                </a>
                                <ul class="dropdown-menu dropdown-cart" role="menu">

                                    <li>
                                        <a href="<c:url value="/"/>">
                                            <span class="item">
                                                <span class="item-left">
                                                    <img src="<c:url value="/"/>image/home.svg" alt=""/>
                                                        <span class="item-info">
                                                            <span><spring:message code="header.home.firtLine"/></span>
                                                            <span><spring:message code="header.home.SecondLine"/></span>
                                                        </span>
                                                </span>
                                            </span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="<c:url value="/myRound"/>">
                                            <span class="item">
                                                <span class="item-left">
                                                    <img src="<c:url value="/"/>image/home.svg" alt=""/>
                                                        <span class="item-info">
                                                            <span><spring:message code="header.myRound.firtLine"/></span>
                                                            <span><spring:message code="header.myRound.SecondLine"/></span>
                                                        </span>
                                                </span>
                                            </span>
                                        </a>
                                    </li>

                                    <li class="divider"></li>
                                    <li>
                                        <form action="<c:url value="/"/>logout" method="POST">
                                            <div class="login-box-btm text-center">
                                                <button class="loginBtn loginBtn--google">
                                                    <spring:message code="header.logout.button"/>
                                                </button>
                                            </div>
                                        </form>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </c:otherwise>
            </c:choose>
        </sec:authorize>
    </div>
</nav>