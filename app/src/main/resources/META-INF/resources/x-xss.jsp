<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>X-XSS</title>
    </head>
    <body>
        <jsp:include page="/menu.jsp" />
        
        <h2>message = ${param['message']}</h2>
        
        <a href="https://opengl-8080.github.io/spring-security-sample/x-xss.html">攻撃を再現</a>
    </body>
</html>
