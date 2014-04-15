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

		<dt>Zarządzanie klasami</dt>
		<dd>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<spring:url value="/classes" var="classes" htmlEscape="true" />
				<a href="${classes}">Klasy</a>
			</sec:authorize>
		</dd>
		<dd>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<spring:url value="/addClass" var="addClass" htmlEscape="true" />
				<a href="${addClass}">Dodaj klasę</a>
			</sec:authorize>
		</dd>

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<dt>Zarządzanie nauczycielami</dt>
						<dd>
				<spring:url value="/teachers" var="teachers" htmlEscape="true" />
				<a href="${teachers}">Nauczyciele</a>
			</dd>
			<dd>
				<spring:url value="/addTeacher" var="addTeacher" htmlEscape="true" />
				<a href="${addTeacher}">Dodaj nauczyciela</a>
			</dd>
			
		<a href="<c:url value="j_spring_security_logout" />" > Logout</a>
	
	
	
	
			
		</sec:authorize>
	</dl>
	<script type="text/javascript">
		// <![CDATA[
		new Menu('menu0');
		// ]]>
	</script>
</div>
