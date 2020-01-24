<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 23-Jan-20
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title><s:message code="error.errorPage"/></title>
</head>
<body>
<%@include file="../incl/menu.app" %>

<img src="/resources/images/errorimage.png">
<h2><s:message code="error.defaultErrorMessage"/></h2>

</body>
</html>
