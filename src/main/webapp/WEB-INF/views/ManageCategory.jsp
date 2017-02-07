<%@ include file="AdminHeader.jsp" %>

<script>
var catdisplay = ${categorydata}; 
var app1=angular.module('displaycatApp', []);

app1.controller('displaycatController',function($scope)
		{
	$scope.cat = catdisplay;

				});
</script>
</head>
<body>
<div class="container" ng-app="displaycatApp" ng-controller="displaycatController">
<c:choose>
<c:when test="${updateClicked}">

<h2> Add categories </h2>
		<form:form method="POST" action="/perfecttouch/addcategory" commandName="command" class="form-horizontal" enctype="multipart/form-data">
		
		
			   <!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="categoryName">category name</label>
						<form:input path="categoryName" placeholder="category name" class="form-control input-md" />

					</div>
				</div>
					
					
					<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="categoryId">category ID</label>
						<form:input path="categoryId" placeholder="category ID" class="form-control input-md" />
						
					</div>
					</div>
					
					<!-- Textarea -->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="categoryDescription">category description</label>
						<form:textarea class="form-control" path="categoryDescription" />
					</div>
				</div>
				
				
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<input type="submit" value="addcategory" />

					</div>
				</div>
			</form:form>
	
</c:when>
<c:otherwise>



<h2> update categories </h2>
		<form:form method="POST" action="/perfecttouch/updatecategory" commandName="command" class="form-horizontal" enctype="multipart/form-data">
		
		
			   <!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="categoryName">category name</label>
						<form:input path="categoryName" placeholder="category name" class="form-control input-md" />

					</div>
				</div>
					
					
					<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="categoryId">category ID</label>
						<form:input path="categoryId" placeholder="category ID" class="form-control input-md" />
						
					</div>
					</div>
					
					<!-- Textarea -->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="categoryDescription">category description</label>
						<form:textarea class="form-control" path="categoryDescription" />
					</div>
				</div>
				
				
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<input type="submit" value="updatecategory" />

					</div>
				</div>
			</form:form>
						
			
</c:otherwise>
</c:choose>

<div>
	<table class="table table-bordered table-responsive" >
			<tr>
				<th>categoryId</th>
				<th>categoryName</th>
				<th>categoryDescription</th>
				
				</tr>
			<tr ng-repeat="category in cat">
				<td>{{category.categoryId}}</td>
				<td>{{category.categoryName}}</td>
				<td>{{category.categoryDescription}}</td>
				<td>
				<a class="btn btn-success btn-xs" href="fetchCategorytoUpdate?categoryId={{category.categoryId}}"><span class="glyphicon glyphicon-pencil"></span></a> 
				<a class="btn btn-danger  btn-xs" href="deleteCategory?categoryId={{category.categoryId}}"><span	class="glyphicon glyphicon-trash"></span></a>
				</td>
			</tr>
		</table>
	</div>
<%@ include file="CommonFooter.jsp" %>