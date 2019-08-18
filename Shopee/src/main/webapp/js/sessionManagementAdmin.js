$(function() {
		$("#logoutAdmin").hide();
		var adminEmail = sessionStorage.setItem("adminEmail");
		var adminId = sessionStorage.getItem("adminId");
		
		if (retailerEmail != null) {
			$("#adminEmail").append(adminEmail);
			$("#logoutAdmin").show();
		}
	});

