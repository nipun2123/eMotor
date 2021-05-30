<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
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
          <c:if test="${error != null}">
  <script>
  	alert('The process did not success!');
  </script>
   </c:if>   
<title>Penalty maintain</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/navbar.jsp">
            <jsp:param name="offence" value="w3-blue" />
        </jsp:include>
     <jsp:include page="/WEB-INF/jsp/toolbar.jsp"/>   


        <div  style="margin-left:300px;margin-top:43px;">


                            
        <div class="btn-group btn-group-toggle float-right m-2 " data-toggle="buttons" >
  							<label class="btn btn-secondary active">
    						<input type="radio" name="langOption"  id="spotEnglishConvert" value="english" autocomplete="off"  <c:out value = "${en}"/> onclick="window.location=window.location.href.match(/^.*\//)+'en' "> English
 							 </label>
  						<label class="btn btn-secondary">
   							 <input type="radio" name="langOption" id="spotSinhalaConvert" value="sinhala" autocomplete="off" <c:out value = "${sn}"/> onclick="window.location=window.location.href.match(/^.*\//)+'sn' "> Sinhala
 								 </label>
  						<label class="btn btn-secondary">
   							 <input type="radio" name="langOption" id="spotTamilConvert" value="tamil" autocomplete="off" <c:out value = "${tm}"/> onclick="window.location=window.location.href.match(/^.*\//)+'tm' "> Tamil
  							</label>
						</div>
						
						 <button type="button" class="btn btn-secondary  float-right m-2" data-toggle="modal" data-target="#settingsModel">
                                Settings
                            </button>
						<br/>
							<br/>
							<br/>
							<br/>
