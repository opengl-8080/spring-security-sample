<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Non-Secure Login</title>
    </head>
    <body>
        <c:url var="loginUrl" value="/login" />
        
        <h2 style="color: red;">${param['errorMessage']}</h2>
        
        <form action="${loginUrl}" method="POST">
          <div>
            <label>Username : <input type="text" name="username" /></label>
          </div>
          <div>
            <label>Password : <input type="password" name="password" /></label>
          </div>
          <input type="submit" value="Login" />
        </form>
    </body>
</html>
