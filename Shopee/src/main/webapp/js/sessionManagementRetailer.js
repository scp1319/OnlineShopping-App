$(function() {
		$("#logoutRetailer").hide();
		var adminEmail = sessionStorage.getItem("retailerEmail");
		var adminId = sessionStorage.getItem("retailerId");
		
		if (adminEmail != null) {
			$("#userEmail").append(userEmail);
			$("#logoutRetailer").show();
			$("#loginRetailer").hide();
			$("#register").hide();
		}
	});
