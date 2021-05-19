<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


	<jsp:include page="/WEB-INF/jsp/navbar.jsp">
		<jsp:param name="view_station_penalty" value="w3-blue" />
	</jsp:include>
	<jsp:include page="/WEB-INF/jsp/toolbar.jsp" />


	<div style="margin-left: 300px; margin-top: 43px;">
	 
			 
	<div  class="ml-3 m-2">
	<div class="form-check-inline ">
                                    <label >All</label>
                                     &nbsp;
                                       <label class="switch">
  					<input type="checkbox" <c:out value = "${all}"/> id="allCheck"> <span class="slider round"></span>
			</label>
                                </div>
                                
                  <div class="form-check-inline m-2">
                                    <label >Pending</label>
                                    &nbsp;
                                       <label class="switch">
  					<input type="checkbox" <c:out value = "${pending}"/> id="pendingCheck"> <span class="slider round"></span>
			</label>
                                </div>   
                                
                                
                                 
                                    <div class="form-check-inline m-2">
                                    <label >Ended</label>
                                       &nbsp;
                                       <label class="switch">
  					<input type="checkbox" <c:out value = "${ended}"/> id="endedCheck"> <span class="slider round"></span>
			</label>
                                </div>
     
			 
			        <div class="form-check-inline m-2">
                                    <label >Expired</label>
                                     &nbsp;
                                       <label class="switch">
  					<input type="checkbox" <c:out value = "${expired}"/> id="expiredCheck"> <span class="slider round"></span>
			</label>
                                </div>
                                
	
			     <div class="form-check-inline m-2">
                                    <label >My</label>
                                     &nbsp;
                                       <label class="switch">
  					<input type="checkbox" <c:out value = "${my}"/> id="myCheck"> <span class="slider round"></span>
			</label>
                                </div>
                                
                                           
                                
      	<div class="btn-group btn-group-toggle float-right m-2 " data-toggle="buttons" >
  							<label class="btn btn-secondary active">
    					<input type="radio" name="langOption" id="spotEnglishConvert" value="english" autocomplete="off" <c:out value = "${en}"/> onclick="window.location=window.location.href.match(/^.*\//)+'en' ">
					English
 							 </label>
  						<label class="btn btn-secondary">
   							 <input type="radio" name="langOption" id="spotSinhalaConvert" value="sinhala" autocomplete="off" <c:out value = "${sn}"/> onclick="window.location=window.location.href.match(/^.*\//)+'sn' "> Sinhala
 								 </label>
  						<label class="btn btn-secondary">
   							 <input type="radio" name="langOption" id="spotTamilConvert" value="tamil" autocomplete="off" <c:out value = "${tm}"/> onclick="window.location=window.location.href.match(/^.*\//)+'tm' "> Tamil
  							</label>
						</div>                   

		<div class="table-responsive">
                                <table id="penaltyTable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                        <tr>
                                        	<th>Penalty number</th>
                                        	<th>Offence</th>
                                        	<th>Penalty type</th>
                                        	<th>From</th>
                                        	<th>TO</th>
                                        	<th>Status</th>
                                        	<th>More</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                            <c:forEach items="${penalties}" var="driverPenalty">
                                    
	                                     	<tr>
	                                     	<td> ${driverPenalty.penaltyNo} </td>
	      									  <td> ${driverPenalty.penalty.penaltyCommon} </td>
	      									    <td> ${driverPenalty.type} </td>
	      									    <td> ${driverPenalty.formatedPenaltyFrom} </td>
	      									    <td> ${driverPenalty.penaltyTo} </td>
	      									        <td> ${driverPenalty.status} </td>
	      									         <td> <a href="/view/station/penalty/view/${ln}?penaltyNo=${driverPenalty.penaltyNo}">More</a>  </td>
	      									       </tr>
	      									       </c:forEach>
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

