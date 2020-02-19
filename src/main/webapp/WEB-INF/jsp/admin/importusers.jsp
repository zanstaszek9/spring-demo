<%--
  Created by IntelliJ IDEA.
  User: Stasio
  Date: 01.02.2020
  Time: 01:55
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../../incl/head.jsp" %>
<title><s:message code="menu.importUsers"/></title> <!-- TODO: Needs resolving! It must be include in <head>. Maybe using Thymeleaf?-->

<h2><s:message code="menu.importUsers"/></h2>

<sf:form id = "uploadForm" action="${pageContext.request.contextPath}/admin/users/upload" method="post" modelAttribute="fileupload" enctype="multipart/form-data">
    <input type="file" name="filename" id="filename"/>
    <input type="submit" value="<s:message code="button.upload"/>"/>
</sf:form>

<%@include file="../../incl/footer.jsp" %>

