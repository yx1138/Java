package edu.nyu.cs9053.homework10;
import java.util.concurrent.ExecutorService;;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.*;
import java.lang.InterruptedException;
import java.util.concurrent.TimeUnit;
/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:33 PM
 */
public class ExecutorWordCounter extends AbstractConcurrencyFactorProvider implements WordCounter {
    private ExecutorService executor;                      
    private MyThread[] mythreads;
    public ExecutorWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        mythreads = new MyThread[concurrencyFactor];
        executor = Executors.newFixedThreadPool(concurrencyFactor);
    }

    @Override public void count(String fileContents, String word, Callback callback) {
        // TODO - implement this class using calls to an ExecutorService; one call per {@link #concurrencyFactor}
        // HINT - break up {@linkplain fileContents} and distribute the work across the calls
        // HINT - do not create the ExecutorService object in this method
        int concurrencyFactor = super.getConcurrencyFactor();
        //split the string in the file into words
        String[] words= fileContents.split("\\W+");
        //seperate the list of words to several parts according to the concurrencyFactor
        int gap = words.length/concurrencyFactor;
        AtomicLong counter = new AtomicLong(0);
        for(int i =0 ;i<concurrencyFactor-1;i++){
            mythreads[i] = new MyThread(words,word,i*gap,(i+1)*gap,counter);
            executor.execute(mythreads[i]);
        }
        mythreads[concurrencyFactor-1] = new MyThread(words,word,(concurrencyFactor-1)*gap,(words.length-1),counter);
        executor.execute(mythreads[concurrencyFactor-1]);

        executor.shutdown();
        try{
             executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        }
       catch (InterruptedException e){
            e.printStackTrace();
       }
        callback.counted(counter.get());
    }

    @Override public void stop() {
        // TODO - stop the executor
        executor.shutdownNow();
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
