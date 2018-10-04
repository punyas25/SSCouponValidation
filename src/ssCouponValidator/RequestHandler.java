package ssCouponValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class RequestHandler
 */
@WebServlet("/validateCoupon")
public class RequestHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String htmlText ="<html><head><title>Souled Store Coupon Validation</title> <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script> <style>.container-div{width:100%;max-width:600px;margin:0 auto}</style></head><body><div class=\"container-div\"><h2>Check Coupon Validity</h2><p>Select Product: <select id=\"ssProduct\"><option value=\"tshirts\">T-Shirts</option><option value=\"mugs\">Mugs</option><option value=\"posters\">Posters</option><option value=\"tote\">Tote Bags</option><option value=\"magnets\">Magnets</option><option value=\"caps\">Caps</option> </select></p><p>Enter Coupon: <input type=\"text\" id=\"ssCoupon\"></p><p><input type=\"submit\" id=\"btnValidate\" value=\"Validate\"></p><p id=\"validStatus\">Let's Check....</p></div> <script type=\"text/javascript\" src=\"couponvalidation.js\"></script> <script type=\"text/javascript\">$(\"body\").on(\"click\",\"#btnValidate\",function(){onValidate();});</script> </body></html>";
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(htmlText);		
		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line, status;
		JSONObject reqDataObj = new JSONObject();
		status = "";
		
		while((line = reader.readLine()) != null) {
	        buffer.append(line);
	    }
	    String data = buffer.toString();
	    
	    try {
			reqDataObj = new JSONObject(data);
			String product1 = reqDataObj.getString("prod");
			String coupon1 = reqDataObj.getString("coup");
			
		    ValidationController validationObj = new ValidationController();
		    status=validationObj.checkCouponValidity(coupon1, product1);
		    
		    PrintWriter writer = response.getWriter();
			writer.print(status);		
			writer.flush();
			writer.close();
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
