package edu.nyu.cs9053.homework9;
import java.util.concurrent.Semaphore;
public class PhilosopherWithWaiter implements Philosopher{
	private final String name;
	private final Waiter waiter;

	public PhilosopherWithWaiter(String name,Waiter waiter){
		this.name = name;
		this.waiter = waiter;
	}
	public boolean attemptEat(Chopstick left, Chopstick right, Callback callback){
		Semaphore avaliable = waiter.getSemaphore();
		try{
			avaliable.acquire();
			if(waiter.attempt(left,right)){
				callback.pickedUpChopstick(left);
				callback.pickedUpChopstick(right);
				avaliable.release();
				return true;
			}
			else {
				return false;
			}
		}
		catch(InterruptedException e){
			return false;
		}
		
	} 
	public void doneEating(Chopstick left, Chopstick right, Callback callback){
		
		Semaphore left_available = left.getSemaphore();
		Semaphore right_available = right.getSemaphore();

		callback.putDownChopstick(left);
		callback.putDownChopstick(right);
		
		left_available.release();
		right_available.release();
	}
	public String getName(){
		return name;
	}
}