<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<sec:authorize access="isAuthenticated()">

    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><img src="<c:url value="/"/>img/logo5.png" height="50"/></a>
            </div>
            <!-- nav-collapse -->
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">

                    <c:choose>
                        <c:when test="${user==null}">
                        </c:when>
                        <c:otherwise>
                            <li><a href="<c:url value="/"/>">Tabla general</a></li>
                            <li><a href="<c:url value="/myRound"/>">Mi Fixture</a></li>
                            <li><a href="<c:url value="/rules"/>">Reglamento</a></li>
                            <li class="hidden-xs"><img src="${user.avatar}" class="img-avatar header"></li>
                        </c:otherwise>
                    </c:choose>

                    <li><a href="<c:url value="/"/>logout"><i class="glyphicon glyphicon-off hidden-xs"></i><span
                            class="visible-xs">Cerrar sesi&oacute;n</span></a></li>
                </ul>
            </div>
        </div>
    </nav>

</sec:authorize>



