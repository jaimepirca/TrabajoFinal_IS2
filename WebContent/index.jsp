<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Bienvenida</title>
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
			<li class="current_page_item"><a href="index.jsp">Inicio</a></li>
			<li><a href="login.jsp">Login</a></li>
			
		</ul>
	</div>
</div>
<div id="page" class="container">
	<div id="box1">
		<h2 class="title"><a href="#">Servicio Medico ULima</a></h2>
		<div style="clear: both;">&nbsp;</div>
		<div class="entry">
			<p><strong>Presentación: </strong>El Departamento Médico de la Universidad de Lima tiene como función esencial velar por la salud de toda la comunidad universitaria y su atención médica cubre todos los horarios de clases desde las 07.00 horas hasta las 22.00 horas. Cuenta con seis médicos y tres enfermeras con atención en tres turnos diarios. Ofrece atención especializada en: Emergencias, Medicina Interna, Traumatología, Dermatología, Medicina General, Enfermería y Nutrición.
			</p>
			<%-- <input class="button" value="prueba"> --%>
			
		</div>
	</div>
	<div id="box2">
		<h2>Staff Médico</h2>
		<ul class="style1">
			<li class="first"><a href="#">Doctores</a></li>
			<li><a href="#">Enfermeras</a></li>
		</ul>
	</div>
	<div id="box3">
		<h2>Convenio con Seguros</h2>
		<ul class="style1">
			<li class="first"><a href="#">Seguros Rimac</a></li>
			<li><a href="#">Opcion 2</a></li>
			<li><a href="#">Opcion 3</a></li>
		</ul>
	</div>
</div>

<%@include file="layouts/footer.jsp" %>

</body>
</html>
