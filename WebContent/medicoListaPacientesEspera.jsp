<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="lPacientesEnEspera" class="java.util.ArrayList" scope="session" />
<%@ page import="com.bean.PacienteEsperaBean"%>
<jsp:useBean id="DOCTOR" class="com.bean.MedicoBean" scope="session" />

         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Historial general de Consultas del Alumno</title>
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
			<li><a href="medicoPrincipal.jsp">Inicio</a></li>
			<li class="current_page_item"><a href="MostrarAlumnosEnEspera">Mostrar alumnos en espera</a></li>
			<li><a href="medicoLoginPrevioParaRecetar.jsp">Recetar al alumno</a></li>
			<li><a href="generalLoginPrevioaHistoriales.jsp">Historial del alumno</a></li>
			<li><a href="logoutServlet">Logout</a></li>
			
		</ul>
	</div>
</div>

<div id="page" class="container">
	
	
	<div id="bigbox">
	
	<h3>Datos del Médico:</h3> <br>
	Codigo: <%= DOCTOR.getCodigo() %> <br>
	Nombre: <%= DOCTOR.getNombre() %> <%= DOCTOR.getApellido() %>
	<br>
	<br>

Lista de pacientes pendientes: <br>

    <form method="post" action="confirmarAtencion">
	<table border=3>
	
	    <tr>
	    		<td>Codigo de cita</td>
				<td>Codigo</td>
				<td>Nombre</td>
				<td>Apellido</td>
				<td>Hora y Fecha Solicitada</td>
				
				
				</tr>
				
				<%
				
					for (int i = 0; i < lPacientesEnEspera.size(); i++) {
				%>
		<tr>
			<td>  <%=((PacienteEsperaBean) lPacientesEnEspera.get(i)).getCod_cita()%>  </td>
		    <td>  <%=((PacienteEsperaBean) lPacientesEnEspera.get(i)).getCodigo()%>  </td>
			<td>  <%=((PacienteEsperaBean) lPacientesEnEspera.get(i)).getNombre()%>  </td>
			<td>  <%=((PacienteEsperaBean) lPacientesEnEspera.get(i)).getApellido()%>        </td>
			<td>  <%=((PacienteEsperaBean) lPacientesEnEspera.get(i)).getFecha_pedida()%>        </td>
			
				<input type="hidden" name="cod_cita" value="<%=((PacienteEsperaBean) lPacientesEnEspera.get(i)).getCod_cita()%>">
			<td><input type="radio" name="cod_Espera" value="<%=((PacienteEsperaBean) lPacientesEnEspera.get(i)).getCod_horario()%>"></td>
				
				<tr>
				<%
					}
				%>
	
	
	
	</table>
	
	<br>
	
	   <input type="submit" value="Confirmar Atención">
			 </form>
		
		
		
	</div>
	
	
	
</div>

<%@include file="layouts/footer.jsp" %>

</body>
</html>
