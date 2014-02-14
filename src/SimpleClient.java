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

public class SimpleClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String hostName = args[0];
		
		int portNumber = 7777;//Integer.parseInt(args[1]);

		try {
		    Socket echoSocket = new Socket(hostName, portNumber);
		    PrintStream out = new PrintStream(echoSocket.getOutputStream(), true);
		    
		    Scanner in = new Scanner(echoSocket.getInputStream());
		    /*
		    BufferedReader stdIn =
		        new BufferedReader(
		            new InputStreamReader(System.in));
		    */
		    
		    out.println("hello world");
		    System.out.println(in.nextLine());
		    
		    
		    /*
		    String userInput;
		    String returnedOutput;
			
		    while ((userInput = stdIn.readLine()) != null) {
		    	out.println(userInput);
		    	returnedOutput = in.readLine();
		    	while (!returnedOutput.equalsIgnoreCase("foobar")){
			    	System.out.println(returnedOutput);
			    	returnedOutput = in.readLine();
			    }
		    	System.out.println("Server is at " + echoSocket.getInetAddress());
		    	
			}
			*/
		    echoSocket.close();
		    in.close();
		    out.close();
		    
		}	catch (IOException e) {
            System.err.println("???");
            System.exit(1);
        }
		
	}
}





