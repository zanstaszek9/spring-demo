<sec:authorize access="hasRole('ROLE_ADMIN')">
    <nav width="100%" border="0" cellpadding="8" cellspacing="4" class="tableMenuAdmin">
        <ol>
            <li align="left">
                <a href="/admin/users/1"><s:message code="menu.users"/></a>&nbsp;&nbsp;
                <a href="/admin/users/importusers"><s:message code="menu.importUsers"/></a>
            </li>
        </ol>
    </nav>
</sec:authorize>