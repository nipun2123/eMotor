<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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


	<jsp:include page="/WEB-INF/jsp/traffic/navbar.jsp">
		<jsp:param name="license" value="w3-blue" />
	</jsp:include>
	<jsp:include page="/WEB-INF/jsp/traffic/toolbar.jsp" />


	<div style="margin-left: 300px; margin-top: 43px;">

	<div  class="p-4" >
	<div class="row">
		<button type="button" class="btn btn-outline-secondary" > &#60;&#60;  &nbsp;Back </button>
	</div>	
		
		<br/>
	<div class="row">
		<div class="col-sm-8">
				<div class="row">
					<div class="col-sm-3">
					 <label style="font-size: 20px;">Penalty number:</label>
					</div>
					<div class="col-sm-9">
					  <label style="font-size: 18px;">057236</label>
					</div>
				</div>
				
			<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
			<div class="row">
					<div class="col-sm-3">
					 <label style="font-size: 20px;">Offence type:</label>
					</div>
					<div class="col-sm-5">
					   <select class="form-control browser-default custom-select"  id="type" name="type">
                                            <option value="spot">Spot Fine</option>
                                            <option value="court">Court</option>
                                            <option value="warn">Warn</option>
                       </select>
					</div>
				</div>
				
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
				
			<div class="row">
					<div class="col-sm-3">
					 <label style="font-size: 20px;">Offence:</label>
					</div>
					<div class="col-sm-9">
					    <select class="form-control browser-default custom-select"  id="type" name="type">
                                            <option value="">dsfcsed efes fsdfs rfg dw dss dvdvd wdw cscse evd</option>
                                            <option value="">dvdsvsd bth tht kkok dnfd kvdmvk dvd</option>
                                            <option value="">kfdbk dfvdif ehudwye udhsvusd jnvdsjnvkds dnsvjsdkbdo  dsjvsdjowifoi sdvjsdvuhsd </option>
                       </select> 
					</div>
				</div>

					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
			<div class="row">
					<div class="col-sm-3">
					  <label style="font-size: 20px;">Vehicle number:</label>
					</div>
					<div class="col-sm-5">
					    <input type="text" class="form-control" id="vehicleno" required name="vehicleno" >
					</div>
				</div>
				
		
				
					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
				<div class="row">
					<div class="col-sm-3">
					  	 <label style="font-size: 20px;">Place of Offence:</label>
					</div>
					<div class="col-sm-5">
					    <input type="text" class="form-control" id="place" required name="place" >
					</div>
				</div>
				
				
					<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
					<div class="row">
					<div class="col-sm-3">
					  	<label style="font-size: 20px;">Court:</label>
					</div>
					<div class="col-sm-5">
					   <input type="text" class="form-control" id="court" required name="court" >
					</div>
				</div>
				
				<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
					
				<div class="row">
					<div class="col-sm-3">
					  	<label style="font-size: 20px;">Court date:</label>
					</div>
					<div class="col-sm-5">
					  <input type="date" class="form-control" id="courtdate" required name="courtdate" >
					</div>
				</div>
				
				<br/>
			<br/>
			
			<button type="button" class="btn btn-primary float-right mr-5" >  &nbsp;Offer Penalty </button>
			
			</div>
		<div class="col-sm-4">
		
				<div class="row">
				<div class="col-sm-4">
					 <label style="font-size: 20px;">Licence number:</label>
				</div>
				<div class="col-sm-8">
					 <label style="font-size: 18px;">B3838805</label>
				</div>
			</div>
			
			<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
			
			<div class="row">
				<div class="col-sm-4">
					 <label style="font-size: 20px;">NIC number:</label>
				</div>
				<div class="col-sm-8">
					 <label style="font-size: 18px;">20011202938</label>
				</div>
			</div>
			
			<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
			
			
			<div class="row">
				<div class="col-sm-4">
					 <label style="font-size: 20px;">Full name:</label>
				</div>
				<div class="col-sm-8">
					<label style="font-size: 18px;">Amarakoon Appuhamillage Nipun Jayasanka Amarakoon</label>
				</div>
			</div>
			
			<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
			
			<div class="row">
				<div class="col-sm-4">
					 <label style="font-size: 20px;">Address:</label>
				</div>
				<div class="col-sm-8">
					<label style="font-size: 18px;">534/1/6, Prathiba mawatha, Henihaththa Biyagama</label>
				</div>
			</div>
			
			<hr  style="height:1px;border-width:0;color:gray;background-color:gray" />
			
			<div class="row">
			<div class="col-sm-4">
				  <label style="font-size: 20px;">License Status:</label>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">Suspended to 6 months</label>
			</div>
		</div>
			
			
		</div>
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