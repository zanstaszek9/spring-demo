<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 23-Jan-20
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../incl/head.jsp" %>
    <title><s:message code="profile.userData"/></title><!-- TODO: Needs resolving! It must be include in <head>. Maybe using Thymeleaf?-->

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

        <tr>
            <td align="center">
                <input type="button" value="<s:message code="button.profileEdit"/>" onclick="window.location.href='${pageContext.request.contextPath}/editprofile'"/>
            </td>
        </tr>

    </table>

<%@include file="../incl/footer.jsp" %>
