<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Fallo de Login</title>
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
			<li><a href="index.jsp">Inicio</a></li>
			<li class="current_page_item"><a href="login.jsp">Login</a></li>
			
		</ul>
	</div>
</div>
<div id="page" class="container">
	<div id="box1">
		
	</div>
	<div id="box2">
		<h2>Fallo de login</h2>
		El usuario y/o contraseña que ingresó es/son inválidos.
		para regresar al login click <a href="login.jsp">aquí</a>
	</div>
	<div id="box3">
		
	</div>
</div>

<%@include file="layouts/footer.jsp" %>

</body>
</html>
