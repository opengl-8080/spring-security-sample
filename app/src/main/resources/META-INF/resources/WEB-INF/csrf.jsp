<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>CSRF</title>
        <jsp:include page="/WEB-INF/style.jsp" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/menu.jsp" />
        
        <h2>CSRF</h2>
        
        <a href="https://opengl-8080.github.io/spring-security-sample/csrf.html">攻撃を再現</a>
        
        <c:url var="csrfUrl" value="/csrf" />
        
        <form action="${csrfUrl}" method="POST">
            <div class="form-item">
                <label for="value">Value</label>
                <input type="text" id="value" name="value" />
                <input type="submit" value="Add" />
            </div>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        
        <ul>
            <c:forEach var="value" items="${values.get()}">
                <li class="list-item">${value}</li>
            </c:forEach>
        </ul>
    </body>
</html>
