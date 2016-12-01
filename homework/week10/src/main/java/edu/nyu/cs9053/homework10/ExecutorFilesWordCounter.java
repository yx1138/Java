package edu.nyu.cs9053.homework10;

import java.util.Map;
import java.util.concurrent.ExecutorService;;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.*;
import java.lang.InterruptedException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;
import java.util.*;
/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:50 PM
 */
public class ExecutorFilesWordCounter extends AbstractConcurrencyFactorProvider implements FilesWordCounter {
    private ExecutorService executor;
    private MyFileThread[] mythreads;
    private Future[] futures;
    public ExecutorFilesWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        mythreads = new MyFileThread[concurrencyFactor];
        executor = Executors.newFixedThreadPool(concurrencyFactor);
        futures = new Future[concurrencyFactor];
    }

    @Override public void count(Map<String, String> files, String word, Callback callback) {
        // TODO - implement this class using calls to an ExecutorService; with one call per {@linkplain concurrencyFactor}.
        // HINT - do not create the ExecutorService object in this method
        int concurrencyFactor = super.getConcurrencyFactor();
        
        Iterator iterator = files.entrySet().iterator();
   

        // TODO - implement this class using Thread objects; one Thread per {@link #concurrencyFactor} with each Thread handling at most one file at one time
        // HINT - do not create the ExecutorService object in this method
        for(int i =0 ;i<concurrencyFactor;i++){
            if (iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                String filename = (String)entry.getKey();
                String  filecontent = (String)entry.getValue();
                mythreads[i] = new MyFileThread(filecontent,word,concurrencyFactor,filename,callback);
                futures[i] = executor.submit(mythreads[i]);  
                 
            }
        }
        
        while(iterator.hasNext()){
            for(int i =0 ;i<concurrencyFactor;i++){
                if(futures[i].isDone() && iterator.hasNext()){
                    Map.Entry entry = (Map.Entry) iterator.next();
                    String filename = (String)entry.getKey();
                    String  filecontent = (String)entry.getValue();
                    mythreads[i] = new MyFileThread(filecontent,word,concurrencyFactor,filename,callback);
                    futures[i] = executor.submit(mythreads[i]);  
                }
            }
        }

    }

    @Override public void stop() {
        // TODO - stop the executor
        executor.shutdown();
    }
    class MyFileThread implements Runnable{
        private String filename;
        private String fileContent;
        private String word;
        private ExecutorWordCounter twc;
        private int concurrencyFactor;
        private Callback call;
        public MyFileThread(String fileContent,String word,int concurrencyFactor,String filename,Callback call){
            this.fileContent = fileContent;
            this.word = word;
            this.filename = filename;
            this.call = call;
            twc = new ExecutorWordCounter(concurrencyFactor);
        }
        public void run(){
            WordCounter.Callback callback=new WordCounter.Callback(){
            public void counted( long count) {
                call.counted(filename,count);
            }
        };
            twc.count(fileContent,word,callback);
        }
    }
}
