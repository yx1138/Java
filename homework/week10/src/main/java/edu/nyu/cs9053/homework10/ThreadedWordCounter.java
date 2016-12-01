package edu.nyu.cs9053.homework10;
import java.util.concurrent.atomic.*;
import java.lang.InterruptedException;
/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:16 PM
 */
public class ThreadedWordCounter extends AbstractConcurrencyFactorProvider implements WordCounter {
    private MyThread[] mythreads;
    private Thread[] threads;
    public ThreadedWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        mythreads = new MyThread[concurrencyFactor];
        threads =new Thread[concurrencyFactor];
        
    }

    @Override public void count(String fileContents, String word, Callback callback) {
        int concurrencyFactor = super.getConcurrencyFactor();
        //split the string in the file into words
        String[] words= fileContents.split("\\W+");
        //seperate the list of words to several parts according to the concurrencyFactor
        int gap = words.length/concurrencyFactor;
        AtomicLong counter = new AtomicLong(0);
        for(int i =0 ;i<concurrencyFactor-1;i++){
            mythreads[i] = new MyThread(words,word,i*gap,(i+1)*gap,counter);
            threads[i]=new Thread(mythreads[i]);
        }
        mythreads[concurrencyFactor-1] = new MyThread(words,word,(concurrencyFactor-1)*gap,(words.length-1),counter);
        threads[concurrencyFactor-1]= new Thread(mythreads[concurrencyFactor-1]); 

        for(int i =0 ;i<concurrencyFactor;i++){
           threads[i].start();
           try{
            threads[i].join();
           }
           catch (InterruptedException e) {
            e.printStackTrace();
            }
        }
        
        callback.counted(counter.get());
        //
        // TODO - implement this class using Thread objects; one Thread per {@link #concurrencyFactor}
        // HINT - break up {@linkplain fileContents} and distribute the work across the threads
        // HINT - do not create the Thread objects in this method
    }

    @Override public void stop() {
        // TODO - stop the threads
        for(int i =0 ;i<super.getConcurrencyFactor();i++){
            try{
                threads[i].join();
                }
             catch (InterruptedException e) {
                    e.printStackTrace();
                 }
        }
    }

    class MyThread implements Runnable{
        private String[] words;
        private String word;
        private int start;
        private int end;
        private AtomicLong count;
        private final AtomicInteger threadcount = new AtomicInteger(0);
        public MyThread(String[] words,String word,int start,int end,AtomicLong count){
            this.words = words;
            this.word = word;
            this.start = start;
            this.end = end;
            this.count = count;
        }
        public void run(){
            
            for(int m = start ; m<end; m++){
                if (words[m].equals(word))
                    threadcount.getAndIncrement();
                }
            count.addAndGet(threadcount.get());
            
        }
    }
}
