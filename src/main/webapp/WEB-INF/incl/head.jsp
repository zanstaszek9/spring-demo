<%--
  Created by IntelliJ IDEA.
  User: Stasio
  Date: 30.01.2020
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--    Adding hadling for required tags    --%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>

    <!--<script type="text/javascript" src="/script/script.js"></script>-->
</head>
<body>
<%@include file="../incl/menu.jsp" %> <%-- Including Menu code TODO: Testing .jsp menu file. Erase if works!--%>
    <div class="content">

