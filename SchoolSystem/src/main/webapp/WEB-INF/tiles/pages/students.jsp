<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
<h4>${message}</h4>
	<table align="center" width="500" id="table-2">
		<thead>
			<tr>
				<td>Id</td>
				<td>Imię</td>
				<td>Nazwisko</td>
				<td>Nazwa użytkownika</td>
				<td>Klasa</td>
				<td>Usuń</td>
				<td>Edytuj</td>
				<td>Więcej</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.surname}</td>
					<td>${student.username}</td>
					<td>${student.studentClass.name}</td>
					<td>
					<spring:url value="/deleteStudent?id=${student.id}" var="deleteStudent" htmlEscape="true"/>
					<a href="${deleteStudent}">Usuń</a>
					</td>
					<td>
					<spring:url value="/editStudent?id=${student.id}" var="editStudent" htmlEscape="true"></spring:url>
					<a href="${editStudent}">Edytuj</a>
					
					</td>
					
					</td>
					<td>
					
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>