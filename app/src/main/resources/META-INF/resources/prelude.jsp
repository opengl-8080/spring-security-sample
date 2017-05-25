<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String contextPath = request.getContextPath();
    String backgroundColor = contextPath.equals("/non-secure") ? "#ffccd5" : "#ccf1ff";
    pageContext.setAttribute("backgroundColor", backgroundColor);
%>
