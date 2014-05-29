<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<div>
<h1>${message}</h1>
<spring:url value="/addMark" var="addMark"></spring:url>
<h1><a href ="${addMark}?student_id=${student_id}&subject_id=${subject_id}">DODAJ OCENĘ</a> </h1>
	<table>
		<tr>
			<th>Ocena</th>
			<th>Opis</th>
			<th>Edytuj</th>
			<th>Usuń</th>

		</tr>
		<c:forEach var="mark" items="${marks}">
			<tr>
				<td>${mark.value}</td>
				<td>${mark.description}</td>
				<td></td>
				<td></td>
			</tr>

		</c:forEach>




	</table>
	
	


</div>