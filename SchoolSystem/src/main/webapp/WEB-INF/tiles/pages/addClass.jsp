<%@ page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<div>
	<h2>Dodaj klasę</h2>
<spring:url value="/addClass" var="addClass" htmlEscape="true"/>
	<sf:form method="POST" modelAttribute="class" action="${addClass}">
		<fieldse>
		<table cellspacing="0" id="table-2">
			<tr>
				<th><label for="name">Nazwa</label></th>
				<td><sf:input path="name" id="name" /></td>
				<td><sf:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<th><label for="fullName">Pełna nazwa</label></th>
				<td><sf:input path="fullName" id="fullName" /></td>
				<td><sf:errors path="fullName" cssClass="error" /></td>
			</tr>
			<tr>
						<tr>
				<th><label for="year">Rocznik</label></th>
				<td><sf:input type="date" path="year" id="year" /></td>
				<td><sf:errors path="year" cssClass="error" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input name="commit" type="submit" value="Dodaj" /></td>
			</tr>
		</table>
		</fieldse>
	</sf:form>
	
	<h4>${message}</h4>
</div>