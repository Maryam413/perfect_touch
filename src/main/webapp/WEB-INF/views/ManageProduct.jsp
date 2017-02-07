<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="AdminHeader.jsp" %>
<script>
	var prod = ${userdata};
	var  cat = ${categorydata};
	var sup = ${suplierdata};

	angular.module('myApp', []).controller('myController',function($scope)
			{
				$scope.products = prod;
				$scope.categories = cat;
				$scope.suppliers = sup;
				
				});
</script>
	<div class="container" ng-app="myApp" ng-controller="myController">
	
	<c:choose>
<c:when test="${updateClicked}">

<h2> Add product </h2>
	
		<form:form method="POST" action="/perfecttouch/addingprod" commandName="command" class="form-horizontal" enctype="multipart/form-data">
				<!-- Select Basic -->

				<div class="form-group">
				<div class="col-md-4">
						<form:label class="col-md-4 control-label" path="category_Id">Category</form:label>
						<form:select path="category_Id" class="form-control">
							<option ng-repeat="C in categories" value="{{C.categoryId}}">{{C.categoryName}}</option>
						</form:select>
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
						<div class="col-md-4">
						<form:label class="col-md-4 control-label" path="supplier_id">supplier</form:label>
						<form:select path="supplier_id" class="form-control">
							<option ng-repeat="S in suppliers" value="{{S.supplier_id}}">{{S.supplier_name}}</option>
						</form:select>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<div class="col-md-4">
						<label class="col-md-4 control-label" for="product_name">product name</label>
						<form:input path="product_name" placeholder="product name"
							class="form-control input-md" />

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="product_id">product ID</label>
						<form:input path="product_id" placeholder="product ID" class="form-control input-md" />
						
					</div>
				</div>


				<!-- Textarea -->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="product_description">product description</label>
						<form:textarea class="form-control" path="product_description" />
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="product_price">price	Rs.</label>
						<form:input path="product_price"	class="form-control input-md" />

					</div>
				</div>
				<!-- File Button -->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="filebutton">uploadfile</label>
						<form:input path="image" class="input-file" type="file" />
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="product_quantity">Quantity</label>
						<form:input path="product_quantity" placeholder="product quantity"
							class="form-control input-md" />
					</div>
				</div>
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<input type="submit" value="add product" />

					</div>
				</div>
		</form:form>
			
</c:when>
<c:otherwise>
		
		<h2> update product </h2>
	
		<form:form method="POST" action="/perfecttouch/updateProduct" commandName="command" class="form-horizontal" enctype="multipart/form-data">
				<!-- Select Basic -->

				<div class="form-group">
				<div class="col-md-4">
						<form:label class="col-md-4 control-label" path="category_Id">Category</form:label>
						<form:select path="category_Id" class="form-control">
							<option ng-repeat="C in categories" value="{{C.categoryId}}">{{C.categoryName}}</option>
						</form:select>
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
						<div class="col-md-4">
						<form:label class="col-md-4 control-label" path="supplier_id">supplier</form:label>
						<form:select path="supplier_id" class="form-control">
							<option ng-repeat="S in suppliers" value="{{S.supplier_id}}">{{S.supplier_name}}</option>
						</form:select>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<div class="col-md-4">
						<label class="col-md-4 control-label" for="product_name">product name</label>
						<form:input path="product_name" placeholder="product name"
							class="form-control input-md" />

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="product_id">product ID</label>
						<form:input path="product_id" placeholder="product ID" class="form-control input-md" />
						
					</div>
				</div>


				<!-- Textarea -->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="product_description">product description</label>
						<form:textarea class="form-control" path="product_description" />
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="product_price">price	Rs.</label>
						<form:input path="product_price"	class="form-control input-md" />

					</div>
				</div>
				<!-- File Button -->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="filebutton">uploadfile</label>
						<form:input path="image" class="input-file" type="file" />
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="product_quantity">Quantity</label>
						<form:input path="product_quantity" placeholder="product quantity"
							class="form-control input-md" />
					</div>
				</div>
				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>

					<div class="col-md-4">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<input type="submit" value="update product" />

					</div>
				</div>
		</form:form>
				
</c:otherwise>
</c:choose>
		
	<table class="table table-bordered table-responsive">
			<tr>
				<th>product_id</th>
				<th>product_name</th>
				<th>category_Id</th>
				<th>supplier_id</th>
				<th>product_description</th>
				<th>image</th>
				<th>product_price</th>
				<th>product_quantity</th>
			</tr>
			<tr ng-repeat="product in products">
				<td>{{product.product_id}}</td>
				<td>{{product.product_name}}</td>
				<td>{{product.category_Id}}</td>
				<td>{{product.supplier_id}}</td>
				<td>{{product.product_description}}</td>
				<td><img src="./resources/image/{{product.product_id}}.jpg"	height="50px" width="50px" /></td>
				<td>{{product.product_price}}</td>
				<td>{{product.product_quantity}}</td>
				<td>
				<a class="btn btn-success btn-xs" href="fetchProducttoUpdate?product_id={{product.product_id}}"><span class="glyphicon glyphicon-pencil"></span></a> 
				<a class="btn btn-danger  btn-xs" href="deleteproduct?product_id={{product.product_id}}"><span	class="glyphicon glyphicon-trash"></span></a>
				</td>
			</tr>
		</table>
	</div>
<%@ include file="CommonFooter.jsp" %>
