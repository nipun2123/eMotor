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
  
  
  <style>
.switch {
  position: relative;
  display: inline-block;
  width: 55px;
  height: 28px;
}

.switch input { 
  opacity: 0;
  width: 0;
  height: 0;
}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 22px;
  width: 22px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
</style>
<title>View licenses</title>
</head>
<body>


	<jsp:include page="/WEB-INF/jsp/traffic/navbar.jsp">
		<jsp:param name="penalty" value="w3-blue" />
	</jsp:include>
	<jsp:include page="/WEB-INF/jsp/traffic/toolbar.jsp" />


	<div style="margin-left: 300px; margin-top: 43px;">
	 
			 
	<div  class="ml-3">
	
			
			     <div class="form-check-inline m-2">
                                    <label for="fineAmount">Only my</label>
                                     &nbsp;
                                       <label class="switch">
  					<input type="checkbox"> <span class="slider round"></span>
			</label>
                                </div>
                                 &nbsp; &nbsp;
                                
             <div class="form-check-inline m-2">
                                    <label for="fineAmount">Only completed</label>
                                     &nbsp;
                                       <label class="switch">
  					<input type="checkbox"> <span class="slider round"></span>
			</label>
                                </div>
                                
                                 &nbsp; &nbsp;
                                 
                  <div class="form-check-inline m-2">
                                    <label for="fineAmount">Only pending</label>
                                    &nbsp;
                                       <label class="switch">
  					<input type="checkbox"> <span class="slider round"></span>
			</label>
                                </div>               
                                
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
                                        	<th>Detected officer no</th>
                                        	<th>Detected officer name</th>
                                        	<th>Status</th>
                                        	<th>More</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                            <tr>
                                            	<td>45613216</td>
                                            	<td>vdsvdsv dsvsvs dsvdsvsd dsvdsvsd  wdwfwe rereg ewfew</td>
                                            	<td>Court</td>
                                            	<td>20/05/2021</td>
                                            	<td>30/05/2021</td>
                                            	<td>98465698</td>
												<td>Nipun jayasanka</td>
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