<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
<!-- Latest compiled and minified jQuery  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
<!-- Latest compiled and minified JavaScript --> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<div class="container">
	<h3 class="text-center">Order confirmed, Thank you for shopping, Your order will be delivered shortly</h3>
	<hr>
	<p><strong>Order no</strong>: ${orderModel.order_id}</p>
	<p><strong>Shipping Address</strong>:<br>
	${orderModel.shippingaddressmodel.shippingaddress}<br>
	${orderModel.shippingaddressmodel.shippingaddress_city}<br>
	${orderModel.shippingaddressmodel.shippingaddress_state}<br>
	${orderModel.shippingaddressmodel.shippingaddress_pincode}</p>
	<p><strong>Billing Address</strong>:<br>
	${orderModel.billingaddressmodel.billingaddress}<br>
	${orderModel.billingaddressmodel.billingaddress_city}<br>
	${orderModel.billingaddressmodel.billingaddress_state}<br>
	${orderModel.billingaddressmodel.billingaddress_pincode}</p>
	<p><strong>Payment Method</strong>:<br>
	${orderModel.paymentmethodmodel.paymentmethod}</p>	
	<!-- <input class="btn btn-primary btn-block" name="_eventId_finalHome" type="submit" value="Back to Home" /> -->
	<a class="btn btn-primary pull-right" href="index">Continue Shopping</a>
</div>