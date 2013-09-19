<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/style.css" 	rel="stylesheet" type="text/css" />


<link rel="stylesheet" type="text/css" media="screen"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/base/jquery.ui.base.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/themes/redmond/jquery-ui.css" />

<link href="${pageContext.request.contextPath}/css/ui.jqgrid.css" media="screen" rel="stylesheet" type="text/css" />

<title>User Management</title>
</head>
<body>
<div class="content">
<h1>User Management</h1>
	<table id="grid"></table>
	<div id="pager"></div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/jquery-ui.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/grid.locale-en.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.jqGrid.src.js"></script>
	<script src="${pageContext.request.contextPath}/js/indexJs.js"></script>
</div>
</body>
</html>