function onValidate() {
		var product = $("#ssProduct").val();
		var coupon = $("#ssCoupon").val();
		
		var jsonObj = new Object();
		jsonObj.prod = product;
		jsonObj.coup = coupon;

		$.ajax({
			url : "./validateCoupon",
			method: "POST",
			data :  JSON.stringify(jsonObj),
			success : function(result) {
				$("#validStatus").html(result);
			},
			error : function(result) {
				$("#validStatus").html("Error encountered!");
			}
		});
		return false;
	}	