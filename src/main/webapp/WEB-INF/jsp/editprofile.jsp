<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 25-Jan-20
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../incl/head.jsp" %>
    <title><s:message code="menu.profileEdit"/></title><!-- TODO: Needs resolving! It must be include in <head>. Maybe using Thymeleaf?-->

<h2 align="center"><s:message code="menu.profileEdit"/></h2>

<sf:form id="usersForm" action="updateprofile" modelAttribute="user"
         enctype="multipart/form-data" method="POST">

    <sf:hidden path="id"/>

    <table width="500" border="0" cellpadding="4" cellspacing="1"
           align="center">

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
            <td colspan="2" align="center" bgcolor="#fff">
                <input type="submit" value="<s:message code="button.save"/>" />
                <input type="button" value="<s:message code="button.cancel"/>"
                       onclick="window.location.href='${pageContext.request.contextPath}/profile'"/>
            </td>
        </tr>

    </table>

</sf:form>

<%@include file="../incl/footer.jsp" %>
