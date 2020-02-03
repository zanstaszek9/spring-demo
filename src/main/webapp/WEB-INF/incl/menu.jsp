<nav class="tableMenuBg">
    <ol>
        <li><a href="/"><s:message code="menu.mainPage"/></a>&nbsp;&nbsp;</li>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/admin"><s:message code="menu.adminPage"/></a></li>
        </sec:authorize>

        <sec:authorize access="hasRole('ANONYMOUS')">
            <li class="liright"><a href="/login"><s:message code="menu.login"/></a>&nbsp;&nbsp;</li>
            <li><a href="/register"><s:message code="menu.register"/></a>&nbsp;&nbsp;</li>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <li class="liright"><a href="/profile"><s:message code="menu.profile"/></a>&nbsp;&nbsp;</li>
            <li><a href="/logout"><s:message code="menu.logout"/></a></li>
        </sec:authorize>
    </ol>
</nav>
<%@include file="menuadmin.jsp"%>