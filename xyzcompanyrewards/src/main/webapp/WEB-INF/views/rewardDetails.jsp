<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>XYZ Company Rewards </title>
	<link type="text/css" rel="stylesheet"
		href='<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>'>
		 <link rel="stylesheet" href="<c:url value="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>"/>
</head>
<body>
     <div class="container">
  <div style="padding-top:50px">
    <p>This is the Reward Details Section, where you can view Customer Reward Details. 
    </br>Select a customer from the drop down and click on Get Reward Details to see the details per month.</p>
	<div class="col-md-8">
                   <div class="form-group">
                    <label>Select Customer</label>
                    <select id="customerName">
                    	<option value=""></option>
                      <c:forEach items="${customerNames}" var="name">
		       <option value="${name}">${name}</option>
		    </c:forEach>
	    </select>
		<input type='button' value='Get Reward Details'
			  onclick='displayCustomerDetails()'/>
		</div>
	</div>
		  <table id="customerInfoTable" class="table table-striped">
		    <thead>
		      <tr>
		        <th>Customer Name</th>
		        <th>Number of Transactions</th>
		        <th>Reward points earned</th>
		        <th>Rewards for the Month and Year</th>
		        <th>Statement Amount</th>
		        <th>View Rewards </th>
		      </tr>
		    </thead>
		    <tbody>
		    </tbody>
		</table>
		<span id='totalRewards' style='padding-left: 10px'></span>
  </div>
<div id="statementSummary" style="display: none;"
		title="Statement Summary" >
</div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script>
  $( function() {

   $("#statementSummary").dialog({
		autoOpen : false,
		modal : true,
		height : 600,
		width : 800,
		position : {
			my : 'center',
			at : 'center',
			of : document
		}
	}); 
    
    
  } );
  
  
  function displayCustomerDetails() {
	  var selectedCust = $("#customerName").val();
	  $.ajax({
          type: "GET",
          url: "/customerRewardDetails/"+selectedCust,
          dataType: "html",
          success: function(response) {
        	  $("#customerInfoTable tbody, #totalRewards").html("");
        	  buildCustomerTable(response, selectedCust);
          },error: function (jqXHR, textStatus, errorThrown) {
	        alert('Error: ' + "An error has occured, please retry or contact support");
			}
     });  
 }

  function  buildCustomerTable(customerObj, selectedCust) {
	  var custObj = $.parseJSON(customerObj);
	  var totalRewards = 0;
	  custObj.forEach(function (arrayItem, index) {
		  var markup = "<tr><td>"+arrayItem.customerName+"</td><td>"+arrayItem.numberOfTransactions+"</td><td>"+arrayItem.rewardPointsEarned+"</td><td>"+arrayItem.rewardsForMonth +" - "
		  + arrayItem.rewardsForyear+"</td><td>"+arrayItem.rewardAmount
		 +"</td> <td><input type='button' id='view_statement_"+index +"'"+"value='View Details' onclick=viewStatement('"+arrayItem.rewardsForMonth +"')></td></tr>"; 
       	  totalRewards = totalRewards + arrayItem.rewardPointsEarned;
			if (index == custObj.length - 1) {
			  $("#totalRewards").html("<strong>Total Rewards Earned:"+totalRewards +"</strong>");
		  } 
		  $("#customerInfoTable tbody").append(markup);
		});
	  
  }
  
	//view statements
    function viewStatement(rewardsMonth)  {
  	 $.ajax({
              type: "GET",
              data: {'customerName':$("#customerName").val(), 'rewardsMonth':rewardsMonth},
              url: '/eomSummary',
              dataType: "html",
              success: function(response) {
            	  $('#statementSummary').html(response);
            	  $("#statementSummary").dialog("open");
              },error: function (jqXHR, textStatus, errorThrown) {
  	        alert('Error: ' + "An error has occured, please retry or contact support");
  			}
         });  
}
  </script>
</html>