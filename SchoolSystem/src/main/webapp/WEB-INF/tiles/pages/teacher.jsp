<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
<table border="0">
<tr>
	<td rowspan="4"><img src="http://pobierak.jeja.pl/images/0/1/9/9049_bombowy-nauczyciel.jpg" width="150" height="192"/></td> 
	<td>Imię</td><td>${teacher.name}</td>
</tr>
<tr>
	<td>Nazwisko</td><td>${teacher.surname}</td>
</tr>
<tr>
	<td>E-mail</td><td>${teacher.email}</td>
</tr>
<tr>
	<td>Klasa</td><td>${teacher.schoolClass.fullName}</td>
</tr>
</table>
</div>