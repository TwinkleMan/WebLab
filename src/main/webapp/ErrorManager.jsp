<%--Author: Esin A., created 11.10.2021
    error manager page--%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error processing</title>
    </head>
    <body>
        <h1>Error page</h1>
        <h2>Received exception:
            <FONT color="red"><%=exception.toString()%></FONT>
        </h2>
    </body>
</html>
