<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 25-Jan-20
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title><s:message code="menu.profileEdit"/></title>

    <script type="text/javascript">
        function leave() {
            window.location = '${pageContext.request.contextPath}/logout';
        }
        setTimeout("leave()", 1700);
    </script>
</head>
<body>
<%@include file="../incl/menu.app" %>
<p align="center">
    <font face="sans-serif" size="5">
        <c:out value="${message }" />
    </font>
</p>

</body>
</html>
