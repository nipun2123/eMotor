<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		<jsp:param name="end_penalty" value="w3-blue" />
	</jsp:include>
	<jsp:include page="/WEB-INF/jsp/toolbar.jsp" />


	<div style="margin-left: 300px; margin-top: 43px;">

		<br />
		<div class="d-flex justify-content-center input-group">
		
			<div class="form-outline form-inline">
		
		
			<form:form action="/end/penalty/search/license/${ln}" method="GET" modelAttribute = "endPenaltyBean">
			<div class="form-outline form-inline">
				<form:label path= "licenseNo" class="form-label" >Driving license </form:label> &nbsp; 
				<form:input path= "licenseNo" id="search-focus" type="search" class="form-control" value="${param.licenseNo}" />
				&nbsp;&nbsp; 
			<button type="submit" class="btn btn-primary">
				<i class="fas fa-search"></i>
			</button>
			</div>
			</form:form>
			
				&nbsp;&nbsp; 
			<form:form action="/end/penalty/search/penalty/${ln}" method="GET" modelAttribute = "endPenaltyBean">
			
			<div class="form-outline form-inline">
		
				<form:label path="penaltyNo" class="form-label" >Penalty number</form:label> 
				&nbsp; 
				<form:input path="penaltyNo" id="search-focus" type="search"  class="form-control" value="${param.penaltyNo}" />
			
			&nbsp; &nbsp;
			<button type="submit" class="btn btn-primary">
				<i class="fas fa-search"></i>
			</button>
			</div>
				</form:form>
			</div>
		</div>
	

<hr style="height:2px;border-width:0;color:gray;background-color:gray">
	
	
			
			 
			 
	<div  class="ml-3">
	
