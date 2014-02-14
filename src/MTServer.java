/* Clifford Roberson
 * Networks homework 1
 * 
 * 
 * With help from: http://www.javaworld.com/article/2077322/core-java/sockets-programming-in-java-a-tutorial.html
 * http://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
 * http://stackoverflow.com/questions/2187626/how-to-create-a-basic-java-server
 */

import java.net.*;
import java.util.concurrent.Semaphore;
import java.io.*;

public class MTServer{
	public static Semaphore available = new Semaphore(10000, true);
	public static void main(String[] args) throws IOException, InterruptedException {

    	int portNumber = 7777;//Integer.parseInt(args[0]);
    	
    	ServerSocket serverSocket= new ServerSocket(portNumber);
    	try {
    		while (true){
    			//System.out.println(available.getQueueLength());
    			
    			
    			Socket clientSocket = serverSocket.accept();
            	new ServerWorkerThread(clientSocket).start();
            	
    		}
        } catch (IOException e) {
        	e.printStackTrace();
        }            
	
	}
}