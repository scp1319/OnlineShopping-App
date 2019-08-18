$(function() {
		$("#logout").hide();
		var userEmail = sessionStorage.getItem("userEmail");
		var userId = sessionStorage.getItem("userId");
		
		if (userEmail != null) {
			$("#userEmail").append(userEmail);
			$("#logout").show();
			$("#login").hide();
			$("#register").hide();
		
		
		$.ajax({
			url : 'fetchCartByUserId.lti?userId=' + userId,
			method : 'GET',
			contentType : 'application/json',
			data : JSON.stringify(userId),
			success : function(response) {
				var cartId = response.cartId;
				alert(cartId)
				sessionStorage.setItem("cartId", cartId);
			}
		})
		}
	});