<c:set var="par1" value="${param}"/>
<c:set var="par2" value="${fn:replace(par1, '{','')}"/>
<c:set var="par3" value="${fn:replace(par2, '}','')}"/>
      
     <div class="btn-group btn-group-toggle float-right m-2 " data-toggle="buttons" >
  							<label class="btn btn-secondary active">
    					<input type="radio" name="langOption" id="spotEnglishConvert" value="english" autocomplete="off" <c:out value = "${en}"/> onclick="window.location=window.location.href.match(/^.*\//)+'en'+'?${par3}' ">
					English
 							 </label>
  						<label class="btn btn-secondary">
   							 <input type="radio" name="langOption" id="spotSinhalaConvert" value="sinhala" autocomplete="off" <c:out value = "${sn}"/> onclick="window.location=window.location.href.match(/^.*\//)+'sn'+'?${par3}' "> Sinhala
 								 </label>
  						<label class="btn btn-secondary">
   							 <input type="radio" name="langOption" id="spotTamilConvert" value="tamil" autocomplete="off" <c:out value = "${tm}"/> onclick="window.location=window.location.href.match(/^.*\//)+'tm'+'?${par3}' "> Tamil
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
                                        	<th>Result</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                    
                                        <c:forEach items="${penalty}" var="driverPenalty">
                                    
	                                     	<tr>
	                                     	<td> ${driverPenalty.penaltyNo} </td>
	      									  <td> ${driverPenalty.penalty.penaltyCommon} </td>
	      									    <td> ${driverPenalty.penalty.type} </td>
	      									      <td> ${driverPenalty.formatedPenaltyFrom} </td>
	      									       <td> ${driverPenalty.penaltyTo} </td>
	      									        <td> ${driverPenalty.status} </td>
	      									         <td> <a href="/end/penalty/view/${ln}?penaltyNo=${driverPenalty.penaltyNo}">More</a>  </td>
	      									         
	      									 <c:choose>
  												<c:when test="${driverPenalty.type=='spot'}">
  													<td>
  													<button type="button" class="btn btn-secondary btn-sm" onclick="spotButtonClick('${driverPenalty.penaltyNo}')" data-toggle="modal" data-target="#endSpotPenaltyModel" >End the penalty</button>
  													</td>
  												</c:when>
  												
  												<c:when test="${driverPenalty.type=='warn'}">
  													<td>
  													<button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#endWarnPenaltyModel" >End the penalty</button>
  													</td>
  												</c:when>
  												
  												<c:when test="${driverPenalty.type=='court'}">
  													<td>
  													<button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#endCourtPenaltyModel" >End the penalty</button>
  													</td>
  												</c:when>
 
											</c:choose>
												
	      									 </tr> 
   									 </c:forEach>
                                    
                                    </tbody>  
                                </table>
                            </div> 
                            
                            
                            
                            
            <div class="modal fade" id="endSpotPenaltyModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content" >

                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>

                        <form:form action="/end/penalty/spot" method="POST" modelAttribute="endPenaltyBean">

                            <form:label path="paidAmount" id ="spotFineLabel" ></form:label>
                             <form:label path="paidAmount">Are You sure to end this penalty?</form:label>
                               <form:input path="penaltyNo" type="text" id="spotPenaltyNo" style="display: none"/>
                               <form:input path="paidAmount" type="text" id="spotFineAmount" style="display: none"/>
                            <br/>
                            <div class="d-flex align-items-center justify-content-center">
                                <button type="submit" class="btn btn-primary" >Yes</button> 
                                &nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-secondary"  class="close" data-dismiss="modal" aria-label="Close">No</button> 
                            </div>
                        </form:form>

                    </div>
                </div>
            </div>
        </div>
        
        
        <div class="modal fade" id="endWarnPenaltyModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content" >

                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>

                        <form:form action="/end/penalty/warn" method="POST" modelAttribute="endPenaltyBean">

                             <form:label path="penaltyNo">Are You sure to end this penalty?</form:label>
                             <form:input path="penaltyNo" type="text" id="warnPenaltyNo" style="display: none"/>
                            <br/>
                            <div class="d-flex align-items-center justify-content-center">
                                <button type="submit" class="btn btn-primary" >Yes</button> 
                                &nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-secondary"  class="close" data-dismiss="modal" aria-label="Close">No</button> 
                            </div>
                        </form:form>

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

                        <form:form action="/end/penalty/court" method="POST" modelAttribute="endPenaltyBean">


                              <div class="form-check-inline">
                             <form:label path="payFine" class="form-check-label">
                                         <form:checkbox  path="payFine"  id="finedCheck" class="form-check-input"  value="true" name="payFine"/>Fined
                                    </form:label>
                                   
                                </div>
                                <div class="form-group" id="finedContent" style="display:none;">
                                 <form:label path="paidAmount" >Fine amount</form:label>
                                 <form:input path="paidAmount" type="text" class="form-control"  />
                                 </div>
                                <hr/>
                             
                               <div class="form-check-inline">
                                    <form:label path="licenseSuspend" class="form-check-label">
                                        <form:checkbox path="licenseSuspend"  id="suspendCheck" class="form-check-input"  value="true" name="licenseSuspend"/>Suspended
                                    </form:label>
                                </div>
                                
                                <br/>
                                 <br/>
                                 
                              
                              <div class="row" id="suspendContent" style="display:none;">
                              <div class="col-sm-4">
                              <div class="form-check-inline">
                                     <form:label path="suspededYear">Year</form:label>
                                     &nbsp;
                                    <form:input path="suspededYear" type="number" class="form-control"  />
                              </div>
                              </div>
                              
                              <div class="col-sm-4">
                                  <div class="form-check-inline">
                                     <form:label path="suspededMonth">Month</form:label>
                                      &nbsp;
                                    <form:input path="suspededMonth" type="number" class="form-control" />
                                     </div>
                              </div>
                              
                              <div class="col-sm-4">
                                  <div class="form-check-inline">
                                 <form:label path="suspededDate">Date</form:label>
                                  &nbsp;
                                    <form:input path="suspededDate" type="number" class="form-control" />
                                     </div>
                              </div>
                              
                              </div>
                                
                                 <hr/>
                                  <div class="form-check-inline">
                                    <form:label path="jailed" class="form-check-label">
                                    
                                        <form:checkbox path="jailed" id="jailedCheck" class="form-check-input"  value="true" name="jailed"/>Jailed
                                    </form:label>
                                </div>
                                
                                <br/>
                                 <br/>
                                 
                              
                              <div class="row" id = "jailedContent" style="display:none;">
                              <div class="col-sm-4">
                              <div class="form-check-inline">
                                     <form:label path="jailedYear">Year</form:label>
                                      &nbsp;
                                    <form:input path="jailedYear" type="number" class="form-control" />
                              </div>
                              </div>
                              
                              <div class="col-sm-4">
                                  <div class="form-check-inline">
                                     <form:label path="jailedMonth">Month</form:label>
                                      &nbsp;
                                    <form:input path="jailedMonth" type="number" class="form-control" />
                                     </div>
                              </div>
                              
                              <div class="col-sm-4">
                                  <div class="form-check-inline">
                                 <form:label path="jailedDate">Date</form:label>
                                  &nbsp;
                                    <form:input path="jailedDate" type="number" class="form-control" />
                                     </div>
                              </div>
                              
                              </div>
                                  
                                  <hr/>
                                  <div class="form-check-inline" >
                                    <form:label path="freed" class="form-check-label">
                                     
                                        <form:checkbox path="freed" id="freedCheck" class="form-check-input"  value="true" name="freed"/>Freed
                                    </form:label>
                                </div>
                                <form:input path="penaltyNo" type="text" id="courtPenaltyNo" style="display: none"/>
                                <br/>
                                <br/>
                                <div class="d-flex float-right">
                                  <button type="submit" class="btn btn-primary" >Submit</button> 
								</div>
                        </form:form>

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


