<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="lHistorialConsultaAlumno" class="java.util.ArrayList" scope="session" />
<%@ page import="com.bean.HistorialConsultaBean2"%>
<jsp:useBean id="PACIENTE" class="com.bean.PacienteBean" scope="session" />
         
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


<div id="page" class="container">
	
	
	<div id="bigbox">
	
	<h3>Datos del alumno:</h3> <br>
	Codigo: <%= PACIENTE.getCodigo() %> <br>
	Nombre: <%= PACIENTE.getNombre() %> <%= PACIENTE.getApellido() %>
	<br>
	<br>

Lista de consultas: <br>
	<table border=3>
	
	    <tr>
				<td>Nombre Doctor</td>
				<td>Apellido Doctor </td>
				<td>Fecha Solicitada</td>
				<td>Hora y Fecha de Registro de solicitud</td>
				<td>Estado de la consulta</td>
				
				</tr>
				
				<%
				
					for (int i = 0; i < lHistorialConsultaAlumno.size(); i++) {
				%>
				<tr>
		    <td>  <%=((HistorialConsultaBean2) lHistorialConsultaAlumno.get(i)).getNombre()%>  </td>
			<td>  <%=((HistorialConsultaBean2) lHistorialConsultaAlumno.get(i)).getApellido()%>  </td>
			<td>  <%=((HistorialConsultaBean2) lHistorialConsultaAlumno.get(i)).getFecha()%>        </td>
			<td>  <%=((HistorialConsultaBean2) lHistorialConsultaAlumno.get(i)).getFecha2()%>        </td>
			<td>  <%=((HistorialConsultaBean2) lHistorialConsultaAlumno.get(i)).getEstado()%>            </td>
				
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
