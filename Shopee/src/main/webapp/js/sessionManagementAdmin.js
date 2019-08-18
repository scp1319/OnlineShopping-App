$(function() {
		$("#logoutAdmin").hide();
		var adminEmail = sessionStorage.getItem("adminEmail");
		var adminId = sessionStorage.getItem("adminId");
		
		if (adminEmail != null) {
			$("#userEmail").append(userEmail);
			$("#logoutAdmin").show();
			$("#loginAdmin").hide();
			$("#register").hide();
		}
	});
