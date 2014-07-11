<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="lSolicPendientes" class="java.util.ArrayList"
	scope="session" />
<%@ page import="com.bean.ReporteBean"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Lista de peticion de pastillas PENDIENTES</title>
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
			<li class="current_page_item"><a href="principalenfermera.jsp">Inicio</a></li>
			<li><a href="listaMedicamentos">Medicamentos en Espera</a></li>
			<li><a href="LoginPacienteParaRegistroManual.jsp">Peticion de Medicamento</a></li>
			<li><a href="LoginPrevioaHistoriales.jsp">Historial del alumno</a></li>
			<li><a href="logoutServlet">Logout</a></li>
			
			</ul>
		</div>
	</div>

	<div id="page" class="container">

		<div id="box4">
		<h2 class="title">Lista de Medicamentos Pendientes</h2>
		
		
		</div>


		<div id="bigbox">
		
		<form method="post" action="ConfirmarEntrega">
		
			<table border=3>

    
				<tr>
				<td>Codigo de Registro</td>
				<td>Nombre del paciente</td>
				<td>Nombre de la pastilla </td>
				<td>Cantidad</td>
				<td>Hora</td>
				<td></td> </tr>
				
					
				<%
				
					for (int i = 0; i < lSolicPendientes.size(); i++) {
				%>
				
				
				<tr>
				
		    
		    <td>  <%=((ReporteBean) lSolicPendientes.get(i)).getCod_reporte()%>  </td>
			<td>  <%=((ReporteBean) lSolicPendientes.get(i)).getNombrePaciente()%>  </td>
			<td>  <%=((ReporteBean) lSolicPendientes.get(i)).getNombrePastilla()%>  </td>
			<td>  <%=((ReporteBean) lSolicPendientes.get(i)).getCantidad()%>        </td>
			<td>  <%=((ReporteBean) lSolicPendientes.get(i)).getHora()%>            </td>
			
			
			<td><input type="radio" name="cod_Reporte" value="<%=((ReporteBean) lSolicPendientes.get(i)).getCod_reporte()%>"></td>
			
			
				</tr>
				<%
					}
				%>

              

			</table>
			<input type="submit" value="Confirmar Entrega">
			 </form>
			
		</div>

	</div>

	<%@include file="layouts/footer.jsp"%>

</body>
</html>