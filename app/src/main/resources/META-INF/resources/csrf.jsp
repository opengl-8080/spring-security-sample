<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>CSRF</title>
        <jsp:include page="/style.jsp" />
    </head>
    <body>
        <jsp:include page="/menu.jsp" />
        
        <h2>CSRF</h2>
        
        <a href="https://opengl-8080.github.io/spring-security-sample/csrf.html">攻撃を再現</a>
        
        <c:url var="csrfUrl" value="/csrf" />
        
        <form action="${csrfUrl}" method="POST">
            <label>value : <input type="text" name="value" /></label>
            <input type="submit" value="Submit" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        
        <ul>
            <c:forEach var="value" items="${values}">
                <li>${value}</li>
            </c:forEach>
        </ul>
    </body>
</html>
