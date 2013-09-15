<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of User</title>

</head>
<body>
<div class="content">
<h1>List of User</h1>
<p>Here you can see the list of the user, add them, remove or update.</p>

<p>${message}</p>


<br/>
<div class="data">
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr> 

<th width="5%">ID</th>
<th width="15%">username</th>
<th width="10%">Name</th>
<th width="20%">Last name</th>
<th width="20">Address</th>
<th width="10%">job</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${userList}" var="user" >
<tr>
	<td>${user.id}</td>

	<td>${user.username}</td>
	<td>${user.name}</td>
	<td>${user.lastName}</td>
	<td>${user.address}</td>
		<td>${user.job}</td>
	<td>
	<a href="${pageContext.request.contextPath}/user/edit/${user.id} ">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/user/delete/${user.id} ">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>

</table>
</div>
<table>
<tr>

<td>
<p><a href="${pageContext.request.contextPath}/index"><button class="button2">Home</button></a></p>
</td>
<td>
<p><a href="${pageContext.request.contextPath}/user/add"><button class="button2">Add User</button></a></p>
</td>
</tr>
</table>
</div>
</body>