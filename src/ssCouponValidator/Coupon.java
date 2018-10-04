package ssCouponValidator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Coupon {
	JSONArray couponList;
	String jsonCoupData, line;
	JSONObject couponObj;
	
	public JSONArray readCouponData(){
		jsonCoupData="";
		String filename = "C:\\Users\\punyashree\\eclipse-workspace\\ssCouponValidation\\src\\ssCouponValidator\\coupons.json";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) 
			{
				while((line = br.readLine()) != null) {
					//concat the read line into jsonCoupData
					jsonCoupData = jsonCoupData.concat(line);
				}
			
			couponObj = new JSONObject(jsonCoupData);
			couponList = couponObj.getJSONArray("coupons"); 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return couponList;
	}
	
	//This function return object of Coupon class when a match of the coupon is found
	public JSONObject getCouponData(String CouponName) {
		//call the read function to get coupon data in 
		JSONArray coupList = readCouponData();
		JSONObject couponObj;
		
		for(int i = 0; i < coupList.length(); i++)
		{	
			try {
				couponObj = coupList.getJSONObject(i);
			
				if (couponObj.getString("coup_name").equalsIgnoreCase(CouponName)) {
					return couponObj;
				}
			} catch (NumberFormatException | JSONException e) 
			{
				e.printStackTrace();
			}	
		}		
		return null;
	}
}
