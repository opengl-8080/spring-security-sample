<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Header Injection</title>
        <jsp:include page="/WEB-INF/style.jsp" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/menu.jsp" />
        
        <h2>Header Injection</h2>
        
        <c:url var="headerInjectionUrl" value="/header-injection" />
        
        <form action="${headerInjectionUrl}" method="POST">
            <div>
                <label>
                    Header-Name <textarea name="headerName"></textarea>
                </label>
            </div>
            <div>
                <label>
                    Header-Value <textarea name="headerValue"></textarea>
                </label>
            </div>
            <div>
                <label>
                    <input type="checkbox" name="removeLineSeparator" value="true" /> 改行コードを明示的に除去する
                </label>
            </div>
            <input type="submit" value="Submit" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </body>
</html>
