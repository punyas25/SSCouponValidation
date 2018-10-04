package ssCouponValidator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Product {
	JSONArray productList;
	String jsonProdData, line;
	JSONObject productObj;
	
	public JSONArray readProductData() {
		jsonProdData="";
		String filename = "C:\\Users\\punyashree\\eclipse-workspace\\ssCouponValidation\\src\\ssCouponValidator\\product.json";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) 
			{
				while((line = br.readLine()) != null) {
					//concat the read line into jsonProdData
					jsonProdData = jsonProdData.concat(line);
				}
			
			productObj = new JSONObject(jsonProdData);
			
			productList = productObj.getJSONArray("products"); 		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return productList;
	}


	//This function return object of Product class when a match of the coupon is found
	public JSONArray getProductData(String ProductName) {
		//calls the read function to get product data in 
		JSONArray prodList = readProductData();
		JSONObject prodObj;
		JSONArray matchProducts = new JSONArray();
		
		for(int i = 0; i < prodList.length(); i++)
		{	
			try {
				prodObj = prodList.getJSONObject(i);
			
				if (prodObj.getString("prod_type").equalsIgnoreCase(ProductName)) {
					matchProducts.put(prodObj);
				}
			} catch (NumberFormatException | JSONException e) 
			{
				e.printStackTrace();
			}	
		}				
		return matchProducts;
	}
}
