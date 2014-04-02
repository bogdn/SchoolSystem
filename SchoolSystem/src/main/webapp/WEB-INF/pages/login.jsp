<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div>
	<h2>Logowanie</h2>
<spring:url value="/login" var="loginUrl" htmlEscape="true"/>
	<sf:form method="POST" modelAttribute="login" action="${loginUrl}">
		<fieldse>
		<table cellspacing="0">
			<tr>
				<th><label for="username">Login</label></th>
				<td><sf:input path="username" id="username" /></td>
			</tr>
			<tr>
				<th><label for="password">Password</label></th>
				<td><sf:input path="password" id="password" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input name="commit" type="submit" value="Zaloguj" /></td>
			</tr>
		</table>
		</fieldse>
	</sf:form>
	
	<h4>${message}</h4>
</div>