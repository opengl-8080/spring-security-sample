<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>CSRF</title>
    </head>
    <body>
        <h2>CSRF</h2>
        
        <c:url var="csrfUrl" value="/csrf" />
        
        <form action="${csrfUrl}" method="POST">
            <div>
                <label>value : <input type="text" name="value" /></label>
            </div>
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
