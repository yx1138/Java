package edu.nyu.cs9053.homework9.jellybean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: blangel
 * Date: 10/31/15
 * Time: 12:08 PM
 *
 */
public class JellyBeanDispenser {

    private static final int MAX_INITIAL_JELLY_BEANS = 1000;

    public static void main(String[] args) {
        List<JellyBean> jellyBeans = seed();
        JellyBeanContainer container = new JellyBeanContainer(jellyBeans);
        Producer producer = ProducerConsumerFactory.createProducer();
        Consumer consumer = ProducerConsumerFactory.createConsumer();
        JellyBeanDispenser dispenser = new JellyBeanDispenser(container, producer, consumer);
        dispenser.start();
    }

    private static List<JellyBean> seed() {
        Random random = new Random();
        int capacity = random.nextInt(MAX_INITIAL_JELLY_BEANS) + 1;
        Flavor[] flavors = Flavor.values();
        List<JellyBean> initial = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            initial.add(new JellyBean(flavors[random.nextInt(flavors.length)]));
        }
        return initial;
    }

    private final JellyBeanContainer jellyBeans;

    private final Producer producer;

    private final Consumer consumer;

    public JellyBeanDispenser(JellyBeanContainer jellyBeans, Producer producer, Consumer consumer) {
        this.jellyBeans = jellyBeans;
        this.producer = producer;
        this.consumer = consumer;
    }

    private void start() {
        Thread producerThread = new Thread(new Runnable() {
            @Override public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    JellyBean bean = producer.produce(jellyBeans);
                    if (bean != null) {
                        System.out.printf("Produced %s%n", bean);
                    }
                }
            }
        });
        Thread consumerThread = new Thread(new Runnable() {
            @Override public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    JellyBean bean = consumer.consume(jellyBeans);
                    if (bean != null) {
                        System.out.printf("Consumed %s%n", bean);
                    }
                }
            }
        });
        producerThread.start();
        consumerThread.start();
        while (producerThread.isAlive() && consumerThread.isAlive()) {
            Thread.yield();
        }
        // failure, orderly shutdown and error message print
        producerThread.interrupt();
        consumerThread.interrupt();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
        System.err.printf("Fail! Producer or Consumer not implemented properly");
        System.exit(1);
    }

}
