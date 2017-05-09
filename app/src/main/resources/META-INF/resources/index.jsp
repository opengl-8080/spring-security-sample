<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Menu</title>
    </head>
    <body>
        <jsp:include page="/menu.jsp" />
        
        <c:url var="xxss" value="/x-xss.jsp" />
        <c:url var="csrf" value="/csrf" />
        
        <ul>
            <li><a href="${xxss}?message=Hello+World!!">X-XSS</a></li>
            <li><a href="${csrf}">CSRF</a></li>
        </ul>
    </body>
</html>
