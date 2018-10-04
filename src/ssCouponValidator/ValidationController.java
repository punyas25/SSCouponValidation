package ssCouponValidator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ValidationController {
	Coupon couponObj;
	Product productObj;
	JSONArray validProducts;
	JSONObject validCoupon;

	String checkCouponValidity(String coupon, String product) {
		JSONObject tempProd = new JSONObject();
		String validityStatus="";
		
		couponObj= new Coupon();
		productObj=new Product();
		
		validCoupon= new JSONObject();
		validProducts= new JSONArray();
		
		validCoupon = couponObj.getCouponData(coupon);
		validProducts = productObj.getProductData(product);
		
		
		if(validCoupon != null && validProducts.length() != 0 ) {
			for(int i =0; i< validProducts.length(); i++) {
				try {
					tempProd = validProducts.getJSONObject(i);
					if(validCoupon.getString("prod_type").equalsIgnoreCase(tempProd.getString("prod_type")) || 
							validCoupon.getString("prod_type").equalsIgnoreCase("ALL")) 
					{
						if(validCoupon.getString("category").equalsIgnoreCase(tempProd.getString("category")) || 
								validCoupon.getString("category").equalsIgnoreCase("ALL")) 
						{
							if(validCoupon.getString("artist").equalsIgnoreCase(tempProd.getString("artist")) || 
									validCoupon.getString("artist").equalsIgnoreCase("ALL")) 
							{
								validityStatus = "Your Coupon is VALID!";
								break;
							}
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
			if(validityStatus.equals("")) {
				validityStatus="Invalid Coupon!";
			}
		}
		else if (validProducts.length() == 0 ) {
			validityStatus="No such product found!";
		}
		else {
			validityStatus ="No such coupon found!";
		}
		return validityStatus;
	}
}
