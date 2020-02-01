<%--
  Created by IntelliJ IDEA.
  User: StanislawZan
  Date: 27-Jan-20
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../../incl/head.jsp" %>
    <title><s:message code="menu.users"/></title><!-- TODO: Needs resolving! It must be include in <head>. Maybe using Thymeleaf?-->


<script>
    function startSearch() {
        let searchString = document.getElementById('searchString').value;

        if(searchString.length < 3){
            document.getElementById('errorSearch').innerHTML = "<s:message code="error.searchString.toShort"/>";
            return false;
        }
        else{
            document.getElementById('errorSearch').innerHTML= "";
            let searchLink = '${pageContext.request.contextPath}/admin/users/1?search='+searchString;
            window.location.href=searchLink;
        }
    }
</script>

<h1><s:message code="menu.users"/></h1>
<c:set var="recordCounter" value="${recordCounterStart}" scope="page"/>
<div>
    <div class = "searchButton" align="right" style="width: 1000px; padding: 2px";>
        <input type="text" id="searchString"/>&nbsp;&nbsp;<input type="button" value="<s:message code="button.search"/>" onclick="startSearch();"/><br/>
        <span id="errorSearch" style="color:red;"></span>
    </div>
<table class ="data"  width="1000" cellpadding="6" cellspacing="0">
    <tr class = label>
        <td width="35" align="center"></td>
        <td width="35" align="center"><s:message code="admin.user.id"/></td>
        <td width="200" align="center"><s:message code="register.name"/></td>
        <td width="200" align="center"><s:message code="register.lastName"/></td>
        <td width="220" align="center"><s:message code="register.email"/></td>
        <td width="60" align="center"><s:message code="profile.isActive"/></td>
        <td width="100" align="center"><s:message code="profile.role"/></td>
    </tr>
    <c:forEach var="u" items="${usersList }">
        <c:set var="recordCounter" value="${recordCounter+1}"/>
    <tr>
        <td><a href = "edit/${u.id}"><c:out value="${recordCounter}"/></a></td>
        <td><a href = "edit/${u.id}"><c:out value="${u.id }" /></a></td>
        <td><a href = "edit/${u.id}"><c:out value="${u.name }" /></a></td>
        <td><a href = "edit/${u.id}"><c:out value="${u.lastName }" /></a></td>
        <td><a href = "edit/${u.id}"><c:out value="${u.email }" /></a></td>
        <td><a href = "edit/${u.id}">
            <c:choose>
                <c:when test="${u.active == 1 }">
                    <font color="green"><s:message code="word.yes"/></font>
                </c:when>
                <c:otherwise>
                    <font color="red"><s:message code="word.no"/></font>
                </c:otherwise>
            </c:choose>
        </a></td>
        <td>
            <c:choose>
                <c:when test="${u.nrRole == 1 }">
                    <font color="green"><s:message code="word.admin"/></font>
                </c:when>
                <c:otherwise>
                    <font><s:message code="word.user"/></font>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
    </c:forEach>
</table>
<table class = "navigationButtons" width="1000" border="0" cellpadding="6" cellspacing="0">
    <tr>
        <td align="left">
            <s:message code="word.page"/>&nbsp;${currentPageNumber}&#32;<s:message code="word.of"/>&nbsp;${totalPagesNumber}
        </td>

        <td align="right">

            <c:if test="${currentPageNumber > 1}">
                <input type="button" onclick="window.location.href='${pageContext.request.contextPath}/admin/users/${currentPageNumber-1}${searchParam}'"
                       value="<s:message code="word.previous"/>"/>&nbsp;&nbsp;
            </c:if>

            <c:if test="${currentPageNumber < totalPagesNumber}">
                <input type="button" onclick="window.location.href='${pageContext.request.contextPath}/admin/users/${currentPageNumber+1}${searchParam}'"
                       value="<s:message code="word.next"/>"/>&nbsp;&nbsp;
            </c:if>
        </td>
    </tr>
</table>
</div>


<%@include file="../../incl/footer.jsp" %>

