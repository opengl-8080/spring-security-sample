<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Menu</title>
    </head>
    <body>
        <c:url var="logoutUrl" value="/logout" />
        <form action="${logoutUrl}" method="POST">
            <input type="submit" value="logout" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        
        <c:url var="xxss" value="/x-xss.jsp" />
        <c:url var="csrf" value="/csrf" />
        
        <ul>
            <li><a href="${xxss}?message=Hello+World!!">X-XSS</a></li>
            <li><a href="${csrf}">CSRF</a></li>
        </ul>
    </body>
</html>
