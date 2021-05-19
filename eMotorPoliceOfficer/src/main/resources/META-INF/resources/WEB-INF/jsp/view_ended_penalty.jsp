<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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


<title>View payments</title>
</head>
<body>


	<jsp:include page="/WEB-INF/jsp/navbar.jsp">
		<jsp:param name="view_ended_penalty" value="w3-blue" />
	</jsp:include>
	<jsp:include page="/WEB-INF/jsp/toolbar.jsp" />


	<div style="margin-left: 300px; margin-top: 43px;">

		<br/>
		
	
	<div  class="ml-3">
	
	<div class="input-group">
		<div class="form-outline form-inline">
			<label class="form-label" for="form1">End date:</label> &nbsp;
			                      
             <div class="form-check-inline m-2">
                                    <label for="fineAmount">All</label>
                                     &nbsp;
            <label class="switch">
  					<input type="checkbox" id="allCheck" <c:out value = "${all}"/> > <span class="slider round"></span>
			</label>
            </div>
            
            &nbsp;&nbsp;
            
            <div class="form-check-inline m-2">
                                    <label for="fineAmount">Today</label>
                                     &nbsp;
            <label class="switch">
  					<input type="checkbox" id="todayCheck" <c:out value = "${today}"/> > <span class="slider round"></span>
			</label>
            </div>
            
            
			&nbsp;&nbsp;
			<form action="/view/endedpenalty/between/${ln}" method="GET">
			<div class="form-check-inline">
				<label class="form-label" for="form1">From</label> &nbsp; 
				<input id="search-focus" name="from" type="date" id="fromDate" class="form-control" />
			
			&nbsp;&nbsp; 
				<label class="form-label" for="form1">To</label> 
				&nbsp; 
				<input id="search-focus" name="to" type=date id="toDate" class="form-control" />
			
			&nbsp; &nbsp;
			<button type="submit" class="btn btn-primary"  >
				<i class="fas fa-search"></i>
			</button>
			</div>
			</form>
			</div>
			</div> 
			 </div> 
			 
			 <c:set var="par1" value="${param}"/>
			
