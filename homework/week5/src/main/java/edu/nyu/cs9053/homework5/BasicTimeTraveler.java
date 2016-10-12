package edu.nyu.cs9053.homework5;



public abstract class BasicTimeTraveler implements TimeTraveler{
	private static final double MAX_TRAVEL_ABILITY = 100.0d;

	private final String name;
	private double travelAbility = MAX_TRAVEL_ABILITY;
	
	public BasicTimeTraveler(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
	public Double getRemainingYearsOfTravel(){
		return travelAbility;
	}
	
	public void adjust(Time unit, int amount, boolean ahead){
		double leapedTime = 0.0d ;
		switch(unit){
			case Hours :
			leapedTime = ( (double) amount / 24 ) / 365 ;
			break;
			case Days :
			leapedTime = (double) amount / 365 ;
			break;
		}
		double newTraveleAbility = decayCalculator(leapedTime) ;
		travelAbility = newTraveleAbility;
	}
	public abstract double decayCalculator(double leapedTime);
}