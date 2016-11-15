package edu.nyu.cs9053.homework9;
import java.util.concurrent.Semaphore;
/**
 * User: blangel
 * Date: 11/11/14
 * Time: 8:49 AM
 */
public class Waiter {
	private final Semaphore available ;

	public  Waiter(){
		this.available = new Semaphore(1);
	}
    // TODO - implement
    public boolean attempt(Chopstick left, Chopstick right){
		Semaphore left_available = left.getSemaphore();
		Semaphore right_available = right.getSemaphore();
		try{
			left_available.acquire();
			right_available.acquire();
		}
		catch(Exception e){
			return false;
		}
		return true;
    }
    public void release(Chopstick left, Chopstick right){
    	Semaphore left_available = left.getSemaphore();
		Semaphore right_available = right.getSemaphore();
		
		left_available.release();
		
		right_available.release();
    }
    public Semaphore getSemaphore(){
 		return available;
 	}

}
