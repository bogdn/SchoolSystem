<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	
	<h2>Modyfikacja oceny dla: ${student.name} ${student.surname}</h2>
	<spring:url value="/editMark" var="editMark" htmlEscape="true"></spring:url>
	<sf:form modelAttribute="mark" method="POST" action="${editMark}?subject_id=${subject_id}&student_id=${student_id}">
		<table>
		<tr>
				<td><sf:input path="id" id="id" type="hidden" /></td>
			</tr>
			
			<tr>
				<th><sf:label path="value">Ocena</sf:label></th>
				<td><sf:input path="value" id="value" /></td>
				<td><sf:errors path="value" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<th><label for="description">Opis</label></th>
				<td> <sf:input path="description"/></td>
				<td><sf:errors path="description" cssClass="error"></sf:errors>				</td>
			</tr>
			
			
			<tr>
			<tr>
				<th></th>
				<td><input name="commit" type="submit" value="Edytuj" /></td>
			</tr>
		</table>
	</sf:form>








</div>