<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Click Jacking</title>
        <jsp:include page="/WEB-INF/style.jsp" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/menu.jsp" />
        
        <h2>Click Jacking</h2>
        
        <%pageContext.setAttribute("contextPath", request.getContextPath().replace("/", ""));%>
        <a href="https://opengl-8080.github.io/spring-security-sample/click-jacking.html?${contextPath}">攻撃を再現</a>
        
        <c:url var="clickJackingUrl" value="/click-jacking" />
        
        <form action="${clickJackingUrl}" method="POST">
            <input type="submit" value="Count up" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        
        <h3>count = ${counter.get()}</h3>
    </body>
</html>