$(function(){
	   $("#allCheck").click(function(){
	        if($('[type="checkbox"]').is(":checked")){
	       
	        	if($("#pendingCheck").is(":checked")){
	        		$('#pendingCheck').prop('checked', false);
	        	}
	        	
	        	if($("#endedCheck").is(":checked")){
	        		$('#endedCheck').prop('checked', false);
	        	}
	        	
	        	if($("#expiredCheck").is(":checked")){
	        		$('#expiredCheck').prop('checked', false);
	        	}
	        	
	        	if($("#myCheck").is(":checked")){
	        		$('#myCheck').prop('checked', false);
	        	}
	        	
	        	window.location.href = window.location.origin+'/view/station/penalty/all/'+"${ln}"
	        	
	        	
	        }else{
	        	$('#allCheck').prop('checked', true);
	        	window.location.href = window.location.origin+'/view/station/penalty/all/'+"${ln}"
	        }
	        
	   })
	    
	});
	
	
$(function(){
	   $("#pendingCheck").click(function(){
	        if($('[type="checkbox"]').is(":checked")){
	       
	        	if($("#allCheck").is(":checked")){
	        		$('#allCheck').prop('checked', false);
	        	}
	        	
	        	if($("#endedCheck").is(":checked")){
	        		$('#endedCheck').prop('checked', false);
	        	}
	        	
	        	if($("#expiredCheck").is(":checked")){
	        		$('#expiredCheck').prop('checked', false);
	        	}
	        	
	        	if($("#myCheck").is(":checked")){
	        		$('#myCheck').prop('checked', false);
	        	}
	        	window.location.href = window.location.origin+'/view/station/penalty/pending/'+"${ln}"
	        	
	        	
	        }else{
	        	$('#allCheck').prop('checked', true);
	        	window.location.href = window.location.origin+'/view/station/penalty/all/'+"${ln}"
	        }
	        
	   })
	    
	});
	
	
$(function(){
	   $("#endedCheck").click(function(){
	        if($('[type="checkbox"]').is(":checked")){
	       
	        	if($("#allCheck").is(":checked")){
	        		$('#allCheck').prop('checked', false);
	        	}
	        	
	        	if($("#pendingCheck").is(":checked")){
	        		$('#pendingCheck').prop('checked', false);
	        	}
	        	
	        	if($("#expiredCheck").is(":checked")){
	        		$('#expiredCheck').prop('checked', false);
	        	}
	        	
	        	if($("#myCheck").is(":checked")){
	        		$('#myCheck').prop('checked', false);
	        	}
	        	window.location.href = window.location.origin+'/view/station/penalty/ended/'+"${ln}"
	        	
	        	
	        }else{
	        	$('#allCheck').prop('checked', true);
	        	window.location.href = window.location.origin+'/view/station/penalty/all/'+"${ln}"
	        }
	        
	   })
	    
	});
	
	
$(function(){
	   $("#expiredCheck").click(function(){
	        if($('[type="checkbox"]').is(":checked")){
	       
	        	if($("#allCheck").is(":checked")){
	        		$('#allCheck').prop('checked', false);
	        	}
	        	
	        	if($("#pendingCheck").is(":checked")){
	        		$('#pendingCheck').prop('checked', false);
	        	}
	        	
	        	if($("#endedCheck").is(":checked")){
	        		$('#endedCheck').prop('checked', false);
	        	}
	        	
	        	if($("#myCheck").is(":checked")){
	        		$('#myCheck').prop('checked', false);
	        	}
	        	window.location.href = window.location.origin+'/view/station/penalty/expired/'+"${ln}"
	        	
	        	
	        }else{
	        	$('#allCheck').prop('checked', true);
	        	window.location.href = window.location.origin+'/view/station/penalty/all/'+"${ln}"
	        }
	        
	   })
	    
	});
	
	
$(function(){
	   $("#myCheck").click(function(){
	        if($('[type="checkbox"]').is(":checked")){
	       
	        	if($("#allCheck").is(":checked")){
	        		$('#allCheck').prop('checked', false);
	        	}
	        	
	        	if($("#pendingCheck").is(":checked")){
	        		$('#pendingCheck').prop('checked', false);
	        	}
	        	
	        	if($("#endedCheck").is(":checked")){
	        		$('#endedCheck').prop('checked', false);
	        	}
	        	
	        	if($("#expiredCheck").is(":checked")){
	        		$('#expiredCheck').prop('checked', false);
	        	}
	        	window.location.href = window.location.origin+'/view/station/penalty/my/'+"${ln}"
	        	
	        	
	        }else{
	        	$('#allCheck').prop('checked', true);
	        	window.location.href = window.location.origin+'/view/station/penalty/all/'+"${ln}"
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

</script>
</html>