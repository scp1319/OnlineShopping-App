	$(function() {
		var productId = sessionStorage.getItem("selectedProductId");
		
		
		$
				.ajax({
					url : 'displayProductById.lti?productId=' + productId,
					method : 'GET',
					success : function(response) {
						$("#productDescription")
								.append(
										"<div class='column'><img id='img-prod-desc' src='img/mobile.jpg' alt='Snow'></div><div>"
												+ "<h4>Product Name: "
												+ response.name
												+ " </h4>"
												+ "<div class='desc-align'>Product Description:"
												+ response.description
												+ "</div>"
												+ "<div>Price <span class='currencyINR' id='price'>Rs."
												+ response.price
												+ "</span>"
												+ "</div>"
												);
					}
				})
	})