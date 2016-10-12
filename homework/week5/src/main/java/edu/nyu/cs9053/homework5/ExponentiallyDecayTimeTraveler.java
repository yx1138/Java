package edu.nyu.cs9053.homework5;


public class ExponentiallyDecayTimeTraveler extends BasicTimeTraveler{
	private static final double MAX_TRAVEL_ABILITY = 100.0d;

	private final double decayConstant;
	
	private double cumulativeTravelTime;

	public ExponentiallyDecayTimeTraveler (String name , double decayConstant ){
		super(name);
		this.decayConstant = decayConstant;
		this.cumulativeTravelTime = 0.0d;
	}
	@Override public double decayCalculator(double leapedTime){
		cumulativeTravelTime = cumulativeTravelTime + leapedTime;
		double result = 0.0d;
		result =MAX_TRAVEL_ABILITY* Math.exp(-1 * decayConstant * cumulativeTravelTime);
		return result;
	}
}