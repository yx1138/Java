package edu.nyu.cs9053.homework2;

/**
 * User: blangel
 * Date: 8/17/14
 * Time: 10:21 AM
 */
public class Program {

    public static void main(String[] args) {
    //get the argument number
    int args_size = args.length;
    // the first argument is "gps"
    if (args[0].equals("gps")){
    	//create an instance of the PolylineEncoder
    	PolylineEncoder poly_line_encoder=new PolylineEncoder();
    	//split the arguments . Construct Gps objects and store in the Array.
    	Gps[] points = new Gps[args_size-1];
    	for (int index=1;index<args_size;index++){
    		 String[] lat_lng = args[index].split(",");
    		 try{
    		 	double latitude = Double.parseDouble(lat_lng[0]);
    		 	double longtitude = Double.parseDouble(lat_lng[1]);
    		 	points[index-1]=new Gps(latitude,longtitude);
    		 }
    		 catch (Exception e){
    		 	//Invalid argument
    		 	System.out.println("Invalid argument");
    		 	System.exit(0);
    		 }
    	}
    	// call function encodePolyline and print the result.
    	System.out.println(poly_line_encoder.encodePolyline(points));

    }
    //the first argument is "annuity"
    else if (args[0].equals("annuity")){
    		//create an instance of the AnnuityCalculator
    		AnnuityCalculator annuity_calculator  = new AnnuityCalculator();
    		// the second argument is "compound".
    		if (args[1].equals("compound")){
    			// check the argument number
    			if (args_size !=5 )
    			{
    				System.out.println("Invalid argument");
    		 		System.exit(0);
    			}
    			try{
    				double annuityAmount = Double.parseDouble(args[2]);
    				double annualInterestRateInPercent = Double.parseDouble(args[3]);
    				int years = Integer.parseInt(args[4]);
    				if (years==15){
    					System.out.println(annuity_calculator.computeMonthlyCompoundedFutureValueOfAnnuityIn15Years(annuityAmount,annualInterestRateInPercent));
    				}
    				else if (years==30){
    					System.out.println(annuity_calculator.computeMonthlyCompoundedFutureValueOfAnnuityIn30Years(annuityAmount,annualInterestRateInPercent));
    					}
    				else System.out.println(annuity_calculator.computeMonthlyCompoundedFutureValueOfAnnuity(annuityAmount,annualInterestRateInPercent,years));
    			}
    			catch (Exception e){
    		 		System.out.println("Invalid argument");
    		 		System.exit(0);
    			 }
    			
    			
    		}
    		// the second argument is not compound 
    		else {
    			if (args_size !=4)
    			{
    				System.out.println("Invalid argument");
    		 		System.exit(0);
    			}
    			try{
    				double annuityAmount = Double.parseDouble(args[1]);
    				double annualInterestRateInPercent = Double.parseDouble(args[2]);
    				int years = Integer.parseInt(args[3]);
    				if (years==15){
    					System.out.println(annuity_calculator.computeFutureValueOfAnnuityIn15Years(annuityAmount,annualInterestRateInPercent));
    				}
    				else if (years==30){
    					System.out.println(annuity_calculator.computeFutureValueOfAnnuityIn30Years(annuityAmount,annualInterestRateInPercent));
    				}
    				else System.out.println(annuity_calculator.computeFutureValueOfAnnuity(annuityAmount,annualInterestRateInPercent,years));
    			}
    			catch (Exception e){
    		 		System.out.println("Invalid argument");
    		 		System.exit(0);
    			 }
    			
    		}
    }
    else {
    	System.out.println("Invalid argument");
    }
    }

}
