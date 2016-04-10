<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>

<h3>Wybierz odpowiednią klasę aby wyświetlić listę przedmiotów</h3>

<table id="table-2">
<tr>
<th>Klasa</th>
<td></td>
</tr>
<c:forEach var="vClass" items="${allClasses}">
<tr>
<td>${vClass.fullName}</td>

<td>
<spring:url value="/subjectsOfClass?id=${vClass.id}" var="subjectsOfClass"></spring:url>
<a href="${subjectsOfClass}">Wyświetl Przedmioty</a>
</td>
</tr>



</c:forEach>




</table>









</div>