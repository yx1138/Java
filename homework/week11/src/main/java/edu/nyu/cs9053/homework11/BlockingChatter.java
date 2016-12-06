package edu.nyu.cs9053.homework11;

import java.io.*;
import java.util.Random;
import java.nio.charset.Charset;
/**
 * User: blangel
 * Date: 11/23/14
 * Time: 4:31 PM
 */
public class BlockingChatter implements Chatter {
	private static final Charset UTF8 = Charset.forName("UTF-8");
	private static final int READ_BUFFER_SIZE = 1024;
	private static final int MAX_LINE = 21690;
	private final InputStream chatServerInput;
	private final OutputStream chatServerOutput;
	private final InputStream userInput;
	private String[] contents;
	private int validLineNumber;
    public BlockingChatter(InputStream chatServerInput, OutputStream chatServerOutput, InputStream userInput) {
        // TODO
        this.chatServerInput = chatServerInput;
        this.chatServerOutput = chatServerOutput;
        this.userInput = userInput;
        contents = null;
        validLineNumber = 0;

    }

    @Override public void run() {
    	Thread threadForInput = new Thread(new Runnable(){
    		public void run(){
    			while(true){
    				byte[] buffer = new byte[READ_BUFFER_SIZE];
        			try{
        			int length = userInput.read(buffer);
    				chatServerOutput.write(buffer, 0, length);
        			}catch (IOException e){
						System.out.printf("Exception - %s%n", e.getMessage());
        			}
    			}
    		}
    	});
    	Thread threadForServer = new Thread(new Runnable(){
    		public void run(){
    			while(true){
        			byte[] buffer = new byte[READ_BUFFER_SIZE];
        			try{
        				int len = chatServerInput.read(buffer);
						String messageFormServer = new String(buffer);
						System.out.println(messageFormServer);
						String easterEggFlag = messageFormServer.substring(19,23);
						if(easterEggFlag.equals("java")){
							EasterEgg();
						}
        			}catch (IOException e){
        				System.out.printf("Exception - %s%n", e.getMessage());
        			}			
        		}
    		}
    	});
    	threadForServer.start();
    	threadForInput.start();
        
    }
    public void EasterEgg() throws IOException {
    	if(contents==null){
    		loadTXTcontent();
    	}
    	Random random = new Random();
    	int random_line_number = random.nextInt(validLineNumber);
		byte[] buffer = contents[random_line_number].getBytes(UTF8);
		chatServerOutput.write(buffer, 0, buffer.length);

    }
    public void loadTXTcontent() throws IOException{
    	contents = new String[MAX_LINE];
    	String file = "src/main/resources/Moby Dick.txt";
    	FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
    	String line = reader.readLine();
    	contents[0] = line;
    	validLineNumber++;
		for (int i = 0; i <  MAX_LINE; i++) {
  			line = reader.readLine();
  			//skip the blank line
  			if(!line.trim().equals("")){
				contents[validLineNumber] = line;
    			validLineNumber++;
  			}
		}
    }
}
