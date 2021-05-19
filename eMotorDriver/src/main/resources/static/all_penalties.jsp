<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
    
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.5/css/buttons.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.1/css/select.bootstrap4.min.css"/>
  <link rel="stylesheet" type="text/css" href="https://editor.datatables.net/extensions/Editor/css/editor.bootstrap4.min.css"/>
        
<title>All penalties</title>
</head>
<body>

        <div  style="margin-top:23px;" class="container-fluid">
        	 		<div class="row d-flex justify-content-end">
        	 				 <button type="button" class="btn btn-primary m-2" >
                                Sinhala
                            </button>
        	 				
                            <button type="button" class="btn btn-primary m-2" >
                                English
                            </button>
                            <button type="button" class="btn btn-primary m-2" >
                                Tamil
                            </button>
                            
                 </div>
 
<div id="accordion">
                <div class="card">
                    <div class="card-header" id="headingOne">
                        <h5 class="mb-0">
                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Spot Fine Offence Registration
                            </button>
                        </h5>
                    </div>

                    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                        <div class="card-body">
                          

						
                            
                            
                            <div class="table-responsive">
                                <table id="spotOffenceTable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                        <tr>
                                        	<th>Offence</th>
                                        	<th>Fine</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                            <tr>
                                            	<td>Iri kapuwa</td>
                                            	<td>10</td>

                                            </tr>
                                    </tbody>  
                                </table>
                            </div>      
                        </div>
                    </div>
                </div>
                
                <div class="card">
                    <div class="card-header" id="headingTwo">
                        <h5 class="mb-0">
                            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                                Court Offence Registration
                            </button>
                        </h5>
                    </div>
                    <div id="collapseTwo" class="collapse show" aria-labelledby="headingTwo" data-parent="#accordion">
                        <div class="card-body">
                       
 						
                            
                            
                            <div class="table-responsive">
                                <table id="courtOffenceTable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                        <tr>
                                        	<th>Offence</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                            <tr>
                                            	<td>Drive under influence of alcohol</td>

                                            </tr>
                                    </tbody>   
                                </table>
                            </div>

                        </div>

                    </div>
                </div>

				<div class="card">
                    <div class="card-header" id="headingThree">
                        <h5 class="mb-0">
                            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
                                Warn Offence Registration
                            </button>
                        </h5>
                    </div>
                    <div id="collapseThree" class="collapse show" aria-labelledby="headingThree" data-parent="#accordion">
                        <div class="card-body">
                      
                         
                            
                            
                            <div class="table-responsive">
                                <table id="warnOffenceTable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                        <tr>
                                        	<th>Offence</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                            <tr>
                                            	<td>No break</td>

                                            </tr>
                                    </tbody>   
                                </table>
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
		    var table = $('#spotOffenceTable').DataTable({
		        lengthChange: false,
		        "paging": false,
		        select: true
		    });
		    $('#policeTable tbody').on('click', 'tr', function () {
		        var selectRow = table.rows(this).data()[0];
		    });
		});
		
		
		$(document).ready(function () {
		    var table = $('#courtOffenceTable').DataTable({
		        lengthChange: false,
		        "paging": false,
		        select: true
		    });
		    $('#policeTable tbody').on('click', 'tr', function () {
		        var selectRow = table.rows(this).data()[0];
		    });
		});
		
		
		$(document).ready(function () {
		    var table = $('#warnOffenceTable').DataTable({
		        lengthChange: false,
		        "paging": false,
		        select: true
		    });
		    $('#policeTable tbody').on('click', 'tr', function () {
		        var selectRow = table.rows(this).data()[0];
		    });
		});
		
		$('#spotOffenceModel').on('shown.bs.modal', function () {
		    $('#myInput').trigger('focus');
		});
		$('#courtOffenceModel').on('shown.bs.modal', function () {
		    $('#myInput').trigger('focus');
		});
		$('#warnOffenceModel').on('shown.bs.modal', function () {
		    $('#myInput').trigger('focus');
		});
		$('#settingsModel').on('shown.bs.modal', function () {
		    $('#myInput').trigger('focus');
		});
</script>
</html>