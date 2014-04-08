<%@ page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
	<div>	
	<h4>${message}</h4>
	
	<table cellspacing="0" width="200">
			<tr>
				<th><label for="name">Nazwa</label></th>
				<td>${schoolClass.name}</td>
			</tr>
			<tr>
				<th><label for="fullName">Pełna nazwa</label></th>
				<td>${schoolClass.fullName}</td>
			</tr>
			<tr>
				<th><label for="year">Rocznik</label></th>
				<td>${schoolClass.year}</td>
			</tr>
	</table>
</div>