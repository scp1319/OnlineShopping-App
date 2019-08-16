$(function() {
	$.ajax({
		url : 'displayAllProduct.lti',
		method : 'POST',
		contentType : 'application/json',

		success : function(response) {
			response.forEach(function(product) {
						var knowMore = $("<button id='buy'/>")
						$("#productDisplayList").append(
										"<div id='border'>"
												+ "<div id='img-desc'><img id='img-align' src='img/mobile.jpg'></img>"
												+ "<div id='align'><h4>"
												+ product.name
												+ "</h4>"
												+ "<p>"
												+ product.description
												+ "</p>"
												+ "<div>Price <span class='currencyINR' id='price'>Rs."
												+ product.price
												+ "</span><div>"
												+ "<button class='buy'>Add to cart</button>"
												+ "<button class='buy'>Add to Wishlist</button>"
						);
						$("#productDisplayList").append(knowMore);
						knowMore.attr("class", "selectedProduct");
						knowMore.attr("selectedProductId", product.id);
						knowMore.text("Know more");
					    $("#productDisplayList").append( "</div></div></div></div></div>");
					})
					
					$("#productDisplayList").on("click",".selectedProduct", function(){
						var selectedProductId = $(this).attr("selectedProductId");
						//alert("selectedProductId is "+selectedProductId);
						sessionStorage.setItem("selectedProductId", selectedProductId);
						window.location.href="productDescription.html";
					})
		}
	})
	/* price low to high */
	$('#priceFieldset input[type=radio]')
			.change(
					function() {
						var filterOption = $(this).val();
						if (filterOption == "lowToHigh") {
							$("#productDisplayList").empty();
							$
									.ajax({
										url : 'displayAllProductByPriceLowToHigh.lti',
										method : 'POST',
										contentType : 'application/json',

										success : function(response) {
											response
													.forEach(function(product) {
														var knowMore = $("<button id='buy'/>")
														$("#productDisplayList")
																.append(
																		"<div id='border'>"
																				+ "<div id='img-desc'><img id='img-align' src='img/mobile.jpg'></img>"
																				+ "<div id='align'><h4>"
																				+ product.name
																				+ "</h4>"
																				+ "<p>"
																				+ product.description
																				+ "</p>"
																				+ "<div>Price <span class='currencyINR' id='price'>Rs."
																				+ product.price
																				+ "</span><div>"
																				+ "<button class='buy'>Add to cart</button>"
																				+ "<button class='buy'>Add to Wishlist</button>");
														$("#productDisplayList")
																.append(
																		knowMore);
														knowMore
																.attr("class",
																		"selectedProduct");
														knowMore
																.attr(
																		"selectedProductId",
																		product.id);
														knowMore
																.text("Know more");
														$("#productDisplayList")
																.append(
																		"</div></div></div></div></div>");
													})

											$("#productDisplayList")
													.on(
															"click",
															".selectedProduct",
															function() {
																var selectedProductId = $(
																		this)
																		.attr(
																				"selectedProductId");
																// alert("selectedProductId
																// is
																// "+selectedProductId);
																sessionStorage
																		.setItem(
																				"selectedProductId",
																				selectedProductId);
																window.location.href = "productDescription.html";
															})
										}
									})
						} else { /* price high to low */
							$("#productDisplayList").empty();
							$
									.ajax({
										url : 'displayAllProductByPriceHighToLow.lti',
										method : 'POST',
										contentType : 'application/json',

										success : function(response) {
											response
													.forEach(function(product) {
														var knowMore = $("<button id='buy'/>")
														$("#productDisplayList")
																.append(
																		"<div id='border'>"
																				+ "<div id='img-desc'><img id='img-align' src='img/mobile.jpg'></img>"
																				+ "<div id='align'><h4>"
																				+ product.name
																				+ "</h4>"
																				+ "<p>"
																				+ product.description
																				+ "</p>"
																				+ "<div>Price <span class='currencyINR' id='price'>Rs."
																				+ product.price
																				+ "</span><div>"
																				+ "<button class='buy'>Add to cart</button>"
																				+ "<button class='buy'>Add to Wishlist</button>");
														$("#productDisplayList")
																.append(
																		knowMore);
														knowMore
																.attr("class",
																		"selectedProduct");
														knowMore
																.attr(
																		"selectedProductId",
																		product.id);
														knowMore
																.text("Know more");
														$("#productDisplayList")
																.append(
																		"</div></div></div></div></div>");
													})

											$("#productDisplayList")
													.on(
															"click",
															".selectedProduct",
															function() {
																var selectedProductId = $(
																		this)
																		.attr(
																				"selectedProductId");
																// alert("selectedProductId
																// is
																// "+selectedProductId);
																sessionStorage
																		.setItem(
																				"selectedProductId",
																				selectedProductId);
																window.location.href = "productDescription.html";
															})
										}
									})
						}
					})
	// diplay all products
					
})
