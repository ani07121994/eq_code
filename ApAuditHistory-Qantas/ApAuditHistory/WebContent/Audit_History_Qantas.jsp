<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.css">

<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/style_qantas.css">
<script src='js/jquery.min.js'></script>
<script src='js/jquery-resizable.js'></script>
 <script type="text/javascript" src="js/customFilter.js"></script>
 <script type="text/javascript" src="js/jquery.tableFilter.js"></script>
 <script type="text/javascript" src="js/jquery.tablefilter.min.js"></script>
 <script src="js/angular.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
<title>AP Audit History</title>

<style type="text/css">


.splitter {
  flex: 0 0 auto;
  width: 0px;
  cursor: col-resize;  
}

.splitter-horizontal {
  flex: 0 0 auto;
  height: 2px;
  cursor: row-resize;
}
.col-lg-8{

	padding-right : 0px;
	padding-left : 0px;
}

.columnWidth{
	width: 10%;
}

#summary-table>tbody>tr>td {
    
    font-size: 9px;
    font-weight: bold;
    
}

.hoverComments{
	position : relative;
}


.hoverComments .tooltiptext {
    visibility: hidden;
    width: auto;
    border : 1px solid black;
    background-color: #f2f2f2;
    color: black;
    text-align: center;
    border-radius: 10px;
    padding: 5px 0;
	top: auto;
    left: 18%;
    white-space: pre-line;
    /* Position the tooltip */
    position: absolute;
    z-index: 1;
}

.hoverComments:hover .tooltiptext {
    visibility: visible;
}
label{

	font-size: small;

}

.form-control-static {
    
    font-size: small;
    }
.customFormControl{
	
    display: initial;
    width: 60%;
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
}

.panel-success{
    color: #333;
    background-color: #e6ffe6;
    border-color: #00cc00;
    display : inline-block;
    }
    
    .customDiv{
    	
        /*display : inline-block;*/
        text-align: center;
    }

.table>thead>tr>th{
	white-space:nowrap !important;
}
td{
	white-space:nowrap !important;
}

.odd {
  background-color: #d9d9d9;
}
.even {
  background-color: #ffffff;
}
tr:hover>td {
	
  background-color: #323232 !important;
  color:#FFFFFF !important;
  cursor: pointer;

}
.panel{
	margin-bottom : 0px !important;
}

.panel-primary{
	
    display: table;
    min-width:100%;
}
.modal, .modal-backdrop {
    position: absolute !important;
}

.blue
{
  background-color:blue;
  position:relative; 
}
.customScroll {
  
  overflow-y: auto;
}

.btn-custom {
    color: #fff;
    background-color: #323232;
    border-color: #323232;
    margin-bottom : 8px;
    
}

.btn-custom:hover {
    color: #fff;
    background-color: #323232;
    border-color: #323232;
}
body {
    font-family: "Ciutadella",Helvetica,Arial,sans-serif;
   }

.table-bordered>tbody>tr>td {
    font-size: x-small;
    font-weight: 600;
    border: 1px solid #bfbfbf;
}

.table>tbody>tr>td{
    padding: 5px;
}
    
    .table > thead > tr > th{
    
    	padding: 4px;
    	line-height: 1.328571;
    }

.btn-custom:active {
    color: #fff;
    background-color: #323232 !important;
    border-color: #323232 !important;
    box-shadow: 0 5px #666 !important;
  transform: translateY(4px) !important;
}

#modalNew {
    display: none;
    position: absolute;
    top: 45%;
    left: 45%;
    width: 104px;
    height: 90px;
    padding:8px 8px 0px;
    border: 3px solid #ababab;
    box-shadow:1px 1px 10px #ababab;
    border-radius:20px;
    background-color: white;
    z-index: 5002;
    text-align:center;
    overflow: auto;
}

#fade {
    display: none;
    position:absolute;
    top: 0%;
    left: 0%;
    width: 100%;
    min-height: 115%;
    background-color: #ababab;
    z-index: 5001;
    -moz-opacity: 0.8;
    opacity: .70;
    filter: alpha(opacity=80);
}

.page-header{

    padding-bottom: 9px;
   
    margin-top: 10px;
    margin-right: 0px;
    margin-bottom: 10px;
    margin-left: 0px;
    border-bottom: 1px solid #eee;

}

.custom-body{
	background-color:#b3d9ff;
	min-height:190px;
	padding-bottom:0px !important;
	padding: 15px;
	display : none;
}

