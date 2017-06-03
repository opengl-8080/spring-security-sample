<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>X-XSS</title>
        <jsp:include page="/WEB-INF/style.jsp" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/menu.jsp" />
        
        <h2>X-XSS</h2>
        
        <h3>message = ${param['message']}</h3>
        
        <a href="https://opengl-8080.github.io/spring-security-sample/x-xss.html">攻撃を再現</a>
    </body>
</html>
