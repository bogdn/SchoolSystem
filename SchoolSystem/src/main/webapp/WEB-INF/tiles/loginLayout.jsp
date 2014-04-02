<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<body>
    <div class="page">
        <tiles:insertAttribute name="header" />
        <div class="content">
            <tiles:insertAttribute name="body" />
        </div>
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>