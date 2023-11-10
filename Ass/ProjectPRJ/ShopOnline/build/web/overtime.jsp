<%-- 
    Document   : overtime
    Created on : Nov 1, 2023, 8:38:20 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, jakarta.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Display Current Date & Time</title>
</head>
<body>
<center>
<h1>Display Current Date & Time</h1>
</center>
<%
   Date date = new Date();
   Date date2 = new Date("16:00:00 PM");
   
   if(date > date2)
   out.print( "<h2 align=\"center\">" +aaa)+"</h2>");
%>
</body>
</html>