<div id="accordion" >
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
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#spotOffenceModel">
                                Register offence
                            </button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#spotOffenceModel">
                                Update offence
                            </button>
                            
                             <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteOffenceModel">
                                Delete offence
                            </button>
                            
                             
                            
						
                            
                            
                            <div class="table-responsive">
                                <table id="spotOffenceTable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                        <tr>
                                        	<th>Id</th>
                                        	<th>Offence</th>
                                        	<th>Fine</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                           <c:forEach items="${penalties}" var="thePenalty">
                                     
                                     		<c:if test="${thePenalty.status == true && thePenalty.type == 'spot'}">
	                                     			<tr>
	                                     	 			<td> ${thePenalty.idPenalty} </td>
	      											    <td> ${thePenalty.penaltyCommon} </td>
	      									  			<td> ${thePenalty.fineAmount.amount} </td>
	      										     </tr> 
	      									 </c:if>
   									 </c:forEach>
                                    </tbody>  
                                </table>
                            </div>      
                        </div>
                    </div>
                </div>
                
                <div class="card">
                    <div class="card-header" id="headingTwo">
                        <h5 class="mb-0">
                            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                Court Offence Registration
                            </button>
                        </h5>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                        <div class="card-body">
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#courtOffenceModel">
                                 Register offence
                            </button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#courtOffenceModel">
                                Update offence
                            </button>
 						
                             <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteOffenceModel">
                                Delete offence
                            </button>
                            
                            <div class="table-responsive">
                                <table id="courtOffenceTable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                        <tr>
                                        	<th>Id</th>
                                        	<th>Offence</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach items="${penalties}" var="thePenalty">
                                     
                                     		<c:if test="${thePenalty.status == true && thePenalty.type == 'court'}">
	                                     			<tr>
	                                     	 			<td> ${thePenalty.idPenalty} </td>
	      											    <td> ${thePenalty.penaltyCommon} </td>
	      										     </tr> 
	      									 </c:if>
   									 </c:forEach>
                                    </tbody>   
                                </table>
                            </div>

                        </div>

                    </div>
                </div>

				<div class="card">
                    <div class="card-header" id="headingThree">
                        <h5 class="mb-0">
                            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                Warn Offence Registration
                            </button>
                        </h5>
                    </div>
                    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                        <div class="card-body">
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#warnOffenceModel">
                                Register offence
                            </button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#warnOffenceModel">
                                Update offence
                            </button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteOffenceModel">
                                Delete offence
                            </button>
						
                            
                            
                            <div class="table-responsive">
                                <table id="warnOffenceTable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                        <tr>
                                        	<th>Id</th>
                                        	<th>Offence</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                   	<c:forEach items="${penalties}" var="thePenalty">
                                     
                                     		<c:if test="${thePenalty.status == true && thePenalty.type == 'warn'}">
	                                     			<tr>
	                                     	 			<td> ${thePenalty.idPenalty} </td>
	      											    <td> ${thePenalty.penaltyCommon} </td>
	      										     </tr> 
	      									 </c:if>
   									 </c:forEach>
                                    </tbody>   
                                </table>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
            
        
            
            <div class="modal fade" id="spotOffenceModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <form:form action="/department/penalty/spot/save" method="POST" modelAttribute = "penalty" >
								
                                	

							<spring:bind path="penaltyEnglish">
							<div class="form-group ${status.error ? 'has-error' : ''}">
                                <div class="form-group">
                                    <form:label path="penaltyEnglish">Offence in English</form:label>
                                    <form:input path="penaltyEnglish" type="text" class="form-control" id="spotPenaltyEnglish"/>
                                    <form:errors path="penaltyEnglish" style="color: red;"></form:errors>
                                </div>
                              </div>
                              </spring:bind>
                              
                              <spring:bind path="penaltySinhala">
							<div class="form-group ${status.error ? 'has-error' : ''}">  
                                <div class="form-group">
                                    <form:label path="penaltySinhala">Offence in Sinhala</form:label>
                                    <form:input path="penaltySinhala" type="text" class="form-control" id="spotPenaltySinhala"/>
                                    <form:errors path="penaltySinhala" style="color: red;"></form:errors>
                                </div>
                                </div>
                                </spring:bind>
                                
                                
                                <spring:bind path="penaltyTamil">
							<div class="form-group ${status.error ? 'has-error' : ''}">
                                <div class="form-group">
                                    <form:label path="penaltyTamil">Offence in Tamil</form:label>
                                    <form:input path="penaltyTamil" type="text" class="form-control" id="spotPenaltyTamil" />
                                    <form:errors path="penaltyTamil" style="color: red;"></form:errors>
                                </div>
                                </div>
                                </spring:bind>

							<spring:bind path="amount">
							<div class="form-group ${status.error ? 'has-error' : ''}">
                               <div class="form-group">
                                    <form:label path="amount">Fine Amount</form:label>
                                    <form:input path="amount" type="text" class="form-control" id="amount" />
                                    <form:errors path="amount" style="color: red;"></form:errors>
                                </div>
                                </div>
                                </spring:bind>
                                <form:input path="idPenalty" id="idSpotPenalty" type="text"  style="display: none"/>

                                <button type="submit" class="btn btn-primary">Submit</button>

                            </form:form>

                        </div>
                    </div>
                </div>

            </div>
            
              
            <div class="modal fade" id="deleteOffenceModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        
                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>

                        <form:form action="/department/penalty/delete" method="GET" modelAttribute = "penalty" >

                       
                            <label >Are You sure to delete this offence?</label>
                            <br/>
                             <form:input path="idPenalty" id="idPenaltyDelete" type="text"  style="display: none"/>
                             
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
              
             <div class="modal fade" id="courtOffenceModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                             <form:form action="/department/penalty/court/save" method="POST" modelAttribute = "penalty">
								
                                	
						<spring:bind path="penaltyEnglish">
							<div class="form-group ${status.error ? 'has-error' : ''}">
                                <div class="form-group">
                                    <form:label path="penaltyEnglish">Offence in English</form:label>
                                    <form:input path="penaltyEnglish" type="text" class="form-control" id="courtPenaltyEnglish"/>
                                    <form:errors path="penaltyEnglish" style="color: red;"></form:errors>
                                </div>
                              </div>
                             </spring:bind>   
                             
                             
                             <spring:bind path="penaltySinhala">
							<div class="form-group ${status.error ? 'has-error' : ''}">
                                <div class="form-group">
                                    <form:label path="penaltySinhala">Offence in Sinhala</form:label>
                                    <form:input path="penaltySinhala" type="text" class="form-control" id="courtPenaltySinhala"/>
                                    <form:errors path="penaltySinhala" style="color: red;"></form:errors>
                                </div>
                                </div>
                               </spring:bind>
                               
                               
                          <spring:bind path="penaltyTamil">
							<div class="form-group ${status.error ? 'has-error' : ''}"> 
                                <div class="form-group">
                                    <form:label path="penaltyTamil">Offence in Tamil</form:label>
                                    <form:input path="penaltyTamil" type="text" class="form-control" id="courtPenaltyTamil" />
                                    <form:errors path="penaltyTamil" style="color: red;"></form:errors>
                                </div>
								</div>
							</spring:bind>		
				
                                   <form:input path="idPenalty" id="idCourtPenalty" type="text"  style="display: none"/>

                                <button type="submit" class="btn btn-primary">Submit</button>

                            </form:form>

                        </div>
                    </div>
                </div>

            </div>
          
            
            <div class="modal fade" id="warnOffenceModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <form:form action="/department/penalty/warn/save" method="POST" modelAttribute = "penalty">
								
                                	
							<spring:bind path="penaltyEnglish">
							<div class="form-group ${status.error ? 'has-error' : ''}">
                                <div class="form-group">
                                    <form:label path="penaltyEnglish">Offence in English</form:label>
                                    <form:input path="penaltyEnglish" type="text" class="form-control" id="warnPenaltyEnglish"/>
                                    <form:errors path="penaltyEnglish" style="color: red;"></form:errors>
                                </div>
                                </div>
                               </spring:bind> 
                                
                                
                              <spring:bind path="penaltySinhala">
							<div class="form-group ${status.error ? 'has-error' : ''}">  
                                <div class="form-group">
                                    <form:label path="penaltySinhala">Offence in Sinhala</form:label>
                                    <form:input path="penaltySinhala" type="text" class="form-control" id="warnPenaltySinhala"/>
                                    <form:errors path="penaltySinhala" style="color: red;"></form:errors>
                                </div>
                                </div>
                              </spring:bind>  
                              
                              
                              <spring:bind path="penaltyTamil">
							<div class="form-group ${status.error ? 'has-error' : ''}">  
                                <div class="form-group">
                                    <form:label path="penaltyTamil">Offence in Tamil</form:label>
                                    <form:input path="penaltyTamil" type="text" class="form-control" id="warnPenaltyTamil" />
                                    <form:errors path="penaltyTamil" style="color: red;"></form:errors>
                                </div>
                                </div>
                               </spring:bind> 

                                   <form:input path="idPenalty" id="idWarnPenalty" type="text"  style="display: none"/>

                                <button type="submit" class="btn btn-primary">Submit</button>

                            </form:form>

                        </div>
                    </div>
                </div>

            </div>
            
            
            <div class="modal fade" id="settingsModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            
                            <form:form action="/department/penalty/settings/save"  method="POST" modelAttribute = "penaltySettings">
							 <div class="form-group">
                                    <form:label path="doubleDateCount">Double dates count</form:label>
                                    <form:input path="doubleDateCount" type="number" class="form-control" value="${savedPenaltySettings['doubleDateCount']}" />
                                </div>

                               
                             <div class="form-group">
                                    <form:label path="courtDateCount">Court dates count</form:label>
                                    <form:input path="courtDateCount" type="number" class="form-control" value="${savedPenaltySettings['courtDateCount']}" />
                                </div>
                                
                                 <form:input path="idPenaltyDateSettings" type="number" value="${savedPenaltySettings['idPenaltyDateSettings']}"  style="display: none" />
                                 
                                <button type="submit" class="btn btn-primary">Save</button>
                            </form:form>

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
		    $('#spotOffenceTable tbody').on('click', 'tr', function () {
		        var selectRow = table.rows(this).data()[0];
		        
		        clearFieldsSpot();
		        
				var u = window.location.href.match(/^.*\//)+'?id='+selectRow[0];
				
                $.get( u, function( data ) {
                	$("#spotPenaltyEnglish").val(data.penaltyEnglish);
                	$("#spotPenaltySinhala").val(data.penaltySinhala);
                	$("#spotPenaltyTamil").val(data.penaltyTamil);
              	}, "json" );
				
				
				
                
		        $("#idSpotPenalty").val(selectRow[0]);
                $("#idPenaltyDelete").val(selectRow[0]);
                $("#amount").val(selectRow[2]);
              	
		    });
		});
		
		
		  function clearFieldsSpot() {
              $("#spotPenaltyEnglish").val("");
              $("#spotPenaltySinhala").val("");
              $("#spotPenaltyTamil").val("");
              $("#idSpotPenalty").val("");
              $("#idPenaltyDelete").val("");
              $("#amount").val("");
          }
		  
		
		$(document).ready(function () {
		    var table = $('#courtOffenceTable').DataTable({
		        lengthChange: false,
		        "paging": false,
		        select: true
		    });
		    $('#courtOffenceTable tbody').on('click', 'tr', function () {
		        var selectRow = table.rows(this).data()[0];
		        
		        clearFieldsCourt();
		        
		        
		        
				var u = window.location.href.match(/^.*\//)+'?id='+selectRow[0];
                $.get( u, function( data ) {
                	$("#courtPenaltyEnglish").val(data.penaltyEnglish);
                	$("#courtPenaltySinhala").val(data.penaltySinhala);
                	$("#courtPenaltyTamil").val(data.penaltyTamil);
              	}, "json" );
				
				
				
                
                $("#idCourtPenalty").val(selectRow[0]);
                $("#idPenaltyDelete").val(selectRow[0]);
                
		    });
		});
		
		
		  function clearFieldsCourt() {
              $("#courtPenaltyEnglish").val("");
              $("#courtPenaltySinhala").val("");
              $("#courtPenaltyTamil").val("");
              $("#idCourtPenalty").val("");
              $("#idPenaltyDelete").val("");
          }
		
		
		$(document).ready(function () {
		    var table = $('#warnOffenceTable').DataTable({
		        lengthChange: false,
		        "paging": false,
		        select: true
		    });
		    $('#warnOffenceTable tbody').on('click', 'tr', function () {
		        var selectRow = table.rows(this).data()[0];
		        
		        
		        clearFieldsWarn();
		        
		        
		        
				var u = window.location.href.match(/^.*\//)+'?id='+selectRow[0];
                $.get( u, function( data ) {
                	$("#warnPenaltyEnglish").val(data.penaltyEnglish);
                	$("#warnPenaltySinhala").val(data.penaltySinhala);
                	$("#warnPenaltyTamil").val(data.penaltyTamil);
              	}, "json" );
				
				
				
                
                $("#idWarnPenalty").val(selectRow[0]);
                $("#idPenaltyDelete").val(selectRow[0]);
		    });
		});
		

		  function clearFieldsWarn() {
              $("#warnPenaltyEnglish").val("");
              $("#warnPenaltySinhala").val("");
              $("#warnPenaltyTamil").val("");
              $("#idWarnPenalty").val("");
              $("#idPenaltyDelete").val("");
          }
	
		
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
		
		$('#deleteOffenceModel').on('shown.bs.modal', function () {
		    $('#myInput').trigger('focus');
		});
		
		
</script>
</html>