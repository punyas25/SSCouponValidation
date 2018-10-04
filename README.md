# SSCouponValidation
Aim: An endpoint to check the validity a coupon for a particular product

The assignment was attempted using Java EE. 
Below is an overview of the attempted assignment.

GET: http://localhost:8080/ssCouponValidation/validateCoupon
	 doGet() returns the UI which allows us to perform coupon validation in the form of an html page.

POST: doPost() accepts the data submitted from the html page, performs validation, and returns the result that is displayed on the html page.

Data: Product and Coupons data is saved in JSON format in 'product.json' and 'coupons.json' files respectively. 
	  Presently, these files are to be saved on the root drive (for example - C:\\) of the system where code is being executed

Following scenarios have been checked to ensure expected behaviour is achieved: 
1. Coupon applied to a specific product: 'TEE30' applied to product 'Tshirts'.
	When applied to product type 'Tshirts', it is found to be a valid coupon. 
	Check is done only based on Product type, irrespective of the Category or Artist.

2. Coupon applied to products under a specific Category: 'LAUF10' applied to Category 'COMEDY'
	When applied for a specific product type, check is made to validate the Category of the product.
	Coupon is considered valid for all products with Category as 'COMEDY'

3. Coupon applied to products of a specific Artist: 'DART15' applied to Artist 'DEVI'
	When applied for a specific product type, check is made to validate the Artist of the product.
	Coupon is considered valid for all products by Artist 'DEVI'

4. Coupon applied to all products of one Category by one Artist: 'FLAT50' applied to Category 'COMEDY' by Artist 'YNAH'
	When applied for a specific product type, check is made to validate the Artist  and the Category of the product.
	Coupon is considered valid for all products under Category 'COMEDY' by Artist 'YNAH'
