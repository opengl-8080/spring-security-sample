<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Home</title>
        <jsp:include page="/WEB-INF/style.jsp" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/menu.jsp" />
        
        <c:url var="xxss" value="/x-xss" />
        <c:url var="csrf" value="/csrf" />
        <c:url var="headerInjection" value="/header-injection" />
        <c:url var="clickJacking" value="/click-jacking" />
        
        <ul>
            <li><a class="list-link list-item" href="${xxss}?message=Hello+World!!">X-XSS</a></li>
            <li><a class="list-link list-item" href="${csrf}">CSRF</a></li>
            <li><a class="list-link list-item" href="${headerInjection}">Header Injection</a></li>
            <li><a class="list-link list-item" href="${clickJacking}">Click Jacking</a></li>
        </ul>
    </body>
</html>
