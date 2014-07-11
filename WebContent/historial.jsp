<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="PACIENTE" class="com.bean.PacienteBean" scope="session" />   
<jsp:useBean id="LISTAREGISTROALUMNO" class="java.util.ArrayList"
	scope="session" />
<%@ page import="com.bean.RegistrosAlumno"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pagina de Historial del Usuario</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700" rel="stylesheet" type="text/css">
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body>

<%@include file="layouts/logo.jsp" %>

<div id="menu-wrapper">
	<div id="menu" class="container">
		<ul>
			<li><a href="principal.jsp">Inicio</a></li>
			<li><a href="solpastilla.jsp">Peticion Medicamento</a></li>
			<li><a href="solconsulta.jsp">Consulta Medica</a></li>
			<li class="current_page_item"><a href="historial.jsp">Historial</a></li>
			<li><a href="cancelarmed.jsp">Cancelar Medicamento</a></li>
			<li><a href="cancelarcita.jsp">Cancelar Cita</a></li>
			<li><a href="logoutServlet">Logout</a></li>
			
		</ul>
	</div>
</div>

<div id="page" class="container">
	<div id="box4">
		<h2 class="title">Datos del Alumno</h2>
		<div style="clear: both;">&nbsp;</div>
		<div class="entry">
			<ul class="style1">
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
			</ul>
		</div>
		
	</div>
	
	<div id="bigbox">
	
		<h3 class="title">Historial</h3>
		
		<table border=3>

    
				<tr>
				<td>Medicamento</td>
				<td>Cantidad Pedida</td>
				<td>Hora </td>
				<td>Fecha</td>
				<td>Estado</td>
				</tr>
				
					
				<%
				
					for (int i = 0; i < LISTAREGISTROALUMNO.size(); i++) {
				%>
				
				
				<tr>
				
		    
		    <td>  <%=((RegistrosAlumno) LISTAREGISTROALUMNO.get(i)).getMedicamento()%></td>
			<td>  <%=((RegistrosAlumno) LISTAREGISTROALUMNO.get(i)).getCantidad()%></td>
			<td>  <%=((RegistrosAlumno) LISTAREGISTROALUMNO.get(i)).getHora()%></td>
			<td>  <%=((RegistrosAlumno) LISTAREGISTROALUMNO.get(i)).getFecha()%></td>
			<td>  <%=((RegistrosAlumno) LISTAREGISTROALUMNO.get(i)).getEstado()%></td>
			
				</tr>
				<%
					}
				%>

              

			</table>
		
		
	</div>
	
</div>

<%@include file="layouts/footer.jsp" %>

</body>
</html>
