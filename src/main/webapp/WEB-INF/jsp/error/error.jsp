<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">
    <div class="jumbotron">
        <div class="text-center"><i class="fa fa-5x fa-frown-o" style="color:#50d946;"></i></div>
        <h1 class="text-center"><spring:message code="error.title"/><p> </p><p><small class="text-center"> <spring:message code="error.title.small"/></small></p></h1>
        <p class="text-center"><spring:message code="error.description"/></p>
    </div>
</div>