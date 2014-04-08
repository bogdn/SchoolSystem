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
	</dl>

	<script type="text/javascript">
		// <![CDATA[
		new Menu('menu0');
		// ]]>
	</script>
</div>
