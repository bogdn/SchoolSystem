 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <spring:url value="/logout" var="logoutUrl" htmlEscape="true"/>
            <a href="${logoutUrl}">Logout</a>
        </li>    
       </ul>  
      </div>  