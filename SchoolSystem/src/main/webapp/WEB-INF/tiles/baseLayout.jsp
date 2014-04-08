<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>School System AGH</title>
<script type="text/javascript" src="<c:url value="/resources/js/menu.js" />"></script>
<style type="text/css">
body {
	font-family: Arial, Verdana, sans-serif;
}

.header,.footer,.leftPane,.rightPane {
	border: 1px solid gray;
}

.header,.main,.footer {
	width: 960px;
	color: #665544;
	margin: 0px auto;
	clear: both;
}

.leftPane,.rightPane {
	float: left;
	margin: 10px;
	height: 400px;
}

.leftPane {
	width: 200px;
}

.rightPane {
	width: 715px;
}

.contentPane {
	padding: 20px;
}

.leftMenu {
	list-style: none;
	padding: 0;
	margin: 10px;
}

table thead {
	background: #000;
	color: #fff;
}

table tbody {
	background: transparent;
	color: #000;
}

table tbody tr:nth-child(even) {
	background: #EBEBEB;
}

table tbody tr:nth-child(odd) {
	background: #D6D6D6;
}

table tbody tr:hover {
	background: #FFE9A0;
}
</style>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="main">
		<tiles:insertAttribute name="menu" />
		<div class="rightPane">
			<div class="contentPane">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="footer" />

</body>
</html>
