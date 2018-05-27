<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><tiles:getAsString name="title"/></title>
    <tiles:insertAttribute name="headerStyles"/>
</head>

<body class="bodyhome">
<tiles:insertAttribute name="header"/>

<div id="principal">
    <div class="container-fluid slide-home bienvenida" role="home" style="color: #f50000;">
        <div class="tabla_contenedor home">
            <div class="celda">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12 text-center texto-central">
                            <tiles:insertAttribute name="body"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<tiles:insertAttribute name="footerJavascript"/>
</body>
</html>