<%-- 
    Document   : index
    Created on : 26.06.2019, 15:05:32
    Author     : ignat_nakhai
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
                
            }
            textarea {
                width:450px;
                height:150px;
                align:center;
            }
            input {
                width:450px;
                align-self: center;
            }
            
        </style>
    </head>
    <body>
        <h1>Telegrach</h1>
        <form action="./" method="POST">       
            <input type="text" placeholder="Заголовок" name="title" value="${title}">
            <br/>  <br/>
            <input type="text" placeholder="Подпись" name="autor" value="${autor}">
            <br/>  <br/>
            <p><b>Введите ваш текст:</b></p>
            <p><textarea name="text">${text}</textarea></p>
            <br /> 
            <input type="submit" value="Add new post">
        </form>
    </body>
</html>