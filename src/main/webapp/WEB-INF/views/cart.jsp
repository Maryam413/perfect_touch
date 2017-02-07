<jsp:include page="CommonHeader.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	var carts = ${cartlist};
</script>
<div class="container" style="padding-bottom: 10px" ng-app="app1" ng-controller="cartDisplayController">
	<c:choose>
	<c:when test="${UserCartEmpty==true}">
		<h4 class="text-center">Your cart is Empty!</h4>
		<a href="home" class="btn btn-primary pull-right">Continue Shopping</a>
	</c:when>
	<c:otherwise>
	<div class="table-responsive">
		<table class="table table-bordered" >
			<thead>
				<tr>
				<th>cart id</th>
					<th>product image</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Remove from Cart</th>
				</tr>			
			</thead>
			<tbody ng-repeat="c in cart">
				<tr>
					
					<td>{{c.cart_id}}</td>
					<td><img src="./resources/image/{{c.product_id}}.jpg"	height="50px" width="50px" class="thumb"></td>
					<td>{{c.product_name}}</td>
					<td><i class="fa fa-inr" style="color:black"></i> {{c.price}}</td>
					<td><input type="number" min="1" value="{{c.quantity}}" ng-model="c.quantity" />&nbsp;<a data-placement="top" data-toggle="tooltip" title="Update" class="btn btn-success btn-xs" href="updatequantity?quantity={{c.quantity}}&id={{c.cart_id}}"><span class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a data-placement="top" data-toggle="tooltip" title="Remove" class="btn btn-danger btn-xs" href="removeproduct?id={{c.cart_id}}"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<p><strong>Total</strong>: <i class="fa fa-inr" style="color:black"></i> ${total_price}</p>
	<center><dir-pagination-controls></dir-pagination-controls></center><br>
	<a href="index" class="btn btn-primary">Continue Shopping</a>
	<a class="btn btn-primary pull-right" href="checkout">Checkout</a>
	</c:otherwise>
	</c:choose>
</div>
