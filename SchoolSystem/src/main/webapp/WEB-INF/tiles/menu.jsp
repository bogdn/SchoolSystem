 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <div class="leftPane">  
       <ul class="leftMenu">  
        <li>
        <spring:url value="/" var="homeUrl" htmlEscape="true"/>
            <a href="${homeUrl}">Home</a>
        </li>  
                <li>
        <spring:url value="/" var="homeUrl" htmlEscape="true"/>
            <a href="${homeUrl}">Home</a>
        </li> 
                <li>
        <spring:url value="/" var="homeUrl" htmlEscape="true"/>
            <a href="${homeUrl}">Home</a>
        </li>    
                <li>
            <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
        </li>    
       </ul>  
      </div>  