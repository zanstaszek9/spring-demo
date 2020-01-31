<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 24-Jan-20
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../incl/head.jsp" %>
    <title><s:message code="button.passwordChange"/></title><!-- TODO: Needs resolving! It must be include in <head>. Maybe using Thymeleaf?-->


    <h2><s:message code="button.passwordChange"/></h2>

    <p align="center">
        <c:out value="${message }" />
    </p>

    <sf:form id="usersForm" action="updatepass" modelAttribute="user"
             enctype="multipart/form-data" method="POST">

        <sf:hidden path="email"/>

        <table width="500" border="0" cellpadding="4" cellspacing="1"
               align="center">

            <!-- Added field for typing old password -->
            <tr>
                <td width="130" align="right" ><s:message code="passwordChange.oldPassword"/></td>
                <td width="270" align="left"><sf:password path="oldPassword" size="28" /></td>
            </tr>
            <tr>
                <!-- Added for Old Password Errors handling from Validator -->
                <td colspan="2" align="center"><font color="red"><sf:errors path="oldPassword"/></font></td>
            </tr>

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
<%@include file="../incl/footer.jsp" %>
