<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 25-Jan-20
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../incl/head.jsp" %>
    <title><s:message code="menu.profileEdit"/></title><!-- TODO: Needs resolving! It must be include in <head>. Maybe using Thymeleaf?-->


<p align="center">
    <font face="sans-serif" size="5">
        <c:out value="${message }" />
    </font>
</p>

<script type="text/javascript">
    function leaveToURL(path) {
        window.location = '${pageContext.request.contextPath}/'+path;
    }
    setTimeout("leaveToURL('logout')", 1700);
</script>
<%@include file="../incl/footer.jsp" %>
