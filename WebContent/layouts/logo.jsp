<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="bfecha" class="com.bean.FechaBean" />

<div id="logo" class="container">
	<img height="50" width="135" src="images/Logo.jpg" /> 
	<center><h2 class=title><font size="10"><a href="#">BIENVENIDO AL SISTEMA MEDICO</a></font></h2></center>
	<br>
	Fecha: <%= (bfecha.getFecha())%> Hora: <%= (bfecha.getHora()) %>:<%=(bfecha.getMinutos()) %>:<%= bfecha.getSegundos()%>
</div>