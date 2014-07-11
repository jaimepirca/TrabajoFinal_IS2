<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="lHistorialPastillaAlumno" class="java.util.ArrayList" scope="session" />
<%@ page import="com.bean.HistorialPastillaBean"%>
<jsp:useBean id="PACIENTE" class="com.bean.PacienteBean" scope="session" />
         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Historial de pastillas del paciente</title>
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



<div id="page" class="container">
	
	
	<div id="bigbox">
	<h3>Datos del alumno:</h3> <br>
	Codigo: <%= PACIENTE.getCodigo() %> <br>
	Nombre: <%= PACIENTE.getNombre() %> <%= PACIENTE.getApellido() %>
	<br>
	<br>

Lista de peticiones de medicamento: <br>
	<table border=3>
	    <tr>
				
				<td>Codigo de registro </td>
				<td>Nombre del medicamento</td>
				<td>Cantidad</td>
				<td>Nombre de la Enfermera a cargo</td>
				<td>Apellido de la Enfermera a cargo</td>
				<td>Fecha</td>
				<td>Estado</td>
				</tr>
				
				<%
				
					for (int i = 0; i < lHistorialPastillaAlumno.size(); i++) {
				%>
				<tr>
		    <td>  <%=((HistorialPastillaBean) lHistorialPastillaAlumno.get(i)).getCod_reg_med()%>  </td>
			<td>  <%=((HistorialPastillaBean) lHistorialPastillaAlumno.get(i)).getCod_medic()%>  </td>
			<td>  <%=((HistorialPastillaBean) lHistorialPastillaAlumno.get(i)).getCantidad()%>        </td>
			<td>  <%=((HistorialPastillaBean) lHistorialPastillaAlumno.get(i)).getMedico()%>        </td>
			<td>  <%=((HistorialPastillaBean) lHistorialPastillaAlumno.get(i)).getApMedico()%>        </td>
			<td>  <%=((HistorialPastillaBean) lHistorialPastillaAlumno.get(i)).getFecha()%>            </td>
			<td>  <%=((HistorialPastillaBean) lHistorialPastillaAlumno.get(i)).getEstado()%>  </td>
			
			
				
				<tr>
				<%
					}
				%>
	
	
	
	</table>
		
		
		
		
	</div>
	
</div>

<%@include file="layouts/footer.jsp" %>

</body>
</html>
