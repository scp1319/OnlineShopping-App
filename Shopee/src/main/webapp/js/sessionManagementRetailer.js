$(function() {
		$("#logoutRetailer").hide();
		var retailerEmail = sessionStorage.getItem("retailerEmail");
		var retailerId = sessionStorage.getItem("retailerId");
		
		if (adminEmail != null) {
			$("#userEmail").append(userEmail);
			$("#logoutRetailer").show();
			$("#loginRetailer").hide();
			$("#register").hide();
		}
	});
