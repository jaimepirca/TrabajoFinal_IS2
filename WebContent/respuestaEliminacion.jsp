<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="RPTACONF" class="java.lang.String" scope="session" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Respuesta de elimnacion</title>
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



	<div id="page" class="container">

		<div id="box2">
		
		<%= RPTACONF %>
		<br>
		<br>
		Para regresar a la lista de Pendientes click <a href="listaMedicamentos">aquí</a>
			
		</div>

	</div>

	<%@include file="layouts/footer.jsp"%>

</body>
</html>