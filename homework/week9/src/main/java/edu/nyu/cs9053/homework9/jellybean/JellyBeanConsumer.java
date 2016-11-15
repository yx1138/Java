package edu.nyu.cs9053.homework9.jellybean;

public class JellyBeanConsumer implements Consumer{
	public JellyBean consume(JellyBeanContainer from){
		synchronized(from) {
        	if(!from.isEmpty()){
        		JellyBean re =  from.remove();
        		return re;
        	}
        	else return null;
    	}
	}
}