$(function() {
		$("#logoutRetailer").hide();
		var retailerEmail = sessionStorage.getItem("retailerEmail");
		var retailerId = sessionStorage.getItem("retailerId");
		
		if (retailerEmail != null) {
			$("#retailerEmail").append(retailerEmail);
			$("#logoutRetailer").show();
		}
	});