.tooltip {
    position: relative;
    display: inline-block;
    font-size: 10px;
    opacity:1 !important;
}

.tooltip .tooltiptext {
    visibility: hidden;
    width: 120px;
    background-color: #f2f2f2;
    color: black;
    text-align: center;
    border-radius: 6px;
    padding: 5px 0;
	border:1px solid black;
    /* Position the tooltip */
    position: absolute;
    z-index: 1;
}

.tooltip:hover .tooltiptext {
    visibility: visible;
   
}

.panel-primary > .panel-heading-custom {
    color: #fff;
    background-color: #337ab7;
    border-color: #337ab7;
    width: 600px;
}


.panel-heading-custom {
    padding: 10px 15px;
    border-bottom: 1px solid transparent;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
}

.panel-heading {
    padding: 5px 15px;
    
    }
    
 .table>thead>tr{   
    background: -webkit-linear-gradient(top, rgba(234, 240, 245, 0), rgba(159, 225, 232, 0.06), rgba(113, 175, 226, 0.75));
    background: linear-gradient(rgb(234, 240, 245, 0), rgb(159, 225, 232, 0.06), rgb(113, 175, 226, 0.75));
    }
    
 #div1{
 
 	width : 30%;
 	z-index: 100;
 }
 
 #wrapperDiv{
 
 	width : 70%;
 } 
 

</style>

</head>


<body ng-app="myApp" ng-init="init()" style="padding-top:60px" ng-controller="myCtrl" ng-cloak>

<!-- Header of the Page -->


<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      
      <a href="https://www.qantas.com" target="new" ><img src="images/qantas.png" style="width: 135px;height: 43px;margin-top:7px;border-radius: 10px;"/></a> 
      
    </div>
     <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li style="background-color:#f2f2f2;display: inline-flex;margin-right:10px;font-weight:bold;margin-top: 8px;border-radius: 10px;"><a href="#" class="header-alphabets hover-header" ng-click="openSearchInvoiceModal()" style="font-size: smaller;color: black;"> <span class="glyphicon glyphicon-search" style="top: 5px;padding-left: 5px;float: right;color: red;"></span>Search Invoice</a></li>
        
      </ul>
    </div> 
    
    <ul class="nav navbar-nav navbar-center" style="margin-top:-42px;">
            <li>Invoice Audit History</li>
            
        </ul>
     </div>
</nav>

<div class="container-fluid" style="padding-right: 8px;padding-left: 8px;display : flex;overflow: hidden;flex-direction: row;">

<!-- Left Section showing Invoice WorkFlow : START -->

