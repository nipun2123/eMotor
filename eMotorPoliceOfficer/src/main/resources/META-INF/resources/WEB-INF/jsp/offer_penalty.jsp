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

	<div  class="p-4" >
	<div class="row">
		<button type="button" class="btn btn-outline-secondary" onclick="goBack()" > &#60;&#60;  &nbsp;Back </button>
	</div>	
		
		<br/>
		<form:form action="/view/license/search/offer/penalty" method="POST" modelAttribute = "offerPenaltyBean" >
	<div class="row">
		<div class="col-sm-8">
		
					
			<div class="row">
					<div class="col-sm-3">
					 <form:label path="type" style="font-size: 20px;">Offence type:</form:label>
					</div>
					<div class="col-sm-5">
					   <form:select path="type" class="form-control browser-default custom-select"  id="type" >
                                            <option value="spot">Spot Fine</option>
                                            <option value="court">Court</option>
                                            <option value="warn">Warn</option>
                       </form:select>
					</div>
				</div>
				
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
				
			<div class="row">
					<div class="col-sm-3">
					 <form:label path="penaltyId" style="font-size: 20px;">Offence:</form:label>
					</div>
					<div class="col-sm-9">
					    <form:select path="penaltyId" class="form-control browser-default custom-select"  id="offenceSelect" >
                                        
                       </form:select> 
					</div>
				</div>

					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
			<div class="row">
					<div class="col-sm-3">
					  <form:label path="vehicleNo" style="font-size: 20px;">Vehicle number:</form:label>
					</div>
					<div class="col-sm-5">
					    <form:input path="vehicleNo" type="text" class="form-control" />
					</div>
				</div>
				
		
				
					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
				<div class="row">
					<div class="col-sm-3">
					  	 <form:label path="place" style="font-size: 20px;">Place of Offence:</form:label>
					</div>
					<div class="col-sm-5">
					    <form:input path="place" type="text" class="form-control" />
					</div>
				</div>
				
				
					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
					<div class="row">
					<div class="col-sm-3">
					  	<form:label path="court" style="font-size: 20px;">Court:</form:label>
					</div>
					<div class="col-sm-5">
					   <form:input path="court" type="text" class="form-control" />
					</div>
				</div>
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
				<div class="row">
					<div class="col-sm-3">
					  	<form:label path="courtDate" style="font-size: 20px;">Court date:</form:label>
					</div>
					<div class="col-sm-5">
					  <form:input path="courtDate" type="date" class="form-control" />
					</div>
				</div>
				
				<br/>
			<br/>
			
			<button type="submit" class="btn btn-primary float-right mr-5" >  &nbsp;Offer Penalty </button>
		
			 
			</div>
		<div class="col-sm-4">
		
				<div class="row">
				<div class="col-sm-4">
					 <form:label path="licenseNo" style="font-size: 20px;">License number:</form:label>
				</div>
				<div class="col-sm-8">
					 <form:input path="licenseNo"  style="font-size: 18px;" value= "${param.licenseNo}"/>
				</div>
			</div>
			
			<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
			
			<div class="row">
				<div class="col-sm-4">
					 <form:label path="nic"  style="font-size: 20px;">NIC number:</form:label>
				</div>
				<div class="col-sm-8">
					 <form:input path="nic"  style="font-size: 18px;" value="${param.nic}"/>
				</div>
			</div>
			
			
		</div>
			
			
		</div>
		
			 </form:form>
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

var endUrl = $(location).attr("href").split('/').pop();

$("#type").change(function(){
	  changeType($("#type").val());
	});


$("#type").ready(function() {
	
    changeType($("#type").val());
});

function changeType(selectedType){
	$('#offenceSelect').empty();
    
	var u = window.location.origin+'/license/penalty/search?type='+selectedType;
    $.get( u, function( data ) {
    	
		$.each(data, function (data, item) {
			
			if(endUrl.startsWith("en")){
				 $('#offenceSelect').append($('<option>', { 
					  
					   value: item.idPenalty,
				        text : item.penaltyEnglish 
				        
				    }));
			}else if(endUrl.startsWith("sn")){
				 $('#offenceSelect').append($('<option>', { 
					  
					   value: item.idPenalty,
				        text : item.penaltySinhala 
				        
				    }));
			}else if(endUrl.startsWith("tm")){
				 $('#offenceSelect').append($('<option>', { 
					  
					   value: item.idPenalty,
				        text : item.penaltyTamil 
				        
				    }));
			}
		   
		});
		
		
  	}, "json" );
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