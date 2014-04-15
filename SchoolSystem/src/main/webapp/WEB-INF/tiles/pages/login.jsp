<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<div>
	<h3>Podaj swój login i hasło:</h3>
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>

	<form action="j_spring_security_check" method="POST">
		<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label for="username">Login</label></th>
					<td><input id="username" name="j_username" type="text" /></td>
				</tr>
				<tr>
					<th><label for="password">Password</label></th>
					<td><input id="password" name="j_password" type="password" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Zaloguj" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</div>