$(function(){
	   $("#finedCheck").click(function(){
	        if($('[type="checkbox"]').is(":checked")){
	        	
	        	$("#finedContent").show();
	        	if($("#freedCheck").is(":checked")){
	        		$('#freedCheck').prop('checked', false);
	        	}
	        	
	        	
	        	
	        }else{
	        	$("#finedContent").hide();
	        	
	         }
	        
	   })
	    
	});
	
	
$(function(){
	   $("#suspendCheck").click(function(){
	        if($('[type="checkbox"]').is(":checked")){
	        	
	        	$("#suspendContent").show();
	        	if($("#freedCheck").is(":checked")){
	        		$('#freedCheck').prop('checked', false);
	        	}
	        	
	        	
	        	
	        }else{
	        	$("#suspendContent").hide();
	        	
	         }
	        
	   })
	    
	});

$(function(){
	   $("#jailedCheck").click(function(){
	        if($('[type="checkbox"]').is(":checked")){
	        	
	        	$("#jailedContent").show();
	        	if($("#freedCheck").is(":checked")){
	        		$('#freedCheck').prop('checked', false);
	        	}
	        	
	        	 
	        }else{
	        	$("#jailedContent").hide();
	        	
	         }
	        
	   })
	    
	});
	
	
$(function(){
	   $("#freedCheck").click(function(){
	        if($('[type="checkbox"]').is(":checked")){
	        	
	        	if($("#finedCheck").is(":checked")){
	        		$('#finedCheck').prop('checked', false);
	        	}
	        	
	        	if($("#suspendCheck").is(":checked")){
	        		$('#suspendCheck').prop('checked', false);
	        	}
	        	
	        	if($("#jailedCheck").is(":checked")){
	        		$('#jailedCheck').prop('checked', false);
	        	}
	        	 
	        }
	        
	   })
	    
	});




function spotButtonClick(penaltyNo){
	
	var u = window.location.origin+'/penalty/find?penaltyNo='+penaltyNo;
  
  	 $.get( u, function( data ) {
  		if(data.status.toLowerCase() === 'double pending'){
  			
  			$("#spotFineLabel").html('The Fine amount is rs.'+data.penalty.fineAmount.amount *2 );
  			$("#spotFineAmount").val(data.penalty.fineAmount.amount *2 );
  		}else{
  			$("#spotFineLabel").html('The Fine amount is rs.'+data.penalty.fineAmount.amount);
  			$("#spotFineAmount").val(data.penalty.fineAmount.amount);
  		}
  		
  		
 		
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
        
       $("#warnPenaltyNo").val(selectRow[0]);
        $("#spotPenaltyNo").val(selectRow[0]);
        $("#courtPenaltyNo").val(selectRow[0]);
    });
});


$('#endSpotPenaltyModel').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus');
});

$('#endWarnPenaltyModel').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus');
});

$('#endCourtPenaltyModel').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus');
});
</script>
</html>