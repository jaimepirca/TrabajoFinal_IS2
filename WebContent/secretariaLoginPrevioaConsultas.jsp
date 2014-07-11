<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Pagina de login del paciente</title>
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
	<div id="box1">
		<h2 class="title"><a href="#">Codigo del paciente</a></h2>
		<div style="clear: both;">&nbsp;</div>
		<div class="entry">
			<form method="post" action="solicitudConsulta">
				<table>
					<tr>
						<td>Codigo:</td>
						<td><input type="text" name="usuario"></td>
					</tr>
					
					<tr>
						<td align=center><input type="submit" value="Continuar"></td>
						<td align=center><input type="reset" value="Limpiar"></td>
					</tr>
				</table>
				
				
			</form>
			
		</div>
	</div>
	
	
</div>

<%@include file="layouts/footer.jsp" %>

</body>
</html>