<div id="div1" class="col-lg-4 panel panel-default customScroll" style="flex: 0 0 auto;max-width:850px;min-width: 150px;padding-right:0px !important;padding-left:0px !important;height:600px;">
    
    <div class="panel panel-primary">
      <div class="panel-heading">
		<h3 class="panel-title">Invoice Workflow</h3>
		
	  </div>
  <div class="panel-body" style="padding-bottom:25px;min-height: 570px;background-color : #EBF0F6;">

	  <div class="customDiv" ng-show="showAuditTrail">
  		<div ng-repeat = "item in auditResults">
  				
		  		<i class="fa fa-arrow-circle-down" ng-show="{{$index}} != 0" style="font-size:24px;padding: 5px;"></i>
		  		<br>
  		
  		<div class="panel panel-success">
			    <div class="panel-body" style="padding : 5px;cursor : pointer;">
			    <span>
			    <img style="padding-right : 8px;" src="images/new.png">
			    
			    </span>
			     <font size="2" class="tooltip"><b>{{item.internalStatus}}</b>
					
							<span class="tooltiptext">
							{{item.lastUpdatedDate}}
							<br>
							{{item.certifierName}}
							</span>
				</font>
			    </div>
    			</div>
		</div>
  		
   </div>
	</div>
    </div>
    </div>
    
    <!-- Left Section showing Invoice WorkFlow : ENDS -->
    
    <!-- Vertical Splitter -->
    
     <div class="splitter" style="height:600px;width:2px">
		
    </div> 
		
    
    
    <div class="col-lg-8" id="wrapperDiv" style="height:600px;flex: 0 0 auto;display: flex;overflow:hidden;flex-direction: column;">
    
    <!--  Panel Showing Invoice Summary with 4 columns : START -->
    
    <div class="panel panel-default customScroll" id="div2" style="flex: 0 0 auto;min-height:50px;max-height:500px;min-width: 250px;padding-right:0px !important;padding-left:0px !important;height:299px;">
    <div class="demoDiv">
        	<div class="panel panel-primary" style="background-color: #EBF0F6;">
					<div class="panel-heading">
						<h3 class="panel-title">Invoice Summary</h3>
						<div class="pull-right">
							<span class="clickable filter" style="cursor: pointer;"  data-container="body">
								<i class="glyphicon glyphicon-filter" title="Filter Audit Data" style = "top:-12px;"></i>
							</span>
						</div>
					</div>
					<h5 ng-show="defaultSummaryMessage">No Results to Display</h5>
					<div class="panel-body" style="display:none;"> 
						<input type="text" ng-disabled="isClearDisabled" ng-model="filterResult" class="form-control" id="dev-table-filter" data-action="filter" data-filters="#dev-table" placeholder="Filter Invoice Summary" />
					</div>
					<table class="table table-bordered" id="dev-table" ng-show="IsVisible" style="border-top: 1px solid black;">
						<thead>
							<tr style="font-size: 11px;">
								
				                <th>Internal Status</th>
				                <th>Employee Name</th>
				                <th>Updated Date</th>
				                <!-- <th>Reason Type</th> -->
				                <!-- <th>AP Operation Comments</th>
				                <th>Certifier Reassign Comments</th>
				                <th>Certifier Rejection Comments</th> -->
				                
				                <th>Comments</th>
				               
							</tr>
						</thead>
						<tbody ng-repeat="item in auditResults">
			                <tr ng-click="showDetailedAudit(item)" ng-class-odd="'odd'" ng-class-even="'even'">
								
								<!-- <td>{{item.internalStatus}}</td> -->
								<td>{{item.statusCamelCase}}</td>
								<td>{{item.certifierName}}</td>
								<td>{{item.lastUpdatedDate}}</td>
								
								<input type="hidden" ng-model="initComments" ng-bind="item.comments">
								
			                    <td class="hoverComments">{{item.comments | limitTo : 80}}<span ng-show="{{item.comments.length > 80}}">..</span>
			                    
			                    <!-- Tooltip to show commnets on hover when no of characters > 80 -->
			                   		<span class="tooltiptext" ng-show="{{item.comments.length > 80}}">
										{{item.comments}}
										</span>
			                    
			                    </td>    
			                </tr>
            		   </tbody>
					</table>
					
				</div>
        
        </div>
    </div>
    
    <!--  Panel Showing Invoice Summary with 4 columns : ENDS -->
    
    
    <!-- Horizontal Splitter --> 

	
	<div class="splitter-horizontal">
		
		
        </div>
    
    <!--  Panel Showing Invoice Details : START -->
    
    <div class="panel panel-default customScroll" id="div3" style="flex: 1 1 auto;min-width: 250px;padding-right:0px !important;padding-left:0px !important;height:299px;">
    
    <div class="panel panel-primary" style="background-color: #EBF0F6;">
    	<div class="panel-heading">
						<h3 class="panel-title">Invoice Details</h3>
		</div>
		<h5 ng-show="defaultAuditMessage">No Results to Display</h5>
		
		
		<table class="table" id="summary-table" ng-show="IsVisible">
						
						<tbody>
			                <tr>
								
								<td class="columnWidth">Invoice No</td>
			                    <td>{{detailResult.invoiceNo}}</td>
			                </tr>
			                <tr>
								
								<td>Invoice Date</td>
			                    <td>{{detailResult.invoiceDate}}</td>
			                </tr>
			                <tr>
								
								<td>Reason Type</td>
			                    <td>{{detailResult.reasonType}}</td>
			                </tr>
			                <tr>
								
								<td>Invoice Type</td>
			                    <td>{{detailResult.invoiceType}}</td>
			                </tr>
			                <tr>
								
								<td>Document Type</td>
			                    <td>{{detailResult.documentType}}</td>
			                </tr>
			                <tr>
								
								<td>Supplier ID</td>
			                    <td>{{detailResult.supplierId}}</td>
			                </tr>
			                <tr>
								
								<td>Supplier Name</td>
			                    <td>{{detailResult.supplierName}}</td>
			                </tr>
			                <tr>
								
								<td>Supplier Number</td>
			                    <td>{{detailResult.supplierNumber}}</td>
			                </tr>
			                <tr>
								
								<td>Site ID</td>
			                    <td>{{detailResult.siteId}}</td>
			                </tr>
			                <tr>
								
								<td>Site Name</td>
			                    <td>{{detailResult.siteName}}</td>
			                </tr>
			                <tr>
								
								<td>PO Number</td>
			                    <td>{{detailResult.PONumber}}</td>
			                </tr>
			                <tr>
								
								<td>Currency Code</td>
			                    <td>{{detailResult.currencyCode}}</td>
			                </tr>
			                <tr>
								
								<td>Tax Registration No</td>
			                    <td>{{detailResult.taxRegNumber}}</td>
			                </tr>
			                <tr>
								
								<td>Tax Amount</td>
			                    <td>{{detailResult.taxAmount}}</td>
			                </tr>
			                <tr>
								
								<td>Invoice Total Amount</td>
			                    <td>{{detailResult.invoiceTotalAmount}}</td>
			                </tr>
			                
            		   </tbody>
					</table>
		</div>
    	<button type="button" class="btn btn-primary btn-md" id="searchInvoiceBtn" style="float : left;margin-top:10px;margin-left:10px;" ng-disabled="isClearDisabled" ng-click="resetData()">Clear</button>
    </div>
    
    <!--  Panel Showing Invoice Summary with 4 columns : ENDS -->
    
    </div>

  </div>
  
  
  <!-- Modal for Invoice Search -->
  
  <div class="modal fade" id="invoiceSearchForm" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content" style="margin-top: 70px;">
       <!-- Modal Header-->
        
        <div class="modal-header" style="padding:2px 12px;height: 38px;">
          <!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
          <h4 style="text-align:center;">Invoice Search Form</h4>
        </div>
  
  <div class="modal-body" style="padding:20px 50px;">
  
  <form>
      		
      		
              <label for="usrname">Invoice NO</label>
              <br>
              <input type="text" class="form-control" ng-change="resetInvoiceID()" id="invNo" ng-focus="removeAlert()" ng-model = "invNumber" placeholder="Enter invoice number">
              <div class="form-group"><p id="errorMsg" class="alert alert-danger" style="padding:10px;margin-top:10px;color:#dc1511;" ng-show="showError" ng-model = "errorMsg"><b>{{errorMsg}}</b></p> 
              <button  id="searchInvoiceBtn" class="btn btn-custom btn-block"  style="color:#ffffff !important;margin-top:10px;" ng-click="searchInvoice()">Search Invoice History</button> 
    		  <div class="form-group" style="display : none;">
              <label for="psw">Invoice ID</label>
              <input type="text" class="form-control" id="invId" ng-model="invId" disabled>
            </div>
            
            </div> 
            
