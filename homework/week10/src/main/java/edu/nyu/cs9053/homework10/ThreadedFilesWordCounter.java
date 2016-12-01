package edu.nyu.cs9053.homework10;
import java.util.concurrent.atomic.*;
import java.lang.InterruptedException;
import java.util.Map;
import java.util.*;
/**
 * User: blangel
 * Date: 11/16/14
 * Time: 3:50 PM
 */
public class ThreadedFilesWordCounter extends AbstractConcurrencyFactorProvider implements FilesWordCounter {

    private MyFileThread[] mythreads;
    private Thread[] threads;
    public ThreadedFilesWordCounter(int concurrencyFactor) {
        super(concurrencyFactor);
        mythreads = new MyFileThread[concurrencyFactor];
        threads =new Thread[concurrencyFactor];
    }

    @Override public void count(Map<String, String> files, String word, Callback callback) {
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
                threads[i]=new Thread(mythreads[i]);
                threads[i].start();
                try{
                threads[i].join();
                }
                catch (InterruptedException e) {
                e.printStackTrace();
                }   
            }
        }
        
        while(iterator.hasNext()){
            for(int i =0 ;i<concurrencyFactor;i++){
                if(!threads[i].isAlive() && iterator.hasNext()){
                    Map.Entry entry = (Map.Entry) iterator.next();
                    String filename = (String)entry.getKey();
                    String  filecontent = (String)entry.getValue();
                    mythreads[i] = new MyFileThread(filecontent,word,concurrencyFactor,filename,callback);
                    threads[i]=new Thread(mythreads[i]);
                    threads[i].start();
                    try{
                        threads[i].join();
                    }
                    catch (InterruptedException e) {
                    e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override public void stop() {
        // TODO - stop the threads
        for(int i =0 ;i<super.getConcurrencyFactor();i++){
            threads[i].interrupt();
        }
    }
    class MyFileThread implements Runnable{
        private String filename;
        private String filecontent;
        private String word;
        private ThreadedWordCounter twc;
        private int concurrencyFactor;
        private Callback call;
        public MyFileThread(String filecontent,String word,int concurrencyFactor,String filename,Callback call){
            this.filecontent = filecontent;
            this.word = word;
            this.filename = filename;
            this.call = call;
            twc = new ThreadedWordCounter(concurrencyFactor);
        }
        public void run(){
            WordCounter.Callback callback=new WordCounter.Callback(){
            public void counted( long count) {
                call.counted(filename,count);
            }
            };
            twc.count(filecontent,word,callback);
        }
    }
}
