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
<c:set var="recordCounter" value="${recordCounterStart}" scope="page"/>
<div>
    <!-- TODO: CSS from https://jsfiddle.net/zanstaszek9/14mawcey/ -->
<table width="1000" border="0" cellpadding="6" cellspacing="0">
    <tr>
        <td width="35" align="center"></td>
        <td width="35" align="center"><s:message code="admin.user.id"/></td>
        <td width="200" align="center"><s:message code="register.name"/></td>
        <td width="200" align="center"><s:message code="register.lastName"/></td>
        <td width="220" align="center"><s:message code="register.email"/></td>
        <td width="60" align="center"><s:message code="profile.isActive"/></td>
        <td width="100" align="center"><s:message code="profile.role"/></td>
    </tr>
    <c:forEach var="u" items="${usersList }">
        <c:set var="recordCounter" value="${recordCounter+1}"/>
    <tr>
        <td><a href = "edit/${u.id}"><c:out value="${recordCounter}"/></a></td>
        <td><a href = "edit/${u.id}"><c:out value="${u.id }" /></a></td>
        <td><a href = "edit/${u.id}"><c:out value="${u.name }" /></a></td>
        <td><a href = "edit/${u.id}"><c:out value="${u.lastName }" /></a></td>
        <td><a href = "edit/${u.id}"><c:out value="${u.email }" /></a></td>
        <td><a href = "edit/${u.id}">
            <c:choose>
                <c:when test="${u.active == 1 }">
                    <font color="green"><s:message code="word.yes"/></font>
                </c:when>
                <c:otherwise>
                    <font color="red"><s:message code="word.no"/></font>
                </c:otherwise>
            </c:choose>
        </a></td>
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
</table>
<table width="1000" border="0" cellpadding="6" cellspacing="0">
    <tr>
        <td align="left">
            <s:message code="word.page"/>&nbsp;${currentPageNumber}&#32;<s:message code="word.of"/>&nbsp;${totalPagesNumber}
        </td>

        <td align="right">

            <c:if test="${currentPageNumber > 1}">
                <input type="button" onclick="window.location.href='${pageContext.request.contextPath}/admin/users/${currentPageNumber-1}'"
                       value="<s:message code="word.previous"/>"/>&nbsp;&nbsp;
            </c:if>

            <c:if test="${currentPageNumber < totalPagesNumber}">
                <input type="button" onclick="window.location.href='${pageContext.request.contextPath}/admin/users/${currentPageNumber+1}'"
                       value="<s:message code="word.next"/>"/>&nbsp;&nbsp;
            </c:if>
        </td>
    </tr>
</table>
</div>
</body>
</html>
