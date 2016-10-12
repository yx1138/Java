package edu.nyu.cs9053.homework5;


public class LinearlyDecayTimeTraveler extends BasicTimeTraveler{
	public LinearlyDecayTimeTraveler (String name){
		super(name);
	}
	@Override public double decayCalculator(double leapedTime){
		return super.getRemainingYearsOfTravel()-leapedTime;
	}
}