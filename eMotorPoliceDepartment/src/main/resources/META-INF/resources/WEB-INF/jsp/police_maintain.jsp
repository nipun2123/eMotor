<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
	
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
<title>Police Maintain</title>
</head>
<body>
     
      <jsp:include page="/WEB-INF/jsp/navbar.jsp">
            <jsp:param name="police" value="w3-blue" />
        </jsp:include>
     <jsp:include page="/WEB-INF/jsp/toolbar.jsp"/>   


        <div  style="margin-left:300px;margin-top:43px;">
        
<div id="accordion">
                <div class="card">
                    <div class="card-header" id="headingOne">
                        <h5 class="mb-0">
                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Police Officers Registration
                            </button>
                        </h5>
                    </div>

                    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                        <div class="card-body">
                            <button type="button" id="addOfficerBtn" class="btn btn-primary" data-toggle="modal" data-target="#officerModel">
                                Register police officer
                            </button>
                            <button type="button" id="updateOfficerBtn" class="btn btn-primary" data-toggle="modal" data-target="#officerModel">
                                Update police officer
                            </button>

							
                            
                            <div class="table-responsive">
                                <table id="officerTable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                        <tr>
                                        	<th>Province</th>
                                        	<th>Station</th>
                                            <th>Officer NIC</th>
                                            <th>Officer no</th>
                                            <th>Name</th>
                                            <th>Mobile number</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                            <c:forEach items="${officers}" var="theOfficer">
                                     
	                                     	<tr>
	      									  <td> ${theOfficer.station.province.province} </td>
	      									  <td> ${theOfficer.station.policeStation} </td>
	      									  <td> ${theOfficer.nic} </td>
	      									  <td> ${theOfficer.officerNo} </td>
	      									  <td> ${theOfficer.fName} ${theOfficer.lName} </td>
	      									  <td> ${theOfficer.tel} </td>
	      									  
	      									  <c:choose>
  												<c:when test="${theOfficer.availability==true}">
  													<td > Active </td>
  												</c:when>
  												
  												<c:when test="${theOfficer.availability==false}">
  													<td > Deactive </td>
  												</c:when>
 
											</c:choose>
											
	      									  
	      									 </tr> 
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
                                Police station registration
                            </button>
                        </h5>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                        <div class="card-body">
                            <button type="button" class="btn btn-primary" id="addStationBtn" data-toggle="modal" data-target="#stationModel">
                                Register police station
                            </button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#stationModel">
                                Update police station
                            </button>

                            <div class="table-responsive">
                                <table id="policeTable" class="table table-striped table-bordered container table-hover " style="width:100%;">
                                    <thead class="thead-light">
                                        <tr>
                                        	<th>Province</th>
                                            <th>Police station</th>
                                            <th>Traffic OIC</th>
                                            <th>Traffic OIC Office</th>
                                            <th>Traffic OIC Mobile</th>
                                            <th>General number</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                     <c:forEach items="${staions}" var="theStations">
                                     
	                                     	<tr>
	      									  <td> ${theStations.province.province} </td>
	      									  <td> ${theStations.policeStation} </td>
	      									  <td> ${theStations.oic} </td>
	      									  <td> ${theStations.oicOffice} </td>
	      									  <td > ${theStations.oicMobile} </td>
	      									  <td > ${theStations.general} </td>
	      									 </tr> 
   									 </c:forEach>
                                           
		
                                    </tbody>   
                                </table>
                                                         
                            
                            </div>

                        </div>

                    </div>
                </div>

            </div>
            
        
            
            <div class="modal fade" id="officerModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <form:form action="/department/police/saveofficer" method="POST" modelAttribute = "policeOfficer" >
								
                               <div class="form-group">
                                    <form:label path="policeStationName">Police station</form:label>
                                    <form:select path="policeStationName" class="form-control browser-default custom-select"  id="policeStationName" >
                                     <c:forEach items="${staions}" var="station">
      									  <option value="${station.policeStation}">${station.policeStation}</option>
   									 </c:forEach>
                                    </form:select>
                                </div>

						<spring:bind path="nic">
							<div class="form-group ${status.error ? 'has-error' : ''}">
                                <div class="form-group">
                                    <form:label path="nic">Officer NIC</form:label>
                                    <form:input path="nic" type="text" class="form-control" id="nic"/>
                                    <form:errors path="nic" style="color: red;"></form:errors>
                                </div>
							</div>
						</spring:bind>
						
						
						<spring:bind path="officerNo">
							<div class="form-group ${status.error ? 'has-error' : ''}">	
                               <div class="form-group">
                                    <form:label path="officerNo">Officer no</form:label>
                                    <form:input path="officerNo" type="text" class="form-control" id="officerNo" />
                                    <form:errors path="officerNo" style="color: red;"></form:errors>
                                </div>
                             </div>
                        </spring:bind>
                        
                               
                        <spring:bind path="fName">
							<div class="form-group ${status.error ? 'has-error' : ''}">       
                                  <div class="form-group">
                                    <form:label path="fName">Officer first name</form:label>
                                    <form:input path="fName" type="text" class="form-control" id="fName"  />
                                    <form:errors path="fName" style="color: red;"></form:errors>
                                </div>
                         </div>
                        </spring:bind>       
                               
                         <spring:bind path="lName">
							<div class="form-group ${status.error ? 'has-error' : ''}">      
                              <div class="form-group">
                                    <form:label path="lName">Officer last name</form:label>
                                    <form:input path="lName" type="text" class="form-control" id="lName" />
                                    <form:errors path="lName" style="color: red;"></form:errors>
                                </div>
                           </div>
                          </spring:bind>
                          
                          <spring:bind path="tel">
							<div class="form-group ${status.error ? 'has-error' : ''}">      
                               <div class="form-group">
                                    <form:label path="tel">Mobile number</form:label>
                                    <form:input path="tel" type="text" class="form-control" id="tel"/>
                                    <form:errors path="tel" style="color: red;"></form:errors>
                                </div>
                           </div>
                         </spring:bind>  
                               
                      
                        <div class="form-group" id="availabilityGroup">
							<form:label path="availability" class="form-check-label"/>
								<form:radiobutton path="availabilityTxt" id="availabilityActive" value="Active" label= "Active" checked = "checked" />
							 <form:radiobutton path="availabilityTxt"    id="availabilityDeactive" value="Deactive" label="Deactive" />
								
							 </div>	
								
								
								 <form:input path="oldPoliceOfficerNic" id="oldPoliceOfficerNic" type="text"  style="display: none"/>
								  <form:input path="oldPoliceOfficerNo" id="oldPoliceOfficerNo" type="text"  style="display: none"/>
								  
								  <br/>
								
                                <button type="submit" class="btn btn-primary">Submit</button>

                            </form:form>

                        </div>
                    </div>
                </div>

            </div>
            
            
           
              
             <div class="modal fade" id="stationModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">

                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <form:form action="/department/police/savestation" method="POST" modelAttribute = "policeStationEntity" class="form-signin">
                            
                            
								<div class="form-group">
                                    <form:label path="provinceName">Province</form:label>
                                    <form:select path="provinceName" id= "provinceName" class="form-control browser-default custom-select">
                                    
                                    <c:forEach items="${provinces}" var="pro">
      									  <option value="${pro.province}">${pro.province}</option>
   									 </c:forEach>
                                            
                                    </form:select>
                                </div>

 						<spring:bind path="policeStation">
								<div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:label path="policeStation">Police station</form:label>
                                    <form:input path="policeStation" id="policeStation" type="text" autofocus="true" class="form-control" ></form:input>
                          		 	<form:errors path="policeStation" style="color: red;"></form:errors>
								</div>
						</spring:bind>
						
						<spring:bind path="oic">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:label path="oic">Traffic OIC</form:label>
                                    <form:input path="oic" id="oic" type="text" class="form-control"></form:input>
                                  	 <form:errors path="oic" style="color: red;"></form:errors>
                                </div>
						</spring:bind>
						
						<spring:bind path="oicOffice">
                               <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:label path="oicOffice">Traffic OIC office</form:label>
                                    <form:input path="oicOffice" id="oicOffice" type="number" class="form-control" ></form:input>
                                 	 <form:errors path="oicOffice" style="color: red;"></form:errors>
                                </div>
                         </spring:bind>
                         
                          
                         <spring:bind path="oicMobile">      
                        
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:label path="oicMobile">Traffic OIC mobile</form:label>
                                    <form:input path="oicMobile" id="oicMobile" type="number" class="form-control"></form:input>
                                 	 <form:errors path="oicMobile" style="color: red;"></form:errors>
                                </div>
                         </spring:bind>      
                             
                         <spring:bind path="general">    
                               <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:label path="general">General number</form:label>
                                    <form:input path="general" id="general" type="number" class="form-control" ></form:input>
                                     <form:errors path="general" style="color: red;"></form:errors>
                                </div>
                         </spring:bind>
                         
                               
								 <form:input path="oldPoliceStation" id="oldPoliceStation" type="text"  style="display: none"/>
								 <br/>
								 
                                <button type="submit" class="btn btn-primary">Submit</button>

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

 $('#addStationBtn').on('click', function () {
	 clearFieldsStation();
	
 });
     
 $('#addOfficerBtn').on('click', function () {
	 clearFieldsOfficer();
	 $("#availabilityGroup").css("display", "none");
 });
 
 $('#updateOfficerBtn').on('click', function () {
	 $("#availabilityGroup").css("display", "inline");
 });
 
                        $(document).ready(function () {
                            var table = $('#policeTable').DataTable({
                                lengthChange: false,
                                "paging": false,
                                select: true
                            });
                            $('#policeTable tbody').on('click', 'tr', function () {
                                var selectRow = table.rows(this).data()[0];
                                clearFieldsStation();
                                $("#provinceName").val(selectRow[0]);
                                $("#policeStation").val(selectRow[1]);
                                $("#oldPoliceStation").val(selectRow[1]);
                                $("#oic").val(selectRow[2]);
                                $("#oicOffice").val(selectRow[3]);
                                $("#oicMobile").val(selectRow[4]);
                                $("#general").val(selectRow[5]);
                                
                            });
                        });
                        
                      
                        
                        $(document).ready(function () {
                            var table = $('#officerTable').DataTable({
                                lengthChange: false,
                                "paging": false,
                                select: true
                            });
                            
                      $('#officerTable tbody').on('click', 'tr', function () {
                                var selectRow = table.rows(this).data()[0];
                                clearFieldsOfficer();
                                $("#policeStationName").val(selectRow[1]);
                                $("#nic").val(selectRow[2]);
                                $("#resendNic").val(selectRow[2]);
                                $("#officerNo").val(selectRow[3]);
                                
                                $("#oldPoliceOfficerNic").val(selectRow[2]);
                                $("#oldPoliceOfficerNo").val(selectRow[3]);
                                
                                var name = selectRow[4].split(" ");
                                $("#fName").val(name[0]);
                                $("#lName").val(name[1]);
                                $("#tel").val(selectRow[5]);
                                
                                var av = selectRow[6]
                                if(av === "Active"){
                                	 $("#availabilityActive").prop("checked", true);
                                }else{
                                	 $("#availabilityDeactive").prop("checked", true);
                                }
                               
             
                                
                            });
                        });
                        
                        function clearFieldsOfficer() {
                            $("#policeStationName").val($("#policeStationName option:first").val());
                            $("#nic").val("");
                            $("#resendNic").val("");
                            $("#officerNo").val("");
                            $("#fName").val("");
                            $("#lName").val("");
                            $("#tel").val("");
                            $("#oldPoliceOfficerNic").val("");
                            $("#oldPoliceOfficerNo").val("");
                            $("#availabilityActive").prop("checked", true);
                        }
                        
                        
                        function clearFieldsStation() {
                            $("#provinceName").val($("#provinceName option:first").val());
                            $("#policeStation").val("");
                            $("#oldPoliceStation").val("");
                            $("#oic").val("");
                            $("#oicOffice").val("");
                            $("#oicMobile").val("");
                            $("#general").val("");
                        }
                        

                        $('#officerModel').on('shown.bs.modal', function () {
                            $('#myInput').trigger('focus');
                        });
                        
                        $('#sendPasswordAgain').on('shown.bs.modal', function () {
                            $('#myInput').trigger('focus');
                        });

                        $('#stationModel').on('shown.bs.modal', function () {
                            $('#myInput').trigger('focus');
                        });
            </script>
            
</html>