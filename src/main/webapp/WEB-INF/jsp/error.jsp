<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 23-Jan-20
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../incl/head.jsp" %>
    <title><s:message code="error.errorPage"/></title><!-- TODO: Needs resolving! It must be include in <head>. Maybe using Thymeleaf?-->

<img src="/resources/images/errorimage.png">
<h2><s:message code="error.defaultErrorMessage"/></h2>

<%@include file="../incl/footer.jsp" %>
