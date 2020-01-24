<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 21-Jan-20
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--    Adding hadling for required tags    --%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><s:message code="menu.register"/></title>
</head>
<body>
<%@include file="../incl/menu.app" %> <%-- Including Menu code --%>
<h2><s:message code="menu.register"/></h2>

<p align="center">
    <c:out value="${message }" />   <%--    Displaying value returned by controller--%>
</p>

    <sf:form id="usersForm" action="adduser" modelAttribute="user"
             enctype="multipart/form-data" method="POST"> <%-- Sends attribute to Controller class --%>

        <table width="500" border="0" cellpadding="4" cellspacing="1"
               align="center">

            <tr>
                <td width="130" align="right" ><s:message code="register.name"/></td>
                <td width="270" align="left"><sf:input path="name"
                                                       size="28" id="name" /></td>
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
                <td width="130" align="right" ><s:message code="register.password"/></td>
                <td width="270" align="left"><sf:password path="password" size="28" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><font color="red"><sf:errors path="password"/></font></td>
            </tr>

            <tr>
                <td colspan="2" align="center" bgcolor="#fff">
                    <input type="submit" value="<s:message code="button.register"/>" class="formbutton"/>
                    <input type="button" value="<s:message code="button.cancel"/>" class="formbutton"
                           onclick="window.location.href='${pageContext.request.contextPath}/'"/>
                </td>
            </tr>

        </table>

    </sf:form>


</body>
</html>
