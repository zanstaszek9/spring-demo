<table width="100%" border="0" cellpadding="8" cellspacing="4" class="tableMenuBg" bgcolor="#e6f2ff">
	<tr>
		<td align="left" width="900">
			<a href="/"><s:message code="menu.mainPage"/></a>&nbsp;&nbsp;
		</td>
		<td align="right">
		<sec:authorize access="hasRole('ANONYMOUS')">
			<a href="/login"><s:message code="menu.login"/></a>&nbsp;&nbsp;
			<a href="/register"><s:message code="menu.register"/></a>&nbsp;&nbsp;
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<a href="/profile"><s:message code="menu.profile"/></a>
			<a href="/logout"><s:message code="menu.logout"/></a>
		</sec:authorize>
		</td>
	</tr>
</table>