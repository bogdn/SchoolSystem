<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
<h4>${message}</h4>
	<table align="center" width="400">
		<thead>
			<tr>
				<td>Id</td>
				<td>Nazwa</td>
				<td>Klasa</td>
				<td>Nauczyciel</td>
				<td>Eytuj</td>
				<td>Usuń</td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="subject" items="${subjects}">
				<tr>
					<td>${subject.id}</td>
					<td><b>${subject.name}</b></td>
					<td>${subject.subClass.fullName}</td>
					<td>${subject.teacher.name} ${subject.teacher.surname}</td>
					<td>
					<spring:url value="/editSubject?id=${subject.id}" var="editSubject"></spring:url>
					<a href="${editSubject}">Edytuj</a>
					<td>
					<spring:url value="/deleteSubject?id=${subject.id}" var="deleteSubject"></spring:url>
					<a href="${deleteSubject}">Usuń</a>
					</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>