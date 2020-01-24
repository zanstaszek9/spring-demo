<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 24-Jan-20
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title><s:message code="button.passwordChange"/></title>
</head>
<body>

    <%@include file="../incl/menu.app" %>

    <h2><s:message code="button.passwordChange"/></h2>

    <p align="center">
        <c:out value="${message }" />
    </p>

    <sf:form id="usersForm" action="updatepass" modelAttribute="user"
             enctype="multipart/form-data" method="POST">

        <sf:hidden path="email"/>

        <table width="500" border="0" cellpadding="4" cellspacing="1"
               align="center">

            <tr>
                <td width="130" align="right" ><s:message code="passwordChange.newPassword"/></td>
                <td width="270" align="left"><sf:password path="newPassword" size="28" /></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><font color="red"><sf:errors path="newPassword"/></font></td>    <!-- Field for Errors handling from Validator -->
            </tr>

            <tr>
                <td colspan="2" align="center" bgcolor="#fff">
                    <input type="submit" value="<s:message code="button.passwordChange"/>" />
                    <input type="button" value="<s:message code="button.cancel"/>"
                           onclick="window.location.href='${pageContext.request.contextPath}/profile'"/>
                </td>
            </tr>
        </table>

    </sf:form>
</body>
</html>
