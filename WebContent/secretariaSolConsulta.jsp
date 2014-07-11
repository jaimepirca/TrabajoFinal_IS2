<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="PACIENTE" class="com.bean.PacienteBean" scope="session" />   
<jsp:useBean id="LISTAMEDICOS" class="java.util.ArrayList" scope="session" />  
<%@page import="com.bean.MedicoBean" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pagina de Solicitud de Consulta</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700" rel="stylesheet" type="text/css">
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body>

<%@include file="layouts/head.jsp" %>

<div id="menu-wrapper">
	<div id="menu" class="container">
		<ul>
			<li><a href="principalSecretaria.jsp">Inicio</a></li>
			<li><a href="listaHistorialGeneralConsulta">Lista de Consultas en Espera</a></li>
			<li class="current_page_item"><a href="secretariaLoginPrevioaConsultas.jsp">Registro de consulta</a></li>
			<li><a href="logoutServlet">Logout</a></li>
			
		</ul>
	</div>
</div>


<div id="page" class="container">
	<div id="box4">
		<h2 class="title">Seleccione el Médico</h2>
		<form method="post" action="doctorServlet">
			<select name="codMedico">
	
				<% for (int i=0; i < LISTAMEDICOS.size(); i++ ) { %>
    				<option 
    				value="<%= ((MedicoBean)LISTAMEDICOS.get(i)).getCodigo() %>">
	    			<%= ((MedicoBean)LISTAMEDICOS.get(i)).getNombre() %> <%= ((MedicoBean)LISTAMEDICOS.get(i)).getApellido() %>
    		</option>
    			<% } %>
    		</select>
		
			<br>
			<br>
		
			<input type="submit" value="Continuar" />
			<br>
			<br>
			<input type="reset" value="Limpiar" />	
		</form><br>
		
		<h2 class="title">Datos del Alumno</h2>
	
				<table>
					<tr>
						<td>Codigo:</td>
						<td><%= PACIENTE.getCodigo() %></td>
					</tr>
					<tr>
						<td>Nombre:</td>
						<td><%= PACIENTE.getNombre() %></td>
					</tr>
					<tr>
						<td>Apellido:</td>
						<td><%= PACIENTE.getApellido() %></td>
					</tr>
				</table>
			

		
		
	</div><br>
	
	
	<div id="box2">
		<h2 class="title">Staff Médico</h2>
		<h3>Medicina interna</h3><br><br>
		Dr. Raúl Acosta Salazar<br>
		De lunes a viernes de 08.00 a 13.00 horas.<br><br>
		Dr. José Luis Montoya<br>
		De lunes a viernes de 13.00 a 18.00 horas.<br><br>
		Dra. Juana Hinostroza<br>
		De lunes a viernes de 14.00 a 19.00 horas.<br><br>
		<h3>Traumatología y Medicina General</h3><br><br>
		Dr. Raúl Aguilar Correa<br>
		De lunes a viernes de 07.00 a 12.00 horas.<br><br>
		
	</div>
	
	<div id="box3">
		<h3>Dermatología y medicina general</h3><br><br>
		Dr. Fernando Magill Cisneros <br>
		Lunes, miércoles y viernes de 09.00 a 10.00 horas. <br>
		Martes y jueves de 16.00 a 17.00 horas.<br><br>
		<h3>Medicina general</h3><br><br>
		Dr. Hugo Sobrevilla Daniels<br>
		De lunes a viernes de 17.00 a 22.00 horas.<br><br>
		<h3>Nutrición</h3><br><br>
		Lic. Gricelda Chang<br>
		De lunes a viernes de 08.00 a 09.00 horas y de 16.00 a 18.00 horas.<br><br>
	</div>
	
</form>
</div>

<%@include file="layouts/footer.jsp" %>

</body>
</html>
