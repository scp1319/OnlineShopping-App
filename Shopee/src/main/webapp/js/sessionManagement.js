$(function() {
		$("#logout").hide();
		var userEmail = sessionStorage.getItem("userEmail");
		
		if (userEmail != null) {
			$("#userEmail").append(userEmail);
			$("#logout").show();
			$("#login").hide();
			$("#register").hide();
		}

	});
