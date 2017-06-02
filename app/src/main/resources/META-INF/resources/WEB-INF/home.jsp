<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Menu</title>
        <jsp:include page="/WEB-INF/style.jsp" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/menu.jsp" />
        
        <c:url var="xxss" value="/x-xss" />
        <c:url var="csrf" value="/csrf" />
        <c:url var="headerInjection" value="/header-injection" />
        <c:url var="clickJacking" value="/click-jacking" />
        
        <ul>
            <li><a href="${xxss}?message=Hello+World!!">X-XSS</a></li>
            <li><a href="${csrf}">CSRF</a></li>
            <li><a href="${headerInjection}">Header Injection</a></li>
            <li><a href="${clickJacking}">Click Jacking</a></li>
        </ul>
    </body>
</html>
