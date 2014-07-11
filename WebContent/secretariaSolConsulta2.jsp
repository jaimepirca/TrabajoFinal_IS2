<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="PACIENTE" class="com.bean.PacienteBean" scope="session" />   
<jsp:useBean id="MEDICO" class="com.bean.MedicoBean" scope="session" />   
<jsp:useBean id="HORARIOS" class="java.util.ArrayList" scope="session" />

<jsp:useBean id="HorarioMedico" class="java.util.ArrayList" scope="session" />
<%@page import="com.bean.HorarioMedico" %>    
    
    
    
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
			<li><a href="secretariaPrincipal.jsp">Inicio</a></li>
			<li><a href="listaHistorialGeneralConsulta">Lista de Consultas en Espera</a></li>
			<li class="current_page_item"><a href="secretariaLoginPrevioaConsultas.jsp">Registro de consulta</a></li>
			<li><a href="logoutServlet">Logout</a></li>
			
		</ul>
	</div>
</div>

<div id="page" class="container">
<form method="post" action="regConsulta">
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
	
		<h2 class="title">Datos del Doctor</h2>
		<div style="clear: both;">&nbsp;</div>
		<div class="entry">
			<ul class="style1">
				<table>
					<tr>
						<td>RUC:</td>
						<td><%= MEDICO.getRuc() %></td>
					</tr>
					<tr>
						<td>Nombre:</td>
						<td><%= MEDICO.getNombre() %></td>
					</tr>
					<tr>
						<td>Apellido:</td>
						<td><%= MEDICO.getApellido() %></td>
					</tr>
				</table>
			
			</ul>
		</div>
	
		
		
		
	</div>
	
	<div id="box2">
		<input type="hidden" name="fecha" value="<%= (bfecha.getFecha()) %>">
		<input type="hidden" name="hora" value="<%= (bfecha.getHora()) %>:<%=(bfecha.getMinutos()) %>:<%= bfecha.getSegundos()%>">
	Horario disponible del médico, por favor seleccione el horario que quiera reservar.
	
		<table border="1">
			<tr>
				<td>Hora</td>
				<td><%= ((HorarioMedico)HorarioMedico.get(0)).getDia() %></td>
				<td><%= ((HorarioMedico)HorarioMedico.get(5)).getDia() %></td>
				<td><%= ((HorarioMedico)HorarioMedico.get(10)).getDia() %></td>
				<td><%= ((HorarioMedico)HorarioMedico.get(15)).getDia() %></td>
				<td><%= ((HorarioMedico)HorarioMedico.get(20)).getDia() %></td>

				
			</tr>
		
			<tr>
				<td><%= ((HorarioMedico)HorarioMedico.get(0)).getHora() %></td>
				
				<% for (int i=1;i<=5;i++){ %>
					<% if(((HorarioMedico)HorarioMedico.get(i*5 - 5)).getEstado().equals("Disponible")){ %>
					<td><input type="radio" name="fechahora" value="<%= ((HorarioMedico)HorarioMedico.get(i*5 -5)).getCod_horario() %>"></td>
					<% } else {%>
					<td bgcolor="DCDCDC"><input type="radio" name="fechahora" value="<%=i%>" disabled></td>
					<% } %>
				<% } %>
				
			</tr>
			
			<tr>
				<td><%= ((HorarioMedico)HorarioMedico.get(1)).getHora() %></td>
				<% for (int i=1;i<=5;i++){ %>
					<% if(((HorarioMedico)HorarioMedico.get(i*5 - 4)).getEstado().equals("Disponible")){ %>
					<td><input type="radio" name="fechahora" value="<%= ((HorarioMedico)HorarioMedico.get(i*5 -4)).getCod_horario() %>"></td>
					<% } else {%>
					<td bgcolor="DCDCDC"><input type="radio" name="fechahora" value="<%=i%>" disabled></td>
					<% } %>
				<% } %>
			</tr>
			
			<tr>
				<td><%= ((HorarioMedico)HorarioMedico.get(2)).getHora() %></td>
				<% for (int i=1;i<=5;i++){ %>
					<% if(((HorarioMedico)HorarioMedico.get(i*5 - 3)).getEstado().equals("Disponible")){ %>
					<td><input type="radio" name="fechahora" value="<%= ((HorarioMedico)HorarioMedico.get(i*5 -3)).getCod_horario() %>"></td>
					<% } else {%>
					<td bgcolor="DCDCDC"><input type="radio" name="fechahora" value="<%=i%>" disabled></td>
					<% } %>
				<% } %>
			</tr>
			
			<tr>
				<td><%= ((HorarioMedico)HorarioMedico.get(3)).getHora() %></td>
				<% for (int i=1;i<=5;i++){ %>
				<% if(((HorarioMedico)HorarioMedico.get(i*5 - 2)).getEstado().equals("Disponible")){ %>
					<td><input type="radio" name="fechahora" value="<%= ((HorarioMedico)HorarioMedico.get(i*5 -2)).getCod_horario() %>"></td>
					<% } else {%>
					<td bgcolor="DCDCDC"><input type="radio" name="fechahora" value="<%=i%>" disabled></td>
					<% } %>
				<% } %>
			</tr>
			
			<tr>
				<td><%= ((HorarioMedico)HorarioMedico.get(4)).getHora() %></td>
				<% for (int i=1;i<=5;i++){ %>
				<% if(((HorarioMedico)HorarioMedico.get(i*5 - 1)).getEstado().equals("Disponible")){ %>
					<td><input type="radio" name="fechahora" value="<%= ((HorarioMedico)HorarioMedico.get(i*5-1)).getCod_horario() %>"></td>
					<% } else {%>
					<td bgcolor="DCDCDC"><input type="radio" name="fechahora" value="<%=i%>" disabled></td>
					<% } %>
				<% } %>
			</tr>
		
		</table>
		
	</div>
	
	<div id="box3">
		<table>
			<tr>
				<td><a href="solicitudConsulta">Volver a Seleccionar Doctor</a></td>	
			
			</tr>
			
			<tr>
				<td><input type="submit" value="Solicitar" /></td>	
			
			</tr>
			<tr>
				
			</tr>
			<tr>
				<td><input type="reset" value="Limpiar" />	</td>
			</tr>
		</table>
	</div>
	
</form>
</div>

<%@include file="layouts/footer.jsp" %>

</body>
</html>
