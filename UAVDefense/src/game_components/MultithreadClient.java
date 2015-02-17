package game_components;
import java.io.*;
import java.net.*;

public class MultithreadClient{
    public MultithreadClient()
    {

		 String hostname = "54.200.170.30";
         int port = 9001;
	
	     Socket clientSocket = null;//our client socket  
	     DataOutputStream os = null;//output stream
	     BufferedReader is = null;//input stream
	
	         // Initialization section:              
	     try
	     {
	         clientSocket = new Socket(hostname, port);
	         os = new DataOutputStream(clientSocket.getOutputStream());
	         is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	     }
	     catch (UnknownHostException e)
	     {
	         System.err.println("Don't know about host: " + hostname);
	     }
	     catch (IOException e)
	     {
	         System.err.println("Couldn't get I/O for the connection to: " + hostname);
	     }
	
	         //write data to socket
	         if (clientSocket == null || os == null || is == null)
	         {
	             System.err.println( "Something is wrong. One variable is null." );
	             return;
	         }
	
	         try
	         {
	             while (true)
	             {
	                         System.out.print( "Enter an integer (0 to stop connection, -1 to stop server): " );
	                         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	                         String keyboardInput = br.readLine();
	                         os.writeBytes( keyboardInput + "\n" );
	
	                         int n = Integer.parseInt(keyboardInput);
	                         if ( n == 0 || n == -1 )
	                             break;
	                         String responseLine = is.readLine();
	                         System.out.println("Server returns its square as: " + responseLine);
	             }
	
	             //clean up section
	             os.close();
	             is.close();
	             clientSocket.close();
	         }
	         catch (UnknownHostException e){
	        	 System.err.println("Trying to connect to unknown host: " + e);
	         }
	         catch (IOException e)
	         {
	        	 System.err.println("IOException:  " + e);
	         }
		
	}
 }

