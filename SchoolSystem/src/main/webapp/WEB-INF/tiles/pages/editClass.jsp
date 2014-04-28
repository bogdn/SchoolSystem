<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div>


	<h2>Zmiena danych dla Klasy</h2>
	<spring:url value="/editClass" var="editClass" htmlEscape="true" />
	<sf:form method="POST" modelAttribute="stClass" action="${editClass}">
		<fieldse>
		<table cellspacing="0">

			<tr>
				<td><sf:input path="id" id="id" type="hidden" /></td>
				<td><sf:errors path="id" cssClass="error" /></td>
			</tr>
			<tr>
				<th><label for="name">Nazwa</label></th>
				<td><sf:input path="name" id="name" /></td>
				<td><sf:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<th><label for="fullName">Pełna nazwa</label></th>
				<td><sf:input path="fullName" id="fullName" /></td>
				<td><sf:errors path="fullName" cssClass="error" /></td>
			</tr>
			<tr>
				<th><label for="year">Rocznik</label></th>
				<td><sf:input path="year" id="year" /></td>
				<td><sf:errors path="year" cssClass="error" /></td>
			</tr>
			<!--  To change class's Teacher you have to edit Teacher
			<tr>
				<th><label for="teacher">Wychowawca</label></th>
				 <td><form:select path="teacher" id="teacher">
				 	
				
					  <form:option value="-1" label="Select" />
					  <c:forEach var="teacher" items="${teachers}">
					  
                    <form:option value="${teacher.id}">${teacher.name} ${teacher.surname}</form:option>
               
                </c:forEach>
				       </form:select></td>
				<td><sf:errors path="teacher" cssClass="error" /></td>
				
				
			</tr>
			-->
			<tr>
				<th></th>
				<td><input name="commit" type="submit" value="Edytuj" /></td>
			</tr>
		</table>
		</fieldse>
	</sf:form>
	<h4>${message}</h4>

</div>