</form>       

</div>

<div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default" data-dismiss="modal" ng-click="returnOpacity()">Close</button>
        </div>
</div>
</div>
</div>     

  
  <!-- Modal showing invoice list in case of multiple invoices for same Invoice NO -->

<div class="modal fade" id="myModalInvoiceList" role="dialog">
    <div class="modal-dialog" style="max-width: 100%;width: auto !important;margin: 30px auto;display: table;">
    
      <!-- Modal content-->
      <div class="modal-content" style="margin-top:70px;">
        
       <!-- Modal Header-->
        
        <div class="modal-header" style="padding:1px 10px;">
          <!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
          <h4 style="text-align:center;font-weight:600;">Search Results</h4>
        </div>
        
        <!-- Modal Body-->
        
        <div class="modal-body" style="padding:30px 50px;">
          <table class="table table-striped table-bordered table-hover" style="margin-bottom: 0px;">
          
          <thead>
          	<!-- <h5 class="text-center">Click on Invoice No to view audit</h5> -->
          	<tr style="font-size:11px;">
          <th class="column-header" style="padding: 8px;">Invoice Number</th>
          <th class="column-header" style="padding: 8px;">Supplier Name</th>
          <th class="column-header" style="padding: 8px;">Site ID</th>
          <th class="column-header" style="padding: 8px;">Internal Status</th>
          <th class="column-header" style="padding: 8px;">Invoice Date</th>
          <th class="column-header" style="padding: 8px;">Invoice Amount</th>
          </tr>
          </thead>
          
          
          
          <tr ng-repeat = "item in invoice" ng-click="selectInvoiceNo(item)">
          <td style="font-size: smaller;">{{item.invoiceNo}}</td>
		  <td style="font-size: smaller;">{{item.supplierName}}</td>
		  <td style="font-size: smaller;">{{item.siteId}}</td>
		  <td style="font-size: smaller;">{{item.internalStatus}}</td>
		  <td style="font-size: smaller;">{{item.invoiceDate}}</td>
		  <td style="font-size: smaller;">{{item.invoiceTotalAmount}}</td>
          </tr>
          </table>
        </div>
        
        <!-- Modal footer-->
        
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default" data-dismiss="modal" ng-click="returnOpacity()">Close</button> 
        </div>
        
      </div>
      </div>
      </div>
      
  
  <div id="fade"></div>
  <div id="modalNew">
            <img id="loader" src="images/ajaxloader.gif" />
        </div>
  
  <script>

  /* Scripts to initialize splitters when page loads */
  
  $("#div1").resizable({
      handleSelector: ".splitter",
      resizeHeight: false
  });
  $("#div2").resizable({
      handleSelector: ".splitter-horizontal",
      resizeWidth: false
  });
 
  /* Function to open and close gif animation */
  
  function openModal() {
		
		document.getElementById('modalNew').style.display = 'block';
	    document.getElementById('fade').style.display = 'block';
	}

	function closeModal() {
	document.getElementById('modalNew').style.display = 'none';
	document.getElementById('fade').style.display = 'none';
	}
    
	/* Function to get invoice ID from URL */

	function GetURLParameter(sParam)
	{	
		var pageUrl = window.location.search.substring(1);
		var URLvariables = pageUrl.split('&');
		for (var i = 0; i < URLvariables.length; i++)
	    {
	        var sParameterName = URLvariables[i].split('=');
	        if (sParameterName[0] == sParam)
	        {
	            return sParameterName[1];
	        }
	    }
	}
	var app = angular.module('myApp', []);
	app.controller('myCtrl', function($scope,$http) {
		$scope.errorMsg = "";
		$scope.showError = false;
		$scope.IsVisible = false;
		$scope.IsAuditVisible = false;
		$scope.defaultSummaryMessage = true;
		$scope.defaultAuditMessage = true;
		$scope.isClearDisabled = true;
		$scope.showAuditTrail = false;
		$scope.showInvoiceSearchIcon = false;
		
		/* AJAX call to get Invoice Data for iven invoice ID : FetchInvoiceAuditData -> servlet which contains query to fetch data */
		
		$scope.init = function(){
			openModal();
			$http({
                method : 'POST', 
                url : 'FetchInvoiceAuditData',
                data : {"invoiceID" : GetURLParameter('invoiceID')},
        }).then(function successCallback(response) {
        	$scope.auditResults = response.data;
        	closeModal();
        	alert(response.data);
        	if(response.data.length > 0)
        	{
        		
        		$scope.IsVisible = true;
        		$scope.showInvoiceSearchIcon = true;
        		$scope.isClearDisabled = false;
        		$scope.defaultSummaryMessage = false;
				$scope.showAuditTrail = true;
				$scope.defaultAuditMessage = false;
				$scope.detailResult = response.data[0];
				
        	}
        	else if(response.data.length == 0){
        		
				jQuery('#invoiceSearchForm').modal();
      			$scope.showError = true;
      			$scope.errorMsg = 'Search for Invoice failed.Please try again';
        		
        	}
		
          }, function errorCallback(response) {
        	//alert(response.data);
        	closeModal();
  			/* $scope.invNumber = data.invoiceNo;
  			$scope.invId = data.invoiceId; */
  			jQuery('#invoiceSearchForm').modal();
  			$scope.showError = true;
  			$scope.errorMsg = 'Search for Invoice failed.Please try again'; //Error Handling in case of failed AJAX call
          }); 
			
		}

	$scope.returnOpacity = function(){
    	$("#myModal").css("opacity", "1");
    }
	$scope.removeAlert = function(){
		$scope.showError = false;
	}
	
	/* Clears Page data when Clear Button is clicked */
	
	$scope.resetData = function(){
		
		$scope.supplierName = "";
		$scope.siteId = "";
		$scope.invId = "";
		$scope.invTotalAmount = "";
		$scope.invDate = "";
		$scope.IsVisible = false;
		$scope.IsAuditVisible = false;
		$scope.defaultSummaryMessage = true;
		$scope.defaultAuditMessage = true;
		$scope.isClearDisabled = true;
		$scope.showAuditTrail = false;
		$scope.showInvoiceSearchIcon = false;
		$scope.filterResult = "";
		
	}
	
	$scope.resetInvoiceID= function(){
		
		$scope.invId = "";
			
	}
	
	$scope.openSearchInvoiceModal = function(){
		
		$scope.invNumber = "";
		$scope.invId = "";
		$scope.showError = false;
  		$scope.errorMsg = "";
		$("#myModal").css("opacity", "0.4");
		jQuery('#invoiceSearchForm').modal('toggle');
		
	}
	
	
	 $scope.showDetailedAudit = function(data){
		 
		 
		 $scope.detailResult = data;
		 $scope.defaultAuditMessage = false;
		 $scope.IsAuditVisible = true;
	 }
	
	 /* Select Invoice No from Invoice List when multiple Invoices are found : Accordingly Audit details are fetched frmo the Servlet */
	 
	 $scope.selectInvoiceNo = function(data){
			
			//jQuery('#invoiceSearchForm').modal('toggle');
			$("#myModal").css("opacity", "1");
			$scope.invNumber = data.invoiceNo;
			$scope.invId = data.invoiceId;
			
			jQuery('#myModalInvoiceList').modal('toggle');
			openModal();
			$http({
    	        method : 'POST', 
    	        url : 'FetchInvoiceAuditData',
    	        data : {"invoiceID" : $scope.invId},
    		    
    		}).then(function successCallback(response) {
    			$scope.auditResults =  response.data;
    			closeModal();
            	 if(response.data.length > 0)
            	{
            		
            		$scope.IsVisible = true;
					$scope.showInvoiceSearchIcon = true;
            		$scope.isClearDisabled = false;
            		$scope.defaultSummaryMessage = false;
    				$scope.showAuditTrail = true;
					$scope.detailResult = response.data[0];
    				$scope.defaultAuditMessage = false;
    				$scope.IsAuditVisible = true;
            	} 
    		}, function errorCallback(response) {
    			
    			closeModal();
    			$scope.invNumber = data.invoiceNo;
    			$scope.invId = data.invoiceId;
    			jQuery('#invoiceSearchForm').modal();
    			$scope.showError = true;
    			$scope.errorMsg = 'Search for Invoice failed.Please try again';
    	  	  
    	    });
			
		} 
	
	$scope.searchInvoice = function() {
		if(!($scope.invNumber.length === 0 || typeof $scope.invNumber === 'undefined')){
    	openModal();
    	
    	/* Fetches data from the data based based on Invoice No entered in the Invoice Search Form : FetchInvoiceData -> Fetches data from database based on Invoice NO */
    	
        $http({
                method : 'POST', 
                url : 'FetchInvoiceData',
                data : {"invoiceNum" : $scope.invNumber},
        }).then(function successCallback(response) {
        	//alert(response.data);
        	if(response.data != null){
        	$scope.invoice = response.data;
        	if(response.data.length == 1){
				var invoiceId = response.data[0].invoiceId;
        		$http({
        	        method : 'POST', 
        	        url : 'FetchInvoiceAuditData',
        	        data : {"invoiceID" : response.data[0].invoiceId},
        		
        		}).then(function successCallback(response) {
        			$scope.auditResults =  response.data;
					closeModal();
					if(response.data.length > 0)
                	{
                		
                		$scope.IsVisible = true;
                		$scope.isClearDisabled = false;
                		$scope.showInvoiceSearchIcon = true;
                		$scope.defaultSummaryMessage = false;
                		jQuery('#invoiceSearchForm').modal('toggle');
        				$scope.showAuditTrail = true;
        				$scope.detailResult = response.data[0];
        				$scope.defaultAuditMessage = false;
        				$scope.IsAuditVisible = true;
                	} 
        		}, function errorCallback(response) {
        			closeModal();
        			$scope.invId = invoiceId;
					$scope.showError = true;
        			$scope.errorMsg = 'Search for Invoice failed.Please try again';
				});
        	}
        	else if(response.data.length > 1)
        	{
        		closeModal();
        		jQuery('#invoiceSearchForm').modal('toggle');
				jQuery('#myModalInvoiceList').modal();
				$("#myModal").css("opacity", "0.4");
			}
        	else if(response.data.length == 0){
        	 closeModal();
        	 $scope.showError = true;
       		 $scope.errorMsg = 'Invoice does not exist';
        		
        	}
        }
        	else{
        		
        		closeModal();
          	    $scope.invId = invoiceId;
    			$scope.showError = true;
    			$scope.errorMsg = 'Search for Invoice failed.Please try again';
        		
        	}
          }, function errorCallback(response) {
        	  closeModal();
        	  $scope.invId = invoiceId;
  			  $scope.showError = true;
  			  $scope.errorMsg = 'Search for Invoice failed.Please try again';
        	
          });
}else{
		 $scope.showError = true;
		 $scope.errorMsg = 'Please enter invoice number';
		 
	  }
    };
    
	})
  </script>

</body>
</html>