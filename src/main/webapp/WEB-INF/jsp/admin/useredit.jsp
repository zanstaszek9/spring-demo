<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 30.01.2020
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title><s:message code="admin.user.edit"/></title>
</head>
<body>
    <%@include file="../../incl/menu.app" %>
    <h2><s:message code="admin.user.edit"/></h2>
    <p align="center">
        <c:out value="${message }" />
    </p>
    <sf:form id="usersForm" action="${pageContext.request.contextPath}/admin/users/update/${user.id}" modelAttribute="user"
             enctype="multipart/form-data" method="POST"><!--TODO:Button for password resetting-->
        <sf:hidden path="id" value="${user.id}"/>
        <table width="500" border="0" cellpadding="4" cellspacing="1" align="center">
            <tr>
                <td width="130" align="right" ><s:message code="register.name"/></td>
                <td width="270" align="left"><sf:input path="name" size="28" id="name" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><font color="red"><sf:errors path="name"/></font></td>
            </tr>

            <tr>
                <td width="130" align="right"><s:message code="register.lastName"/></td>
                <td width="270" align="left"><sf:input path="lastName" size="28" /></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><font color="red"><sf:errors path="lastName"/></font></td>
            </tr>

            <tr>
                <td width="130" align="right" ><s:message code="register.email"/></td>
                <td width="270" align="left"><sf:input path="email" size="28" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><font color="red"><sf:errors path="email"/></font></td>
            </tr>

            <tr>
                <td width="130" align="right" ><s:message code="profile.role"/></td>
                <td width="270" align="left"><sf:select path="nrRole" items="${roleMap}"/></td>
            </tr>

            <tr>
                <td width="130" align="right" ><s:message code="profile.isActive"/></td>
                <td width="270" align="left"><sf:select path="active" items="${activityMap}"/></td>
            </tr>

            <tr>
                <td colspan="2" align="center" bgcolor="#fff">
                    <input type="submit" value="<s:message code="button.save"/>" />
                    <input type="button" value="<s:message code="button.cancel"/>"
                           onclick="window.location.href='${pageContext.request.contextPath}/admin/users/1'"/>
                </td>
            </tr>
        </table>
    </sf:form>
</body>
</html>
