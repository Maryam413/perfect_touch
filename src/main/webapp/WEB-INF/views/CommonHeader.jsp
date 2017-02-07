<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>


  <title>perfect_touch</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0-rc.2/angular.min.js"></script>
  
   <style>
.navbar-brand {
  padding: 0px;
}
.navbar-brand>img {
  height: 100%;
  padding: 5px;
  width: auto;
}


body { 


 font-style: italic;
    width: 100%;
	height:100%;
	font-family: 'Open Sans', sans-serif;
	background: #092756;
	background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%),-moz-linear-gradient(top,  rgba(57,173,219,.25) 0%, rgba(42,60,87,.4) 100%), -moz-linear-gradient(-45deg,  #670d10 0%, #092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -webkit-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -webkit-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -o-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -o-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -ms-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -ms-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), linear-gradient(to bottom,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), linear-gradient(135deg,  #670d10 0%,#092756 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
}
</style>
  
  
  
  <script>
	var catdisplay = ${list};
	var proddisplay = ${productdata};
	var app1=angular.module('displaycatApp', []);
	
	app1.controller('displaycatController',function($scope)
			{
				$scope.cat = catdisplay;
				$scope.allproducts = proddisplay;
				
				});
	
	app1.controller('displaypdlstController',function($scope)
			{
				$scope.show = pdlst;
				
			});
	
	app1.controller("cartDisplayController",function($scope) {
		$scope.cart = carts;
		
	});

		
	

      </script>
  
</head>
<body ng-app="displaycatApp">
<h1 class="text-center">welcome to<img src="resources/image/Logomaker.png" ></h1>
	
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand"><img src="resources/image/Logomaker.png"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar"  >
      <ul class="nav navbar-nav">
        <li class="active"><a href="index">Home</a></li>
        <li class="drpdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">categories<span class="caret"></span></a>
        <ul class="dropdown-menu" ng-controller="displaycatController">
         <li><a href="fetchProducts?categoryid={{cate.categoryId}}" ng-repeat="cate in cat">{{cate.categoryName}}</a></li>
          
        </ul>
      </li>
       
      </ul>
      <ul class="nav navbar-nav navbar-right">
         <c:choose>
							<c:when test="${userloggedin==true}">
								<li><a href="perform_logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
							</c:when>
							<c:otherwise>						
								<li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
								 <li><a href="Register"><span class="glyphicon glyphicon-user"></span> Register Here</a></li>
       </c:otherwise>
						</c:choose>	
							 <li><a href="adminpanel"><span class="glyphicon glyphicon-user"></span> Admin panel</a></li>
       
      </ul>
  </div>
    </div>
 <li><a href="cart"><span class="glyphicon glyphicon-shopping-cart "></span> My Cart (${total_quantity})</a></li>
					
</nav>

