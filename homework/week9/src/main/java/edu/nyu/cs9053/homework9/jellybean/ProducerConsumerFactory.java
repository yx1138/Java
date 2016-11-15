package edu.nyu.cs9053.homework9.jellybean;

/**
 * User: blangel
 * Date: 10/31/15
 * Time: 12:14 PM
 */
public class ProducerConsumerFactory {

    public static Producer createProducer() {
        return new JellyBeanProducer();
    }

    public static Consumer createConsumer() {
        return new JellyBeanConsumer();
    }

}
