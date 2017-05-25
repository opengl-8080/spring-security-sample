<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Click Jacking</title>
        <style>
          body {
            background-color: ${backgroundColor};
          }
        </style>
    </head>
    <body>
        <jsp:include page="/menu.jsp" />
        
        <h2>Click Jacking</h2>
        
        <%pageContext.setAttribute("contextPath", request.getContextPath().replace("/", ""));%>
        <a href="https://opengl-8080.github.io/spring-security-sample/click-jacking-${contextPath}.html">攻撃を再現</a>
        
        <c:url var="clickJackingUrl" value="/click-jacking" />
        
        <form action="${clickJackingUrl}" method="POST">
            <input type="submit" value="Count up" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        
        <h3>count = ${counter.get()}</h3>
    </body>
</html>
