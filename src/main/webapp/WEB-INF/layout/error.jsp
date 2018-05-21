<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><tiles:getAsString name="title"/></title>
    <tiles:insertAttribute name="headerStyles"/>
</head>
<body>
<tiles:insertAttribute name="header"/>

<tiles:insertAttribute name="body"/>

<tiles:insertAttribute name="footerJavascript"/>
</body>
</html>