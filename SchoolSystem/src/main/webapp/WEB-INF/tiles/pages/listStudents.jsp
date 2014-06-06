<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<table id="table-2">
<tr>
<th>Imię i Nazwisko</th>
<th>Oceny</th>
</tr>

<c:forEach items="${students}" var="student">

<tr>
<td>
${student.name} ${student.surname}
</td>

<td>
<spring:url value="/studentMarks?id=${student.id}&subject_id=${subject_id}" var="studentMarks"></spring:url>
<a href="${studentMarks}"> Przejdź </a> 
</td>
</tr>
</c:forEach>
</table>





</div>