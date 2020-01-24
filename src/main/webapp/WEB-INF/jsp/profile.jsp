<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 23-Jan-20
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title><s:message code="profile.userData"/></title>
</head>
<body>

    <%@include file="../incl/menu.app" %>
    <div align="center">
        <h2><s:message code="profile.userData"/></h2>
    </div>

    <table width="500" border="0" cellpadding="4" cellspacing="1" align="center">

        <tr>
            <td width="130" align="right" >
                <s:message code="register.email"/></td>
            <td width="270" align="left">
                <c:out value="${user.email}"/>
            </td>
        </tr>

        <tr>
            <td width="130" align="right" >
                <s:message code="register.name"/></td>
            <td width="270" align="left">
                <c:out value="${user.name}"/>
            </td>
        </tr>

        <tr>
            <td width="130" align="right" >
                <s:message code="register.lastName"/>
            </td>
            <td width="270" align="left">
                <c:out value="${user.lastName}"/>
            </td>
        </tr>

        <tr>
            <td width="130" align="right" >
                <s:message code="profile.isActive"/>
            </td>
            <td width="270" align="left">
                <c:choose>
                    <c:when test="${user.active == 1}">
                        <s:message code="word.yes"/>
                    </c:when>
                    <c:otherwise>
                        <s:message code="word.no"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

        <tr>
            <td width="130" align="right" >
                <s:message code="profile.role"/>
            </td>
            <td width="270" align="left">
                <c:choose>
                    <c:when test="${user.nrRole == 1}">
                        <s:message code="word.admin"/>
                    </c:when>
                    <c:otherwise>
                        <s:message code="word.user"/>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

    </table>

    <table width="500" border="0" cellpadding="4" cellspacing="1" align="center">

        <tr>
            <td align="center">
                <input type="button" value="<s:message code="button.passwordChange"/>" onclick="window.location.href='${pageContext.request.contextPath}/editpassword'"/>
            </td>
        </tr>

    </table>

</body>
</html>
