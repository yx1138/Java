package edu.nyu.cs9053.homework11;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;

/**
 * User: blangel
 * Date: 11/23/14
 * Time: 4:32 PM
 */
public class NonBlockingChatter implements Chatter {
	private static final Charset UTF8 = Charset.forName("UTF-8");

	private static final int READ_BUFFER_SIZE = 1024;

	private final SocketChannel chatServerChannel;

    private final ByteBuffer readBuffer;

    private final ByteBuffer writeBuffer;

    private final Pipe.SourceChannel userInput;
    public NonBlockingChatter(SocketChannel chatServerChannel,
                              Pipe.SourceChannel userInput) {
        // TODO
        this.chatServerChannel = chatServerChannel;
        this.userInput = userInput;
        readBuffer = ByteBuffer.allocate(READ_BUFFER_SIZE);
        writeBuffer = ByteBuffer.allocate(READ_BUFFER_SIZE);

    }

    @Override public void run() {
        // TODO
        while(!Thread.currentThread().isInterrupted()){
        	try{
        		int len  = userInput.read(writeBuffer);
        		writeBuffer.flip();
        		chatServerChannel.write(writeBuffer);
        		writeBuffer.clear();
       
            	int result = chatServerChannel.read(readBuffer);
            	if(result<1){
            		continue;
            	}
            	readBuffer.flip();
            	CharsetDecoder decoder = UTF8.newDecoder();
            	CharBuffer charBuffer = decoder.decode(readBuffer);
            	readBuffer.clear();
            	System.out.printf("%s%n", charBuffer.toString());
            	
        	}
        	catch(Exception e){
        		System.out.printf("Exception - %s%n", e.getMessage());
        	}

        }
        

    }
    
}
