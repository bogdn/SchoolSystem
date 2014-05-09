
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
	${message}
	<h2>Edytuj Ucznia</h2>
<spring:url value="/editStudent" var="editStudent" htmlEscape="true"/>
	<sf:form method="POST" modelAttribute="student" action="${editStudent}">
		<fieldse>
		<table cellspacing="0">
		<tr>
				
				<td><sf:input path="id" id="id" type="hidden" /></td>
				<td><sf:errors path="id" cssClass="error" /></td>
			</tr>
			<tr>
				<th><label for="username">Nazwa użytkownika</label></th>
				<td><sf:input path="username" id="username" /></td>
				<td><sf:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<th><label for="password">Hasło</label></th>
				<td><sf:input path="password" id="password" /></td>
				<td><sf:errors path="password" cssClass="error" /></td>
			</tr>
						<tr>
				<th><label for="name">Imię</label></th>
				<td><sf:input path="name" id="name" /></td>
				<td><sf:errors path="name" cssClass="error" /></td>
			</tr>
						<tr>
				<th><label for="surname">Nazwisko</label></th>
				<td><sf:input path="surname" id="surname" /></td>
				<td><sf:errors path="surname" cssClass="error" /></td>
			</tr>
			<tr>
				<th><label for="email">E-mail</label></th>
				<td><sf:input path="email" id="email" /></td>
				<td><sf:errors path="email" cssClass="error" /></td>
			</tr>
						 <tr>
				<th><label for="studentClass">Klasa</label></th>
				<td>
				<sf:select path="studentClass" id="studentClass">
					  <sf:option value="-1" label="--- Select ---" />
					  <c:forEach var="stClass" items="${allClasses}">
                    <option value="${stClass.id}">${stClass.fullName}</option>
                </c:forEach>
				       </sf:select>
                                </td>
                                <td><sf:errors path="studentClass" cssClass="error" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input name="commit" type="submit" value="Edytuj" /></td>
			</tr>
		</table>
		</fieldse>
	</sf:form>
	
	
	</div>
</body>
</html>