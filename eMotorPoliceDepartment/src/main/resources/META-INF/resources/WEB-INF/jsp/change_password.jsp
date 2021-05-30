<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  
<title>Penalty maintain</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/navbar.jsp">
            <jsp:param name="change" value="w3-blue" />
        </jsp:include>
     <jsp:include page="/WEB-INF/jsp/toolbar.jsp"/>   


        <div  style="margin-left:300px;margin-top:43px;">

<div class="container" >
 <form:form action="/department/change/password/process" modelAttribute="account" method="POST" >
 <br/>
 						<spring:bind path="oldPassword">
							<div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:label path="oldPassword">Old password</form:label>
                                <form:input path="oldPassword" type="password" class="form-control" placeholder="Old Password"/>
                                <form:errors path="oldPassword" style="color: red;"></form:errors>
                   
                            </div>
                          </spring:bind>  
                            
                         <spring:bind path="password">
							<div class="form-group ${status.error ? 'has-error' : ''}">   
                                <form:label path="password">New password</form:label>
                                <form:input path="password" type="password"  class="form-control"   placeholder="New Password"/>
                                <form:errors path="password" style="color: red;"></form:errors>
                            </div>
                          </spring:bind>  
                            
                          <spring:bind path="confirmPassword">
							<div class="form-group ${status.error ? 'has-error' : ''}">  
                                <form:label path="confirmPassword">Confirm password</form:label>
                                <form:input path="confirmPassword" type="password"  class="form-control"  placeholder="Confirm Password"/>
                                <form:errors path="confirmPassword" style="color: red;"></form:errors>
                            </div>
                          </spring:bind>  

                            <button type="submit" class="btn btn-primary" >Submit</button>
                        </form:form>
         </div>
            
             </div>
</body>

	
</html>