<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<title>User Edit</title>
</head>

<body>
	<div class="content">
	<h1>User Edit</h1>


		<form:form method="POST"
			action="${pageContext.request.contextPath}${action}"
			commandName="ucd">

			<%-- <form:errors path="*" cssClass="errorblock" element="div"/>
 			--%>
			<table>
				<tr>
					<td>UserName :</td>
					<td><form:input path="username" /></td>
					<td><form:errors path="username" cssClass="error" /></td>
				</tr>
				<form:hidden path="id" />
				<tr>
					<td>Password :</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Confirm Password :</td>
					<td><form:password path="passwordConfirm" /></td>
					<td><form:errors path="passwordConfirm" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Name :</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Last Name :</td>
					<td><form:input path="lastName" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Address :</td>
					<td><form:textarea path="address" /></td>
					<td><form:errors path="address" cssClass="error" /></td>
				</tr>


				<tr>
					<td>Job :</td>
					<td><form:select path="job" items="${jobList}" multiple="true" />
					</td>
					<td><form:errors path="job" cssClass="error" /></td>
				</tr>


				<tr>
					<td colspan="3">
					<input id="url" type="hidden"  value="${contextPath}${url}">
					<input type="submit" value="submit"
						class="button2" /></td>
				</tr>
			</table>
		</form:form>
		<p>
			<a href="${pageContext.request.contextPath}/index"><button
					class="button2">Back</button></a>
		</p>
	</div>
</body>

</html>