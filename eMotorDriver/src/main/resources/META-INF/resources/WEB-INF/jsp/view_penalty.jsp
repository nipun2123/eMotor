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



	<div  class="container" >
	
		<div class="row">
		<button type="button" class="btn btn-outline-secondary" onclick="goBack()" > &#60;&#60;  &nbsp;Back </button>
	</div>	
		
		<br/>
		
	<div class="row">
		<div class="col-sm-8">
				<div class="row">
					<div class="col-sm-3">
					 <label style="font-size: 18px;">Penalty number:</label>
					</div>
					<div class="col-sm-9">
					  <label style="font-size: 18px;">${driverPenalty.penaltyNo}</label>
					</div>
				</div>
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
				
				<div class="row">
					<div class="col-sm-3">
					 <label style="font-size: 18px;">Status:</label>
					</div>
					<div class="col-sm-9">
					  <label style="font-size: 18px;">${driverPenalty.status}</label>
					</div>
				</div>
				
				
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
				
			<div class="row">
					<div class="col-sm-3">
					 <label style="font-size: 18px;">Offence:</label>
					</div>
					<div class="col-sm-9">
					  <label style="font-size: 18px;">${driverPenalty.penalty.penaltyCommon}</label>
					</div>
				</div>
				
					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
			<div class="row">
					<div class="col-sm-3">
					 <label style="font-size: 18px;">Offence type:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.penalty.type}</label>
					</div>
				</div>
				
				
		<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
			<div class="row">
					<div class="col-sm-3">
					 <label style="font-size: 18px;">Penalty type:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.type}</label>
					</div>
				</div>
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
				
				<div class="row">
					<div class="col-sm-3">
					 <label style="font-size: 18px;">Penalty result:</label>
					</div>
					<div class="col-sm-9">
					  <label style="font-size: 18px;">${driverPenalty.completedRecord.result}</label>
					</div>
				</div>
				
					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
			<div class="row">
					<div class="col-sm-3">
					  <label style="font-size: 18px;">Vehicle number:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.vehicleNo}</label>
					</div>
				</div>
				
			<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
			
			<div class="row">
					<div class="col-sm-3">
					  	  <label style="font-size: 18px;">Date of Offence:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.formatedPenaltyFrom}</label>
					</div>
				</div>
		
			
				
					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
				<div class="row">
					<div class="col-sm-3">
					  	 <label style="font-size: 18px;">Place of Offence:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.place}</label>
					</div>
				</div>
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
				
				<div class="row">
					<div class="col-sm-3">
					  	 <label style="font-size: 18px;">Valid from:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.formatedPenaltyFrom}</label>
					</div>
				</div>
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
				<div class="row">
					<div class="col-sm-3">
					  	 <label style="font-size: 18px;">Valid to:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.penaltyTo}</label>
					</div>
				</div>
				
					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
					<div class="row">
					<div class="col-sm-3">
					  	<label style="font-size: 18px;">Court:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.court}</label>
					</div>
				</div>
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
				<div class="row">
					<div class="col-sm-3">
					  	<label style="font-size: 18px;">Court date:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.courtDate}</label>
					</div>
				</div>
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
				
				<div class="row">
					<div class="col-sm-3">
					  	<label style="font-size: 18px;">Police station:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.useraccount.officer.station.policeStation}</label>
					</div>
				</div>
				
					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
				<div class="row">
					<div class="col-sm-3">
					  	<label style="font-size: 18px;">Detected officer no:</label>
					</div>
					<div class="col-sm-9">
					    <label style="font-size: 18px;">${driverPenalty.useraccount.officer.officerNo}</label>
					</div>
				</div>
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
				<div class="row">
					<div class="col-sm-3">
					  	 <label style="font-size: 18px;">Detected officer name:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.useraccount.officer.fName} ${driverPenalty.useraccount.officer.lName}</label>
					</div>
				</div>
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
				
				<div class="row">
					<div class="col-sm-3">
					  	<label style="font-size: 18px;">Who end penalty (Officer no):</label>
					</div>
					<div class="col-sm-9">
					    <label style="font-size: 18px;">${driverPenalty.completedRecord.useraccount.officer.officerNo}</label>
					</div>
				</div>
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
				<div class="row">
					<div class="col-sm-3">
					  	 <label style="font-size: 18px;">Who end penalty (Offer name):</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.completedRecord.useraccount.officer.fName} ${driverPenalty.completedRecord.useraccount.officer.lName}</label>
					</div>
				</div>
				
					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
				<div class="row">
					<div class="col-sm-3">
					  	 <label style="font-size: 18px;">Penalty end date:</label>
					</div>
					<div class="col-sm-9">
					   <label style="font-size: 18px;">${driverPenalty.completedRecord.formatedCompletedDate} </label>
					</div>
				</div>
				
			</div>
		<div class="col-sm-4">
		
				<div class="row">
				<div class="col-sm-4">
					 <label style="font-size: 18px;">Licence number:</label>
				</div>
				<div class="col-sm-8">
					 <label style="font-size: 18px;">${driverPenalty.driver.licenseNo}</label>
				</div>
			</div>
			
			<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
			
			<div class="row">
				<div class="col-sm-4">
					 <label style="font-size: 18px;">NIC number:</label>
				</div>
				<div class="col-sm-8">
					 <label style="font-size: 18px;">${driverPenalty.driver.nic}</label>
				</div>
			</div>
			
			
			
			<br/>
			<br/>
			
			<button type="button" class="btn btn-primary float-right mr-5" > <i class="fas fa-print fa-lg"></i> &nbsp;Print </button>
		</div>
	</div>
	
	
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

function goBack() {
  window.history.back();
}

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