<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
	<div>
	
	<sec:authorize access="hasRole('admin')">
	<table>
	<tr>
	<th>Przedmiot</th>
	
	</tr>
	<c:forEach var="subject" items="${subjects}">
	<tr>
	<td>${subject.name}</td>
	
	</tr>
	
	</c:forEach>
	
	</table>
	
	
	
	
	
	</sec:authorize>
	
	
	
	
	
	
	</div>