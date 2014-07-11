<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="PACIENTE" class="com.bean.PacienteBean" scope="session" />   
<jsp:useBean id="LISTAMEDIC" class="java.util.ArrayList" scope="session" />  
<%@page import="com.bean.MedicamentoBean" %>
<jsp:useBean id="MALESTAR" class="java.lang.String" scope="session" />
<jsp:useBean id="RESPUESTA" class="java.lang.String" scope="session" />  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pagina de Solicitud de Medicamento</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700" rel="stylesheet" type="text/css">
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
<script language="JavaScript" type="text/javascript">
    function soloNumeros(e){
       key = e.keyCode || e.which;
       tecla = String.fromCharCode(key).toLowerCase();
       letras = "012";
       especiales = [8,37,39,46];

       tecla_especial = false;
       for(var i in especiales){
            if(key == especiales[i]){
                tecla_especial = true;
                break;
            }
        }

        if(letras.indexOf(tecla)==-1 && !tecla_especial){
            return false;
        }
    }
</script>	

</head>
<body>

<%@include file="layouts/head.jsp" %>

<div id="menu-wrapper">
	<div id="menu" class="container">
		<ul>
		
			<li><a href="enfermeraPrincipal.jsp">Inicio</a></li>
			<li class="current_page_item"><a href="enfermeraLoginPacienteParaRegistroManual.jsp">Peticion de Medicamento</a></li>
			<li><a href="generalLoginPrevioaHistoriales.jsp">Historial del alumno</a></li>
			<li><a href="logoutServlet">Logout</a></li>
			
		</ul>
	</div>
</div>

<div id="page" class="container">

	<div id="box1">
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
	
	<div id="box2">
		
		<%= RESPUESTA %>
		
		
	</div>
	
		
	
</div>

<%@include file="layouts/footer.jsp" %>

</body>
</html>
