
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

public class ClientWorkerThread extends Thread {

	String hostname = null;
	int portnumber = -1;
	
	public ClientWorkerThread(String hostname, int portnumber) {
		this.hostname = hostname;
		this.portnumber = portnumber;
	}	

	public void run() {
        try {
	        	
	        	if (BenchmarkClient.available.tryAcquire()){
	        	
		        	Socket clientSocket = new Socket(hostname, portnumber);
		        	PrintStream out = new PrintStream(clientSocket.getOutputStream(), true);
		        	Scanner in = new Scanner(clientSocket.getInputStream());
		        	out.println("hello world");
		            while (in.hasNextLine()){
		            	
			    	
			    		
				    	if (in.nextLine().equals("HELLO WORLD")){
				    		BenchmarkClient.count++;
				    		//BenchmarkClient.count.incrementAndGet();
					    }
		
		            }
		            
				    in.close();
				    out.close();
				    clientSocket.close();
		            BenchmarkClient.available.release();
	        	}
	        	
        }     
            catch (IOException e) {
            e.printStackTrace();
        }
	

	}
}
        
