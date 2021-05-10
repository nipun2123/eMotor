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
                <span>Welcome,     <strong>Nipun</strong></span><br>

            </div>
            <hr>
            <div class="w3-container">
                <h5>Dashboard</h5>
            </div>
            <div class="w3-bar-block" >
                <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" style="text-decoration: none" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
                <a href="/offer_penalty" class="w3-bar-item w3-button w3-padding mynavitem ${param.license}"  style="text-decoration: none" id="item"><i class="fa fa-tachometer fa-fw"></i>    View licenses</a>
                  <a href="/penalty_payment" class="w3-bar-item w3-button w3-padding mynavitem ${param.payment}"  style="text-decoration: none" ><i class="fa fa-user-circle-o fa-fw"></i>    Penalty payment</a>
                  <a href="/view_payments" class="w3-bar-item w3-button w3-padding mynavitem ${param.view_payments}"  style="text-decoration: none" ><i class="fa fa-user-circle-o fa-fw"></i>    View payments</a>
                   <a href="/station_penalty" class="w3-bar-item w3-button w3-padding mynavitem ${param.penalty}"  style="text-decoration: none" ><i class="fa fa-user-circle-o fa-fw"></i>    View penalties</a>
                   <a href="#" data-toggle="modal" data-target="#changePasswordModel" class="w3-bar-item w3-button w3-padding mynavitem" onclick="changeColor()" style="text-decoration: none" ><i class="fa fa-cog fa-fw"></i>  Change Password</a>
                <a href="../LogoutServlet" class="w3-bar-item w3-button w3-padding" style="text-decoration: none" ><i class="fa fa-power-off fa-fw"></i>    Logout</a>
            </div>
        </nav>

        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        
        <div class="modal fade" id="changePasswordModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Change password</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="../ChangePasswordServlet" id="changePasswordForm" method="POST">
                            <div class="form-group">
                                <label for="oldPassword">Old password</label>
                                <input type="password" class="form-control" id="oldPassword"  required placeholder="Old Password">
                                <label id="resultOldPassword" style="color: red"></label>
                            </div>
                            <div class="form-group">
                                <label for="newPassword">New password</label>
                                <input type="password" class="form-control" id="newpassword" name="newpassword" title="Must contain minimum 8 characters with at least one letter and one number"  required pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" placeholder="New Password">
                            </div>
                            <div class="form-group">
                                <label for="confirmpassword">Confirm password</label>
                                <input type="password" class="form-control" id="confirmpassword" required placeholder="Confirm Password">
                                <span id='resultpassword'></span>
                            </div>

                            <button type="submit" class="btn btn-primary" >Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
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

$('#changePasswordModel').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus');
});


</script>
</html>