<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Transaction Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Transaction
</h1>

<c:url var="addAction" value="/transaction/add" ></c:url>

<form:form action="${addAction}" commandName="transaction">
<table>
	<c:if test="${!empty transaction.transactionType}">
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
			<form:label path="transactionType">
				<spring:message text="Transaction Type"/>
			</form:label>
		</td>
		<td>
			<form:input path="transactionType" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="itemId">
				<spring:message text="Item"/>
			</form:label>
		</td>
		<td>
			<form:input path="itemId" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="purchaseDate">
				<spring:message text="Purchase Date"/>
			</form:label>
		</td>
		<td>
			<form:input path="purchaseDate" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="supplier">
				<spring:message text="Supplier"/>
			</form:label>
		</td>
		<td>
			<form:input path="supplier" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="status">
				<spring:message text="Status"/>
			</form:label>
		</td>
		<td>
			<form:input path="status" />
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
			<c:if test="${!empty transaction.transactionType}">
				<input type="submit"
					value="<spring:message text="Edit Transaction"/>" />
			</c:if>
			<c:if test="${empty transaction.transactionType}">
				<input type="submit"
					value="<spring:message text="Add Transaction"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Transactions List</h3>
<c:if test="${!empty listTransactions}">
	<table class="tg">
	<tr>
		<th width="80">Transaction ID</th>
		<th width="120">Transaction Type</th>
		<th width="120">Item</th>
		<th width="120">Purchase Date</th>
		<th width="120">Supplier</th>
		<th width="120">Status</th>
		<th width="120">Description</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listTransactions}" var="transaction">
		<tr>
			<td>${transaction.id}</td>
			<td>${transaction.transactionType}</td>
			<td>${transaction.itemId}</td>
			<td>${transaction.purchaseDate}</td>
			<td>${transaction.supplier}</td>
			<td>${transaction.status}</td>
			<td>${transaction.description}</td>
			<td><a href="<c:url value='/transaction/edit/${transaction.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/transaction/remove/${transaction.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
