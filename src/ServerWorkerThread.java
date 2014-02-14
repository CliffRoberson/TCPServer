
/* Clifford Roberson
 * Networks homework 1
 * 
 * 
 * With help from: http://www.javaworld.com/article/2077322/core-java/sockets-programming-in-java-a-tutorial.html
 * http://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
 * http://stackoverflow.com/questions/2187626/how-to-create-a-basic-java-server
 */

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ServerWorkerThread extends Thread {

	Socket clientSocket = null;
	
	public ServerWorkerThread (Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	

	public void run() {
        try {
        	if (MTServer.available.tryAcquire()){
        		
	        	
	            PrintStream out = new PrintStream(clientSocket.getOutputStream(), true);
	            
	            Scanner in = new Scanner(clientSocket.getInputStream());
	            
	            if (in.hasNextLine()){
	            	out.println(in.nextLine().toUpperCase());
	            	
	            }
	                        
	            in.close();
	            out.close();
	            clientSocket.close();
	            MTServer.available.release();
        	}
        }catch (IOException e) {
            e.printStackTrace();
        }
	}
}
        
