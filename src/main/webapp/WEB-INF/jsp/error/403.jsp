<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">
    <div class="jumbotron">
        <div class="text-center"><i class="fa fa-5x fa-frown-o" style="color:#1d2ad9;"></i></div>
        <h1 class="text-center"><spring:message code="error.403.title"/>
            <p></p>
            <p>
                <small class="text-center"><spring:message code="error.403.title.small"/>
                </small>
            </p>
        </h1>
        <p class="text-center"><spring:message code="error.403.description"/>
        </p>
        <p class="text-center">

            <a href="<c:url value="/"/>google/login" class="btn btn-lg btn-iniciar" style="  background-color: rgba(234, 22, 22, 0.2); color: #ad2525;">Iniciar sesi&oacute;n</a>

        </p>
    </div>
</div>