<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="leftPane">
	<dl id="menu0" class="leftMenu">
		<dt>
			<spring:url value="/" var="homeUrl" htmlEscape="true" />
			<a href="${homeUrl}">Home</a>
		</dt>

			<sec:authorize access="hasRole('admin')">
		<dt>Zarządzanie klasami</dt>
		<dd>
				<spring:url value="/classes" var="classes" htmlEscape="true" />
				<a href="${classes}">Klasy</a>
			</sec:authorize>
		</dd>
		<dd>
			<sec:authorize access="hasRole('admin')">
				<spring:url value="/addClass" var="addClass" htmlEscape="true" />
				<a href="${addClass}">Dodaj klasę</a>
			</sec:authorize>
		</dd>

		<sec:authorize access="hasRole('admin')">
			<dt>Zarządzanie nauczycielami</dt>
						<dd>
				<spring:url value="/teachers" var="teachers" htmlEscape="true" />
				<a href="${teachers}">Nauczyciele</a>
			</dd>
			<dd>
				<spring:url value="/addTeacher" var="addTeacher" htmlEscape="true" />
				<a href="${addTeacher}">Dodaj nauczyciela</a>
			</dd>
				</sec:authorize>
			
			<sec:authorize access="hasRole('admin')">
		<dt>Zarządzanie uczniami</dt>
		<dd>
				<spring:url value="/students" var="students" htmlEscape="true" />
				<a href="${students}">Uczniowie</a>
			</sec:authorize>
		</dd>
		
		<dd>
			<sec:authorize access="hasRole('admin')">
				<spring:url value="/addStudent" var="addStudent" htmlEscape="true" />
				<a href="${addStudent}">Dodaj ucznia</a>
			</sec:authorize>
		</dd>
		<sec:authorize access="hasRole('admin')">
		<dt>Zarządzanie przedmiotami</dt>
		<dd>
				<spring:url value="/addSubject" var="addSubject" htmlEscape="true" />
				<a href="${addSubject}">Dodaj przedmiot</a>
		</dd>
		<dd>
				<spring:url value="/subjects" var="subjects" htmlEscape="true" />
				<a href="${subjects}">Przedmioty</a>
			
		</dd>
			</sec:authorize>
		
		<sec:authorize access="hasAnyRole('admin','teacher')">
		<dt>Dziennik ocen</dt>
		<dd>
				<spring:url value="/students" var="students" htmlEscape="true" />
				<a href="${students}">Uczniowie</a>
			</sec:authorize>
		</dd>
		
		
		
		<br><br><a href="<c:url value="j_spring_security_logout" />" > Wyloguj</a>
	
	
	
	
			
		
	</dl>
	<script type="text/javascript">
		// <![CDATA[
		new Menu('menu0');
		// ]]>
	</script>
</div>
