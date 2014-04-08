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
				<td>Usuń</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="schoolClass" items="${classes}">
				<tr>
					<td>${schoolClass.name}</td>
					<td>${schoolClass.fullName}</td>
					<td>${schoolClass.year}</td>
					<td>
					<spring:url value="/deleteClass?id=${schoolClass.id}" var="deleteClass" htmlEscape="true"/>
					<a href="${deleteClass}">Usuń</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>