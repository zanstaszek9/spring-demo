<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 27-Jan-20
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title><s:message code="menu.users"/></title>
</head>
<body>
<%@include file="../../incl/menu.app" %>
<h1><s:message code="menu.users"/></h1>

<table width="1000" border="0" cellpadding="6" cellspacing="0">
    <tr>
        <td width="35" align="center"><s:message code="admin.user.id"/></td>
        <td width="200" align="center"><s:message code="register.name"/></td>
        <td width="200" align="center"><s:message code="register.lastName"/></td>
        <td width="220" align="center"><s:message code="register.email"/></td>
        <td width="60" align="center"><s:message code="profile.isActive"/></td>
        <td width="100" align="center"><s:message code="profile.role"/></td>
    </tr>
    <c:forEach var="u" items="${userList }">
    <tr>
        <td><c:out value="${u.id }" /></td>
        <td><c:out value="${u.name }" /></td>
        <td><c:out value="${u.lastName }" /></td>
        <td><c:out value="${u.email }" /></td>
        <td>
            <c:choose>
                <c:when test="${u.active == 1 }">
                    <font color="green"><s:message code="word.yes"/></font>
                </c:when>
                <c:otherwise>
                    <font color="red"><s:message code="word.no"/></font>
                </c:otherwise>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${u.nrRole == 1 }">
                    <font color="green"><s:message code="word.admin"/></font>
                </c:when>
                <c:otherwise>
                    <font><s:message code="word.user"/></font>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
    </c:forEach>
</body>
</html>
