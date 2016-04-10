<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<div>
<h1>${message}</h1>
<spring:url value="/addMark" var="addMark"></spring:url>
<center><h1>Oceny ucznia: ${student_name}</h1></center>

<h3><a href ="${addMark}?student_id=${student_id}&subject_id=${subject_id}">Kliknij aby DODAĆ OCENĘ</a> </h1>
	<table id="table-2">
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
				<td>
				<spring:url value="/editMark" var="editMark"></spring:url>
				<a href="${editMark}?mark_id=${mark.id}&student_id=${student_id}&subject_id=${subject_id}">Edytuj</a>
				
				</td>
				<td>
				<spring:url value="/deleteMark" var="deleteMark"></spring:url>
				<a href="${deleteMark}?mark_id=${mark.id}&id=${student_id}&subject_id=${subject_id}">Usuń</a>
				</td>
				
			</tr>

		</c:forEach>




	</table>
	
	


</div>