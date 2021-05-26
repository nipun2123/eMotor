<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
	
	  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.5/css/buttons.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.1/css/select.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://editor.datatables.net/extensions/Editor/css/editor.bootstrap4.min.css"/>
<title>View licenses</title>
</head>
<body>


	<jsp:include page="/WEB-INF/jsp/navbar.jsp">
		<jsp:param name="license" value="w3-blue" />
	</jsp:include>
	<jsp:include page="/WEB-INF/jsp/toolbar.jsp" />


	<div style="margin-left: 300px; margin-top: 43px;">

		<br />
		
		<form:form action="/view/license/search/${ln}" method="GET" modelAttribute = "offerPenaltyBean">
		<div class="d-flex justify-content-center input-group">
			<div class="form-outline form-inline">
			
			<form:label path="licenseNo" class="form-label">Driving license:</form:label> &nbsp; 
				<form:input path="licenseNo"  type="search"  class="form-control" value="${searchedLicense.license.licenseNo}"/>
				&nbsp;&nbsp; 
				<form:label path="nic" class="form-label" >NIC: </form:label> &nbsp; 
				<form:input path="nic"  type="search"  class="form-control" value="${searchedLicense.license.nic}"/>
				
				
			</div>
			&nbsp; &nbsp;
			<button type="submit" class="btn btn-primary">
				<i class="fas fa-search"></i>
			</button>
		</div>
	</form:form>

<hr style="height:2px;border-width:0;color:gray;background-color:gray">
	
	
	<c:if test="${searchedLicense.license.licenseNo != null || searchedLicense.license.nic != null}">	
	<div  class="ml-3">
	<div class="row">
		<div class="col-sm-8">
		
		<div class="row">
			<div class="col-sm-4">
				 <b style="font-size: 18px;">Licence number</b>
			</div>
			<div class="col-sm-8">
				 <label style="font-size: 18px;">${searchedLicense.license.licenseNo}</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				 <b style="font-size: 18px;">NIC number</b>
			</div>
			<div class="col-sm-8">
				 <label style="font-size: 18px;">${searchedLicense.license.nic}</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				 <b style="font-size: 18px;">Full name:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">${searchedLicense.license.name}</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				 <b style="font-size: 18px;">Address:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">${searchedLicense.license.address}</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				  <b style="font-size: 18px;">Date of Birth:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">${searchedLicense.license.dob}</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				  <b style="font-size: 18px;">Blood group:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">${searchedLicense.license.bloodGroup}</label>
			</div>
		</div>
		
		
		<div class="row">
			<div class="col-sm-4">
				  <b style="font-size: 18px;">License issue date:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">${searchedLicense.license.issueDate}</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				  <b style="font-size: 18px;">License expire date:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">${searchedLicense.license.expireDate}</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				  <b style="font-size: 18px;">License Status:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;"class="text-danger">
				
				  <c:choose>
  												<c:when test="${searchedLicense.suspend != null}">
  													Suspended from ${searchedLicense.suspend.suspendedFrom} to ${searchedLicense.suspend.suspendedTo} 
  												</c:when>
  												
  												<c:when test="${searchedLicense.suspend == null}">
  													Active
  												</c:when>
 
											</c:choose>
											
				</label>
			</div>
		</div>
			</div>
		<div class="col-sm-4 ">
		
			                            <div class="table-responsive">
                                <table class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                        <tr>
                                        	<th>Vehicle category</th>
                                        	<th>Issue date</th>
                                        	<th>Expire date</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                            <c:forEach items="${searchedLicense.license.drivingLicenseClasses}" var="vehicleClasses">
                                     
	                                     	<tr>
	      									  <td> ${vehicleClasses.vehicleClass} </td>
	      									    <td> ${vehicleClasses.classValidFrom} </td>
	      									      <td> ${vehicleClasses.classValidTo} </td>
	      									 </tr> 
   									 </c:forEach>
                                    </tbody>   
                                </table>
                            </div>
		</div>
	</div>
	<button type="button" class="btn btn-primary float-right mr-5" onclick="location.href='offer/penalty/${ln}?licenseNo=${searchedLicense.license.licenseNo}&nic=${searchedLicense.license.nic}' "> Offer penalty </button>
                     
      <br/>   
       <br/>      
      <hr style="height:1px;border-width:0;color:gray;background-color:gray">  
      
           <div class="btn-group btn-group-toggle float-right m-2 " data-toggle="buttons" >
  							<label class="btn btn-secondary active">
    					<input type="radio" name="langOption" id="spotEnglishConvert" value="english" autocomplete="off" <c:out value = "${en}"/> onclick="window.location=window.location.href.match(/^.*\//)+'en'+'?licenseNo=${searchedLicense.license.licenseNo}&nic=${searchedLicense.license.nic}' ">
					English
 							 </label>
  						<label class="btn btn-secondary">
   							 <input type="radio" name="langOption" id="spotSinhalaConvert" value="sinhala" autocomplete="off" <c:out value = "${sn}"/> onclick="window.location=window.location.href.match(/^.*\//)+'sn'+'?licenseNo=${searchedLicense.license.licenseNo}&nic=${searchedLicense.license.nic}' "> Sinhala
 								 </label>
  						<label class="btn btn-secondary">
   							 <input type="radio" name="langOption" id="spotTamilConvert" value="tamil" autocomplete="off" <c:out value = "${tm}"/> onclick="window.location=window.location.href.match(/^.*\//)+'tm'+'?licenseNo=${searchedLicense.license.licenseNo}&nic=${searchedLicense.license.nic}' "> Tamil
  							</label>
						</div>             

		<div class="table-responsive">
                                <table id="penaltyTable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                        <tr>
                                        	<th>Penalty number</th>
                                        	<th>Offence</th>
                                        	<th>Offence type</th>
                                        	<th>From</th>
                                        	<th>TO</th>
                                        	<th>Status</th>
                                        	<th>More</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                           <c:forEach items="${searchedLicense.driverPenalties}" var="driverPenalty">
                                     
	                                     	<tr>
	      									  <td> ${driverPenalty.penaltyNo} </td>
	      									    <td> ${driverPenalty.penalty.penaltyCommon} </td>
	      									      <td> ${driverPenalty.penalty.type} </td>
	      									      <td> ${driverPenalty.formatedPenaltyFrom} </td>
	      									      <td> ${driverPenalty.penaltyTo} </td>
	      									      <td> ${driverPenalty.status} </td>
	      									      <td><a href="penalty/${ln}?penaltyNo=${driverPenalty.penaltyNo}">More</a> </td>
	      									 </tr> 
   									 </c:forEach>
                                    </tbody>  
                                </table>
                            </div> 
	</div>
	
	</c:if>	
</div>

</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js|https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.5/js/dataTables.buttons.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.5/js/dataTables.buttons.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/select/1.3.1/js/dataTables.select.min.js"></script>
        <script type="text/javascript" src="https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js"></script>
        <script type="text/javascript" src="https://editor.datatables.net/extensions/Editor/js/editor.bootstrap4.min.js"></script>
        
<script>
$(document).ready(function () {
    var table = $('#penaltyTable').DataTable({
        lengthChange: false,
        "paging": false,
        select: true
    });
    $('#penaltyTable tbody').on('click', 'tr', function () {
        var selectRow = table.rows(this).data()[0];
    });
});
</script>
</html>