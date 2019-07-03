<%-- 
    Document   : pattern
    Created on : 27.06.2019, 14:37:12
    Author     : ignat_nakhai
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${title}</h1>
        <h2>${autor}</h2>
        <p>${text}</p>
 <c:if test="${allow_edit}"><p><a href="./${id}/edit/">Edit</a></p></c:if>
    </body>
</html>
