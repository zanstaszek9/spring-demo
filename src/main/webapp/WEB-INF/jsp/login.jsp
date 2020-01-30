<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 23-Jan-20
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s"   uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title><s:message code="menu.login" /></title>
</head>
<body>
<%@include file="../incl/menu.app"%>
<h2>
    <s:message code="menu.login" />
</h2>

    <form id="loginForm" action="/login" method="POST">

        <table width="350" border="0" cellpadding="4" cellspacing="1"
               align="center">

            <tr>
                <td colspan="2" align="center">
                    <c:if test="${not empty param.error}">  <!--    If param.error will not be empty, display the message below -->
                        <font color="red"><s:message code="error.login"/></font>    <!--TODO: Make message of inactive account-->
                    </c:if>
                </td>
            </tr>
            <tr>
                <td align="right" width="140">
                    <s:message code="register.email" />
                </td>
                <td align="left">
                    <input type="text" name="email" id="email"
                           size="30" />
                </td>
            </tr>
            <tr>
                <td align="right" width="140">
                    <s:message code="register.password" />
                </td>
                <td align="left">
                    <input type="password" name="password" id="password" size="30" />
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center" bgcolor="#ffffff"><input
                        type="submit" value="<s:message code="button.login"/>" class="formbutton"/></td>
            </tr>

        </table>
    </form>
</body>
</html>
