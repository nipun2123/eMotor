<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Navbar</title>

</head>

<body style="background-color:#F1F1F1">


   	
	
        <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
            <div class="w3-container">
            
              <c:if test="${pageContext.request.userPrincipal.name != null}">
       
        <span>Welcome,     <strong><c:out value="${sessionScope.name}"/></strong></span><br>
    </c:if>
                

            </div>
            <hr>
            <div class="w3-container">
                <h5>Dashboard</h5>
            </div>
            <div class="w3-bar-block" >
                <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" style="text-decoration: none" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
                <a href="/view/license" class="w3-bar-item w3-button w3-padding mynavitem ${param.license}"  style="text-decoration: none" id="item"><i class="fa fa-id-card-o fa-fw"></i>  &nbsp;  View licenses</a>
                  <a href="/end/penalty" class="w3-bar-item w3-button w3-padding mynavitem ${param.end_penalty}"  style="text-decoration: none" ><i class="fa fa-window-close-o fa-fw"></i>  &nbsp;   End Penalty</a>
                  <a href="/view/endedpenalty/all/en" class="w3-bar-item w3-button w3-padding mynavitem ${param.view_ended_penalty}"  style="text-decoration: none" ><i class="fa fa-eye fa-fw"></i>   &nbsp;  View ended penalty </a>
                   <a href="/view/station/penalty/all/en" class="w3-bar-item w3-button w3-padding mynavitem ${param.view_station_penalty}"  style="text-decoration: none" ><i class="fa fa-gavel fa-fw"></i>    &nbsp; View station penalty</a>
                   <a href="/change/password" class="w3-bar-item w3-button w3-padding mynavitem ${param.change}" style="text-decoration: none" ><i class="fa fa-cog fa-fw"></i>   &nbsp; Change Password</a>
                <a  class="w3-bar-item w3-button w3-padding" style="text-decoration: none" onclick="document.forms['logoutForm'].submit()" ><i class="fa fa-power-off fa-fw"></i>  &nbsp;   Logout</a>
            </div>
        </nav>
 <form id="logoutForm" method="POST" action="/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        
     
</body>

<script>
var mySidebar = document.getElementById("mySidebar");

var overlayBg = document.getElementById("myOverlay");

function w3_open() {
    if (mySidebar.style.display === 'block') {
        mySidebar.style.display = 'none';
        overlayBg.style.display = "none";
    } else {
        mySidebar.style.display = 'block';
        overlayBg.style.display = "block";
    }
}

function w3_close() {
    mySidebar.style.display = "none";
    overlayBg.style.display = "none";
}


</script>
</html>