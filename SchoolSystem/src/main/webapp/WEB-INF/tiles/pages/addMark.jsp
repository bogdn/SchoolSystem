<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
	<h2>Dodaj ocenę</h2>
	<spring:url value="/addMark" var="addMark" htmlEscape="true" />
	<sf:form method="POST" modelAttribute="mark" action="${addMark}?student_id=${student_id}&subject_id=${subject_id}">

		<table id="table-2">
			<tr>
				<!-- <sf:input path="student" id="student"  />
				<sf:errors path="student" cssClass="error" />
				
				<sf:input path="subject" id="subject" type="hidden" />
				<sf:errors path="subject" cssClass="error" />
				-->
				<th><label for="value">Ocena</label></th>
				<td><sf:input path="value" id="value" /></td>
				<td><sf:errors path="value" cssClass="error" /></td>
			</tr>
			<tr>
				<th><label for="description">Opis</label></th>
				<td><sf:input path="description" id="describtion" /></td>
				<td><sf:errors path="description" cssClass="error" /></td>
			</tr>
			<tr>
			<th></th>
			<td><input name="commit" type="submit" value="Dodaj" /></td>
			</tr>
		</table>

	</sf:form>

	<h4>${message}</h4>
</div>