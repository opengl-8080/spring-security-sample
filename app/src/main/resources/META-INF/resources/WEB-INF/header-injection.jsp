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
            <div class="inline-form-item">
                <label for="headerName">Header-Name</label>
                <textarea id="headerName" name="headerName"></textarea>
            </div>
            <div class="inline-form-item">
                <label for="headerValue">Header-Value</label>
                <textarea id="headerValue" name="headerValue"></textarea>
            </div>
            
            <div>
                <input type="submit" value="Submit" />
                
                <input type="checkbox" id="removeLineSeparator" name="removeLineSeparator" value="true" />
                <label for="removeLineSeparator">改行コードを明示的に除去する</label>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </body>
</html>
