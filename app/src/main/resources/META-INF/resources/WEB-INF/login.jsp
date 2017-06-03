<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Secure Login</title>
        <jsp:include page="/WEB-INF/style.jsp" />
    </head>
    <body>
        <c:if test="${param.containsKey('error')}">
            <h2 class="error">ユーザー名かパスワードが間違っています</h2>
        </c:if>
        <c:if test="${param.containsKey('logout')}">
            <h2 class="info">ログアウトしました</h2>
        </c:if>
        
        <c:url var="loginUrl" value="/login" />
        <form action="${loginUrl}" method="POST">
          <div class="form-item">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" autofocus />
          </div>

          <div class="form-item">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" />
          </div>

          <input type="submit" value="Login" />
          
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </body>
</html>
