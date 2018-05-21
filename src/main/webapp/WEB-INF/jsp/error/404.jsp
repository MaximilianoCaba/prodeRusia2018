<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">
    <div class="jumbotron">
        <div class="text-center"><i class="fa fa-5x fa-frown-o" style="color:#d9534f;"></i></div>
        <h1 class="text-center"><spring:message code="error.404.title"/>
            <p></p>
            <p>
                <small class="text-center"><spring:message code="error.404.title.small"/>
                </small>
            </p>
        </h1>
        <p class="text-center"><spring:message code="error.404.description"/>
        </p>
        <p class="text-center"><a class="btn btn-primary" href="<c:url value="/"/>"><i
                class="fa fa-home"></i><spring:message code="error.404.button"/>
        </a></p>
    </div>
</div>