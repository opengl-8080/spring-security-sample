<c:url var="homeUrl" value="/home" />
<a href="${homeUrl}">Top</a>

<c:url var="logoutUrl" value="/logout" />
<form action="${logoutUrl}" method="POST" style="display: inline; margin-left: 10px;">
    <input type="submit" value="Logout" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
