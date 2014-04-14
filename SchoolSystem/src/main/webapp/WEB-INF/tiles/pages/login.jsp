<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div>
	<h2>Logowanie</h2>

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
	 
	<h4>${message}</h4>
</div>