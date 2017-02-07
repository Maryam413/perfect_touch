<jsp:include page="CommonHeader.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.0-rc.2/angular.min.js"></script>




 <script>
	var pdlst = ${prdlist};
	
	

  </script>
	
	

<div class="container"  ng-controller="displaypdlstController" >
   
    <div id="products" class="row list-group" >
        <div class="item  col-xs-4 col-lg-4" ng-repeat="products in show" >
            <div class="thumbnail">
                <img class="group list-group-image" src="./resources/image/{{products.product_id}}.jpg"alt=""  class="responsive"/>
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">{{products.product_name}}</h4>
                    <p class="group inner list-group-item-text" >{{products.product_description}}</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead"> {{products.product_price}}</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" href="checkout">buy</a>
                            <a class="btn btn-success" href="addtocart?id={{products.product_id}}">add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
        </div>
      
      