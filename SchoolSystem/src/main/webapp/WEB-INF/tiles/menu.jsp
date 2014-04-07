<%@ page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="leftPane">
	<ul class="leftMenu">
		<li><spring:url value="/" var="homeUrl" htmlEscape="true" /> <a
			href="${homeUrl}">Home</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><spring:url value="/addTeacher" var="addTeacher"
					htmlEscape="true" /> <a href="${addTeacher}">Dodaj nauczyciela</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><spring:url value="/addClass" var="addClass"
					htmlEscape="true" /> <a href="${addClass}">Dodaj klasę</a></li>
		</sec:authorize>
		<li><a href="<c:url value="/j_spring_security_logout" />">
				Logout</a></li>
	</ul>
</div>
