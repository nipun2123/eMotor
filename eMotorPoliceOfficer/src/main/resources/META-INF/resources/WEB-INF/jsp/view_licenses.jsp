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

		<br />
		<div class="d-flex justify-content-center input-group">
			<div class="form-outline form-inline">
				<label class="form-label" for="form1">NIC: </label> &nbsp; 
				<input id="search-focus" type="search" id="form1" class="form-control" />
				&nbsp;&nbsp; 
				<label class="form-label" for="form1">Driving license:</label> 
				&nbsp; 
				<input id="search-focus" type="search" id="form1" class="form-control" />
			</div>
			&nbsp; &nbsp;
			<button type="button" class="btn btn-primary">
				<i class="fas fa-search"></i>
			</button>
		</div>
	

<hr style="height:2px;border-width:0;color:gray;background-color:gray">
	
	
			
			 
			 
	<div  class="ml-3">
	<div class="row">
		<div class="col-sm-8">
		
		<div class="row">
			<div class="col-sm-4">
				 <b style="font-size: 20px;">Licence number</b>
			</div>
			<div class="col-sm-8">
				 <label style="font-size: 18px;">B3838805</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				 <b style="font-size: 20px;">NIC number</b>
			</div>
			<div class="col-sm-8">
				 <label style="font-size: 18px;">20011202938</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				 <b style="font-size: 20px;">Full name:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">Amarakoon Appuhamillage Nipun Jayasanka Amarakoon</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				 <b style="font-size: 20px;">Address:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">534/1/6, Prathiba mawatha, Henihaththa Biyagama</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				  <b style="font-size: 20px;">Date of Birth:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">21/04/2000</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				  <b style="font-size: 20px;">Blood group:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">O+</label>
			</div>
		</div>
		
		
		<div class="row">
			<div class="col-sm-4">
				  <b style="font-size: 20px;">License issue date:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">08/05/2018</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				  <b style="font-size: 20px;">License expire date:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">04/05/2026</label>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				  <b style="font-size: 20px;">License Status:</b>
			</div>
			<div class="col-sm-8">
				<label style="font-size: 18px;">Suspended to 6 months</label>
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
                                            <tr>
                                            	<td>Bike</td>
												<td>04/05/2018</td>
												<td>04/05/2026</td>
                                            </tr>
                                              <tr>
                                            	<td>Van</td>
												<td>04/05/2018</td>
												<td>04/05/2026</td>
                                            </tr>
                                              <tr>
                                            	<td>Car</td>
												<td>04/05/2018</td>
												<td>04/05/2026</td>
                                            </tr>
                                    </tbody>   
                                </table>
                            </div>
		</div>
	</div>
	
	<button type="button" class="btn btn-primary float-right mr-5" > Offer penalty </button>
                     
      <br/>   
       <br/>      
      <hr style="height:1px;border-width:0;color:gray;background-color:gray">  
      
      	 <button type="button" class="btn btn-primary float-right m-2" >
                                Tamil
                            </button>
                            <button type="button" class="btn btn-primary float-right m-2" >
                                English
                            </button>
                             <button type="button" class="btn btn-primary float-right m-2" >
                                Sinhala
                            </button>                

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
                                            <tr>
                                            <td>54526559</td>
                                            	<td>vdsvdsv dsvsvs dsvdsvsd dsvdsvsd  wdwfwe rereg ewfew</td>
                                            	<td>Court</td>
                                            	<td>20/05/2021</td>
                                            	<td>30/05/2021</td>
                                            	<td>Pending</td>
                                            	<td><a>View More</a></td>

                                            </tr>
                                    </tbody>  
                                </table>
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