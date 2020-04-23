<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<head>
	</head>
	<body>
	 <div class="container">
	  <div class="row"> <div class="col-md-8">
		<div id="paySlip">
					<h3 align="center">End of Month Rewards Details for month of ${rewardsMonth} - Customer: ${customerName}</h3>
					<table class="table table-striped table-bordered" >
						<thead>
							<tr>
								<th style="text-align: center">Transaction Number</th>
								<th style="text-align: center">Transaction Amount</th>
								<th style="text-align: center">Rewards Earned</th>
							</tr>
						</thead>
					<c:forEach items="${eomData.rewardPointsPerTx}" var="subSectionList" varStatus="status" >
							<tbody>
								<tr>
									<td style="text-align: center">${status.count}</td>
									<td style="text-align: center"> ${eomData.amountPerTx[status.index]}</td>
									<td style="text-align: center">${subSectionList}</td>
								</tr>
							</tbody>
						</c:forEach>
						</table>
					</div>
			</div>
			</div>
			</div>
	</body>
</html>