<c:set var="par2" value="${fn:replace(par1, '{','')}"/>
<c:set var="par3" value="${fn:replace(par2, '}','')}"/>
<c:set var="par4" value="${fn:replace(par3, ', ','&')}"/>


      	     <div class="btn-group btn-group-toggle float-right m-2 " data-toggle="buttons" >
  							<label class="btn btn-secondary active">
    					<input type="radio" name="langOption" id="spotEnglishConvert" value="english" autocomplete="off" <c:out value = "${en}"/> onclick="window.location=window.location.href.match(/^.*\//)+'en?${par4}' ">
					English
 							 </label>
  						<label class="btn btn-secondary">
   							 <input type="radio" name="langOption" id="spotSinhalaConvert" value="sinhala" autocomplete="off" <c:out value = "${sn}"/> onclick="window.location=window.location.href.match(/^.*\//)+'sn?${par4}' "> Sinhala
 								 </label>
  						<label class="btn btn-secondary">
   							 <input type="radio" name="langOption" id="spotTamilConvert" value="tamil" autocomplete="off" <c:out value = "${tm}"/> onclick="window.location=window.location.href.match(/^.*\//)+'tm?${par4}' "> Tamil
  							</label>
						</div>               

		<div class="table-responsive">
                                <table id="penaltyTable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                                <tr>
                                        	<th>Penalty number</th>
                                        	<th>Penalty type</th>
                                        	<th>Result</th>
                                        	<th>Who end penalty no</th>
                                        	<th>Who end penalty name</th>
                                        	<th>End date</th>
                                        	<th>More</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                            <c:forEach items="${penalties}" var="driverPenalty">
                                    
	                                     	<tr>
	                                     	<td> ${driverPenalty.penaltyNo} </td>
	      									  <td> ${driverPenalty.type} </td>
	      									    <td> ${driverPenalty.completedRecord.result} </td>
	      									      <td> ${driverPenalty.completedRecord.useraccount.officer.fName} ${driverPenalty.completedRecord.useraccount.officer.lName}</td>
	      									       <td> ${driverPenalty.completedRecord.useraccount.officer.officerNo}</td>
	      									        <td> ${driverPenalty.completedRecord.formatedCompletedDate} </td>
	      									         <td> <a href="/view/endedpenalty/view/${ln}?penaltyNo=${driverPenalty.penaltyNo}">More</a>  </td>
	      									       </tr>
	      									       </c:forEach>
                                    </tbody>  
                                </table>
                            </div> 
                            
                            
                            
                            
            <div class="modal fade" id="endPenaltyModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content" >

                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>

                        <form action="#" method="POST">

                            <label >Are You sure to end this penalty?</label>
                            <br/>
                            <div class="d-flex align-items-center justify-content-center">
                                <button type="submit" class="btn btn-primary" >Yes</button> 
                                &nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-secondary"  class="close" data-dismiss="modal" aria-label="Close">No</button> 
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        
        
          <div class="modal fade" id="endCourtPenaltyModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content" >

                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>

                        <form action="#" method="POST">

                              <div class="form-group">
                                    <label for="fineAmount">Fine Amount</label>
                                    <input type="text" class="form-control" id="oic" required name="fineAmount">
                                </div>
                                
                                 <br/>
                                  <br/>
                                   <div class="form-check-inline">
                                    <label class="form-check-label">
                                        <input type="radio" id="deactive" class="form-check-input" checked value="deactive" name="status">Not suspended
                                    </label>
                                </div>
                                
                                    <div class="form-check-inline">
                                    <label class="form-check-label">
                                        <input type="radio" id="active" class="form-check-input"  value="active" name="status">Suspended
                                    </label>
                                </div>
                                
                                <br/>
                                 <br/>
                                 
                                 <div class="row">
                             
                              <div class="row">
                              <div class="col-sm-4">
                              <div class="form-check-inline">
                                     <label for="suspendYear">Suspend year</label>
                                    <input type="number" class="form-control" id="suspendYear" required name="suspendYear">
                              </div>
                              </div>
                              
                              <div class="col-sm-4">
                                  <div class="form-check-inline">
                                     <label for="suspendMonth">Suspend Month</label>
                                    <input type="number" class="form-control" id="suspendMonth" required name="suspendMonth">
                                     </div>
                              </div>
                              
                              <div class="col-sm-4">
                                  <div class="form-check-inline">
                                 <label for="suspendDate">Suspend Date</label>
                                    <input type="number" class="form-control" id="suspendDate" required name="suspendDate">
                                     </div>
                              </div>
                              
                              </div>
                                
                               
                                
                             </div>

                        </form>

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

$(function(){
	   $("#allCheck").click(function(){
	        if($('[type="checkbox"]').is(":checked")){
	       
	        	if($("#todayCheck").is(":checked")){
	        		$('#todayCheck').prop('checked', false);
	        	}
	        	
	        	window.location.href = window.location.origin+'/view/endedpenalty/all/'+"${ln}"
	        	
	        	
	        }else{
	        	window.location.href = window.location.origin+'/view/endedpenalty/today/'+"${ln}"
	        	
	         }
	        
	   })
	    
	});
	
$(function(){
	   $("#todayCheck").click(function(){
	        if($('[type="checkbox"]').is(":checked")){
	       
	        	if($("#allCheck").is(":checked")){
	        		$('#allCheck').prop('checked', false);
	        	}
	        	
	        	window.location.href = window.location.origin+'/view/endedpenalty/today/'+"${ln}"
	        	
	        	
	        }else{
	        	window.location.href = window.location.origin+'/view/endedpenalty/all/'+"${ln}"
	        	
	         }
	        
	   })
	    
	});
	
	
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


$('#endPenaltyModel').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus');
});
</script>
</html>