import java.io.*;
import java.net.*;

class DatabaseReceiver
{
   public static void main(String argv[]) throws Exception
      {
         String clientSentence;
         String capitalizedSentence;
         ServerSocket welcomeSocket = new ServerSocket(65051);

         while(true)
         {
            Socket connectionSocket = welcomeSocket.accept();
		System.out.println(connectionSocket.getPort());
            BufferedReader inFromClient =
               new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
	String[] split = clientSentence.split(" ");

	table_operations.insert_motion_entry(split[1],
	split[3] + " " +  split[4] + " " + split[5] + " " +
	split[6] + " " +  split[7] + " " + split[8] + " " +
	split[9] + " " +  split[10] + " " + split[11], 
	split[2]);
	System.out.println("Success");
            System.out.println("Received: " + clientSentence);
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);
         }
      }
}
