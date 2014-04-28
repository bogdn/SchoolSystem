<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
<h4>${message}</h4>
	<table align="center" width="400">
		<thead>
			<tr>
				<td>Klasa</td>
				<td>Pełna nazwa</td>
				<td>Rocznik</td>
				<td>Wychowawca</td>
				<td>Usuń</td>
				<td>Edytuj</td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="schoolClass" items="${classes}">
				<tr>
					<td>${schoolClass.name}</td>
					<td>${schoolClass.fullName}</td>
					<td>${schoolClass.year}</td>
					<td>${schoolClass.teacher.name} ${schoolClass.teacher.surname}</td>
					<td>
					<spring:url value="/deleteClass?id=${schoolClass.id}" var="deleteClass" htmlEscape="true"/>
					<a href="${deleteClass}">Usuń</a>
					</td>
					<td>
					<spring:url value="/editClass?id=${schoolClass.id}" var="editClass" htmlEscape="true"/>
					<a href="${editClass}">Edytuj</a>
					
					</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>