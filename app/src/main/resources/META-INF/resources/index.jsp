<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Menu</title>
    </head>
    <body>
        <c:url var="xxss" value="/x-xss.jsp" />
        
        <ul>
            <li>X-XSS-Protection <code>http://localhost:8080${xxss}?message=&lt;script&gt;alert('X-XSS!!')&lt;/script&gt;</code></li>
        </ul>
    </body>
</html>
