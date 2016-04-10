<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>School System PK</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/menu.js" />"></script>
<style type="text/css">
body {
	font-family: Arial, Verdana, sans-serif;
}
#table-2 {
	border: 1px solid #e3e3e3;
	background-color: #f2f2f2;
        width: 100%;
	border-radius: 6px;
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
}
#table-2 td, #table-2 th {
	padding: 5px;
	color: #333;
}

#table-2 thead {
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
	padding: .2em 0 .2em .5em;
	text-align: left;
	color: #4B4B4B;
	background-color: #C8C8C8;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#e3e3e3), color-stop(.6,#B3B3B3));
	background-image: -moz-linear-gradient(top, #D6D6D6, #B0B0B0, #B3B3B3 90%);
	border-bottom: solid 1px #999;
}
#table-2 th {
	font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
	font-size: 17px;
	line-height: 20px;
	font-style: normal;
	font-weight: bold;
	text-align: center;
	text-shadow: white 1px 1px 1px;
}
#table-2 td {
	line-height: 20px;
	font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
	font-size: 14px;
	border-bottom: 1px solid #fff;
	border-top: 1px solid #fff;
}
#table-2 td:hover {
	background-color: #fff;
}


.contentPane {
	text-align: center;
}


.header,.footer,.leftPane,.rightPane {
	border: 1px solid gray;
	border-radius: 10px;
}

.header,.main,.footer {
	width: 960px;
	color: black;
	margin: 0px auto;
	clear: both;
}
.header {
	color: #0080FF;
}
.footer, .header, .rightPane {
	text-align:center;
}

.leftPane,.rightPane {
	float: left;
	margin: 10px;
	height: 400px;
}

.leftPane {
	width: 250px;
}

.rightPane {
	width: 665px;
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

#menu0 dt {
	cursor: pointer;
}

.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
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
