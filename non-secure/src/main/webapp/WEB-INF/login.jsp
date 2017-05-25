<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Non-Secure Login</title>
        <c:url var="cssUrl" value="/css/style.css" />
        <link rel="stylesheet" href="${cssUrl}" />
        <style>
          body {
            background-color: ${backgroundColor};
          }
        </style>
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
          <div>
            <label>Username : <input type="text" name="username" autofocus /></label>
          </div>
          <div>
            <label>Password : <input type="password" name="password" /></label>
          </div>
          <input type="submit" value="Login" />
        </form>
    </body>
</html>
