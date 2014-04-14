<%@ page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div>
	<h2>Dodaj Nauczyciela</h2>
<spring:url value="/addTeacher" var="addTeacher" htmlEscape="true"/>
	<sf:form method="POST" modelAttribute="teacher" action="${addTeacher}">
		<fieldse>
		<table cellspacing="0">
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
				<th><label for="schoolClass">Klasa</label></th>
				<td>
				<sf:select path="schoolClass" id="schoolClass">
					  <sf:option value="-1" label="--- Select ---" />
					  <c:forEach var="schoolClass" items="${classes}">
                    <option value="${schoolClass.id}">${schoolClass.fullName}</option>
                </c:forEach>
				       </sf:select>
                                </td>
                                <td><sf:errors path="schoolClass" cssClass="error" /></td>
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