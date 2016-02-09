<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Contact Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Contact
</h1>

<c:url var="addAction" value="/contact/add" ></c:url>

<form:form action="${addAction}" commandName="contact">
<table>
	<c:if test="${!empty contact.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="company">
				<spring:message text="Company"/>
			</form:label>
		</td>
		<td>
			<form:input path="company" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="address">
				<spring:message text="Address"/>
			</form:label>
		</td>
		<td>
			<form:input path="address" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="city">
				<spring:message text="City"/>
			</form:label>
		</td>
		<td>
			<form:input path="city" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="country">
				<spring:message text="Country"/>
			</form:label>
		</td>
		<td>
			<form:input path="country" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="phone">
				<spring:message text="Phone"/>
			</form:label>
		</td>
		<td>
			<form:input path="phone" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="EMail"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="description">
				<spring:message text="Description"/>
			</form:label>
		</td>
		<td>
			<form:input path="description" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty contact.name}">
				<input type="submit"
					value="<spring:message text="Edit Contact"/>" />
			</c:if>
			<c:if test="${empty contact.name}">
				<input type="submit"
					value="<spring:message text="Add Contact"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Contacts List</h3>
<c:if test="${!empty listContacts}">
	<table class="tg">
	<tr>
		<th width="80">Contact ID</th>
		<th width="120">Contact Name</th>
		<th width="120">Company</th>
		<th width="120">Address</th>
		<th width="120">City</th>
		<th width="120">Country</th>
		<th width="120">Phone</th>
		<th width="120">EMail</th>
		<th width="120">Description</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listContacts}" var="contact">
		<tr>
			<td>${contact.id}</td>
			<td>${contact.name}</td>
			<td>${contact.company}</td>
			<td>${contact.address}</td>
			<td>${contact.city}</td>
			<td>${contact.country}</td>
			<td>${contact.phone}</td>
			<td>${contact.email}</td>
			<td>${contact.description}</td>
			<td><a href="<c:url value='/contact/edit/${contact.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/contact/remove/${contact.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
