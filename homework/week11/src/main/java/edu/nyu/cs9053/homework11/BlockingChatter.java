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
	private static final int MAX_LINE = 21691;
	private final InputStream chatServerInput;
	private final OutputStream chatServerOutput;
	private final InputStream userInput;
    public BlockingChatter(InputStream chatServerInput, OutputStream chatServerOutput, InputStream userInput) {
        // TODO
        this.chatServerInput = chatServerInput;
        this.chatServerOutput = chatServerOutput;
        this.userInput = userInput;

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
    	String file = "src/main/resources/Moby Dick.txt";
    	Random random = new Random();
    	int random_line_number = random.nextInt(MAX_LINE);
    	FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
    	String line = reader.readLine();
		for (int i = 0; i < random_line_number + 1; i++) {
  			line = reader.readLine();
		}
		if(line.equals("")){
			line=" ";
		}
		byte[] buffer = line.getBytes(UTF8);
		chatServerOutput.write(buffer, 0, buffer.length);

    }
}
