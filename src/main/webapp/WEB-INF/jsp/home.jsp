<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:forEach items="${results.generalResult}" var="user">

    <div id="travel-body" data-id=${user.userName} class="container">
        <div class="row">
            <div class="col-xs-12 col-md-offset-2 col-md-8">
                <ul class="event-list">

                    <li>
                        <time>
                            <span class="day">
                                    ${user.result}
                            </span>

                        </time>
                        <div class="info">
                            <h2 class="hour">
                                <div class="title-list">
                                    ${user.userName}
                                </div>
                            </h2>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</c:forEach>



