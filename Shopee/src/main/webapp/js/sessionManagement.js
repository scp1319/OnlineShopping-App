$(function() {
		$("#logout").hide();
		var userEmail = sessionStorage.getItem("userEmail");
		var userId = sessionStorage.getItem("userId");
		
		if (userEmail != null) {
			$("#userEmail").append(userEmail);
			$("#logout").show();
			$("#login").hide();
			$("#register").hide();
		}
		
	});
