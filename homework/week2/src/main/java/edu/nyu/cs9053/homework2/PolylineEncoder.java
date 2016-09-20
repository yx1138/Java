package edu.nyu.cs9053.homework2;

/**
 * User: blangel
 * Date: 8/17/14
 * Time: 9:02 AM
 *
 * Implements the Polyline Algorithm defined here
 * {@literal https://developers.google.com/maps/documentation/utilities/polylinealgorithm}
 */
public class PolylineEncoder {

	/** Some comments about the function encodePolyline
 	 * 
 	 * @param gpsPoints An array of objects of class Gps
 	 * Get every point in the Array calculate according to the polyline algorithm  and call function encodeGpsPoint for every point 
 	 * 
	*/
    public  String encodePolyline(Gps[] gpsPoints) {
    	String result="";
    	//the latitude and the longtitude of the previous point as integer
    	int base_lat=0;
    	int base_lng=0;
    	for (Gps gpspoint : gpsPoints){
    		// costruct the new Gps object in the polyline
    		//Gps point= new Gps(gpspoint.getLatitude()-base_lat,gpspoint.getLongitude()-base_lng);
            int lat_e5_int=(int) Math.floor(gpspoint.getLatitude() * 1e5);
            int lng_e5_int=(int) Math.floor(gpspoint.getLongitude() * 1e5);
            //the change in latitude and longtitude
            int poly_lat = lat_e5_int-base_lat;  
            int poly_lng = lng_e5_int-base_lng;  
    		//call the encodeGpsPoint for every point
    		result=result+encodeInteger(poly_lat)+encodeInteger(poly_lng);
    		//update the base point
    		base_lat=lat_e5_int;
    		base_lng=lng_e5_int;
    	}
    	return result;
    }
 	/**
	 * @param binary_code_origin an integer which is converted from a double in the Gps object
	 * complete google polyline encode alorithm 
	 *
    */
    private  String encodeInteger(int binary_code_origin) {  
    	//left shift the origin binary code by 1
    	int binary_code = binary_code_origin << 1;  
    	//invert the code if the origin integer is negative 
    	// in java the negative integer is already two's complement
        if (binary_code_origin < 0) {  
            binary_code = ~binary_code;  
        }  
        //The return string 
        String result = "";  
       	/**
		 * Break the binary value out into 5-bit chunks 
		 * The end symbol is the binary code is less than 32 
		 * the binary is 1000000 means the binary is shorter than 6 bits
         * so we cannot left shift by 5
   		*/
        while (binary_code >= 32) {  
        	//get the last five bits in the binary code 
            int chunk = binary_code & 0x1F;  
            //OR the value with 0x20 and add 63 
            chunk = (chunk | 0x20) + 63;  
            //convert to char
            char result_char = (char) chunk;  
            //store the result
            result+= result_char;  
            //left shift by 5 so that we throw the last five bits
            binary_code >>= 5;  
        }  
        //the last chunk doesn't OR with 0x20
        result += (char) (binary_code + 63);  
        return result;  
    } 
  
}
