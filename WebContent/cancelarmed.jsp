<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="MedicamentoPend" class="java.util.ArrayList"
	scope="session" />
	
<%@ page import="com.bean.ReporteBean"%> 	



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cancelar medicamento</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700"
	rel="stylesheet" type="text/css">
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body>

	<%@include file="layouts/logo.jsp"%>

	<div id="menu-wrapper">
		<div id="menu" class="container">
			<ul>
				<li class="current_page_item"><a href="principal.jsp">Inicio</a></li>
			<li><a href="solicitudMedicamento">Peticion Medicamento</a></li>
			<li><a href="solicitudConsulta">Consulta Medica</a></li>
			<li><a href="historialServlet">Historial</a></li>
			<li><a href="cancelarmed">Cancelar Medicamento</a></li>
			<li><a href="cancelarcita.jsp">Cancelar Cita</a></li>
			<li><a href="logoutServlet">Logout</a></li>
			
			</ul>
		</div>
	</div>

	<div id="page" class="container">

		<div id="box4">
		<h2 class="title">Lista de Medicamentos Pendientes</h2>
		
		
		</div>


		<div id="bigbox">
		
		<form method="post" action="eliminarEntrega">
		
			<table border=3>

    
				<tr>
				<td>Codigo de Registro</td>
				<td>Nombre del paciente</td>
				<td>Nombre de la pastilla </td>
				<td>Cantidad</td>
				<td>Hora</td>
				<td></td> </tr>
				
			<%
				
					for (int i = 0; i < MedicamentoPend.size(); i++) {
				%>
				
				
				<tr>
				
		    
		    <td>  <%=((ReporteBean) MedicamentoPend.get(i)).getCod_reporte()%>  </td>
			<td>  <%=((ReporteBean) MedicamentoPend.get(i)).getNombrePaciente()%>  </td>
			<td>  <%=((ReporteBean) MedicamentoPend.get(i)).getNombrePastilla()%>  </td>
			<td>  <%=((ReporteBean) MedicamentoPend.get(i)).getCantidad()%>        </td>
			<td>  <%=((ReporteBean) MedicamentoPend.get(i)).getHora()%>            </td>
			
			
			<td><input type="radio" name="cod_Reporte" value="<%=((ReporteBean) MedicamentoPend.get(i)).getCod_reporte()%>"></td>
			
			<% System.out.println(((ReporteBean) MedicamentoPend.get(i)).getCod_reporte()); %>
			<input type="hidden" name = "cantidad" value=<%=((ReporteBean) MedicamentoPend.get(i)).getCantidad()%>/>
			<input type="hidden" name = "nombreMedicamento" value=<%=((ReporteBean) MedicamentoPend.get(i)).getNombrePastilla()%>/>
			
				</tr>
				<%
					}
				%>
				

              

			</table>
			<input type="submit" value="Eliminar solicitud">
			 </form>
			
		</div>

	</div>

	<%@include file="layouts/footer.jsp"%>

</body>
</html>