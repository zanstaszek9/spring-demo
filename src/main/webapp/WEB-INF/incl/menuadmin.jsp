<sec:authorize access="hasRole('ROLE_ADMIN')">
    <nav class="tableMenuAdmin">
        <ol>
            <li ="left"><a href="/admin/users/1"><s:message code="menu.users"/></a>&nbsp;&nbsp;</li>
            <li><a href="/admin/users/importusers"><s:message code="menu.importUsers"/></a></li>
            <li><a href="/admin/charts"><s:message code="menu.charts"/></a></li>
        </ol>
    </nav>
</sec:authorize>