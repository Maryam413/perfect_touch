<%@ include file="AdminHeader.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>

var sup = ${suplierdata};

angular.module('myApp', []).controller('myController',function($scope)
			{
				$scope.suppliers = sup;
				
				});
</script>
<body>
<div class="container" ng-app="myApp" ng-controller="myController">
<c:choose>
<c:when test="${updateClicked}">





<h2>Add suppliers </h2>


 <form:form method="POST" action="/perfecttouch/addsuplier" commandName="command" class="form-horizontal" enctype="multipart/form-data">
		
			<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="supplier_name">supplier name</label>
						<form:input path="supplier_name" placeholder="supplier name" class="form-control input-md" />

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="supplier_id">supplier ID</label>
						<form:input path="supplier_id" placeholder="supplier ID" class="form-control input-md" />
						
					</div>
				</div>


				<!-- Textarea -->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="supplier_address"> supplier address</label>
						<form:textarea class="form-control" path="supplier_address" />
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="supplier_contact">supplier contact</label>
						<form:input path="supplier_contact" placeholder="supplier contact" class="form-control input-md" />
						
					</div>
				</div>

             
				
				
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<input type="submit" value="addsupplier" />

					</div>
				</div>
				
		
		
				</form:form>



</c:when>
<c:otherwise>




<h2> update suppliers </h2>
 <form:form method="POST" action="/perfecttouch/updateSupplier" commandName="command" class="form-horizontal" enctype="multipart/form-data">
		
			<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="supplier_name">supplier name</label>
						<form:input path="supplier_name" placeholder="supplier name" class="form-control input-md" />

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="supplier_id">supplier ID</label>
						<form:input path="supplier_id" placeholder="supplier ID" class="form-control input-md" />
						
					</div>
				</div>


				<!-- Textarea -->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="supplier_address"> supplier address</label>
						<form:textarea class="form-control" path="supplier_address" />
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="supplier_contact">supplier contact</label>
						<form:input path="supplier_contact" placeholder="supplier contact" class="form-control input-md" />
						
					</div>
				</div>

             
				
				
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<input type="submit" value="update" />

					</div>
				</div>
				
		
		
				</form:form>
				


</c:otherwise>
</c:choose>


	<table class="table table-bordered table-responsive">
			<tr>
				<th>supplier_id</th>
				<th>supplier_name</th>
				<th>supplier_address</th>
				<th>supplier_contact</th>
				</tr>
				
			<tr ng-repeat="supplier in suppliers">
				<td>{{supplier.supplier_id}}</td>
				<td>{{supplier.supplier_name}}</td>
				<td>{{supplier.supplier_address}}</td>
				<td>{{supplier.supplier_contact}}</td>
				<td>
				<a class="btn btn-success btn-xs" href="fetchSuppliertoUpdate?supplier_id={{supplier.supplier_id}}"><span class="glyphicon glyphicon-pencil"></span></a> 
				<a class="btn btn-danger  btn-xs" href="deleteSupplier?supplier_id={{supplier.supplier_id}}"><span	class="glyphicon glyphicon-trash"></span></a>
				</td>
			</tr>
		</table>
		</div>
		</body>
	
<%@ include file="CommonFooter.jsp" %>