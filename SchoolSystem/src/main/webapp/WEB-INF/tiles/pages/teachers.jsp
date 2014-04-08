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
				<td>Pełna nazwa</td>
				<td>Usuń</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="teacher" items="${teachers}">
				<tr>
					<td>${teacher.id}</td>
					<td>${teacher.username}</td>
					<td>
					<spring:url value="/deleteTeacher?id=${teacher.id}" var="deleteTeacher" htmlEscape="true"/>
					<a href="${deleteTeacher}">Usuń</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>