import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


public class BenchmarkClient {
	
	public static Semaphore available = new Semaphore(2, true)	;
	//public static AtomicInteger count = new AtomicInteger(0);
	public static int count = 0;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		String hostName = args[0];
		int portNumber = 7777;//Integer.parseInt(args[1]);

		long duration = 0;
		long startTime = System.nanoTime();
		long waitTime = 60;//number of seconds to sample

		//multithreaded
		
		while (duration < (waitTime * 1000000000)) {
   
			new ClientWorkerThread(hostName, portNumber).start();
			
			long endTime = System.nanoTime();

		    duration = endTime - startTime;
		    //System.out.println(BenchmarkClient.count.get());
		}
		
		
		//single threaded
		
//		try {
//		while (duration < (waitTime * 1000000000)) {
//			
//		    
//			Socket clientSocket = new Socket(hostName, portNumber);
//        	PrintStream out = new PrintStream(clientSocket.getOutputStream(), true);
//        	Scanner in = new Scanner(clientSocket.getInputStream());
//        	out.println("hello world");
//            while (in.hasNextLine()){
//            	
//	    	
//	    		
//		    	if (in.nextLine().equals("HELLO WORLD")){
//		    		BenchmarkClient.count++;
//		    		//BenchmarkClient.count.incrementAndGet();
//			    }
//
//            }
//            
//		    in.close();
//		    out.close();
//            clientSocket.close();
//			
//			long endTime = System.nanoTime();
//
//		    duration = endTime - startTime;
//		    //System.out.println(count);
//		    //Thread.sleep(10);
//		} 
//		} catch (IOException e) {
//        e.printStackTrace();
//		}
		
   
		System.out.println("Number Of requests serviced in " + waitTime + " seconds = " + count);//count.get());
	}
}

		
