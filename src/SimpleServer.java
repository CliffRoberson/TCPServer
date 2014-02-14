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

public class SimpleServer {
    public static void main(String[] args) throws IOException {

	    	int portNumber = 7777;//Integer.parseInt(args[0]);
	        ServerSocket serverSocket = new ServerSocket(portNumber);
	        try {
	        	
     	
		        while (true){
		        	
		        	Socket clientSocket = serverSocket.accept();
		        	
		        	PrintStream out = new PrintStream(clientSocket.getOutputStream(), true);
			        Scanner in = new Scanner(clientSocket.getInputStream());
			        
			  
			        out.println(in.nextLine().toUpperCase());
			        //out.println("You are at " + clientSocket.getInetAddress());
			        
			        out.close();
			 	    in.close();
			 	    clientSocket.close();
			        
		        }
		        
		     } catch (IOException e) {
		        System.err.println("IO exception");
		        System.exit(1);
		     } 
    
  	}
        
}