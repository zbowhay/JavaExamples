// handles the threads that will be created in the WebServer.java file.
// THIS HANDLES ALL OF THE SERVER SHIT
// Meaning: That this will return the files to the client

import java.io.*;
import java.net.*;

public class ThreadRunner implements Runnable{
	private static Socket client;
	private static ServerSocket server;
	public ThreadRunner(){
		System.out.println("Base Constructor, use the one with a Socket param.");
	}
	public ThreadRunner(Socket c){
		client = c;
	}
	public void run(){
		System.out.println("Running...");
		BufferedReader in = null;
		PrintWriter out = null;
		DataOutputStream dos = null;
		try{
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
			dos = new DataOutputStream(client.getOutputStream());
		}catch(Exception e){
			e.printStackTrace();
		}
		boolean go = true;
		while(go){
			try{
				String incoming = in.readLine();
				String check = "C:/";
				System.out.println("Successfuly read line: " + incoming);
				if(incoming.equalsIgnoreCase(check)){
					out.println("HTTP/1.1 200 OK\r\n");
					out.flush();
					out.println("Content-type: text/html\r\n\r\n");
					out.flush();
					File file = new File("C:/Input.txt");
					sendFile(dos, file);
				}
				out.println("Echo> " + incoming);
				}catch(Exception e){
				System.out.println("No more incoming text. Now exiting...");
				go = false;
				e.printStackTrace();
			}
		}
	}
	// COULD NOT figure out the whole sending file through bytes thing.... the process would start
	// and then would get stuck running this method with no results.... maybe because i'm not using a
	// buffer...
	public void sendFile(DataOutputStream outStream, File f){
		try{
			byte[] buf = new byte[512];
			int length;
			System.out.println("Sending File...");
			// send number of files to client
			outStream.writeInt(1);
			outStream.flush();
			outStream.writeUTF("get");  
            outStream.writeLong(f.length());  
            outStream.flush();
            //send file name
            outStream.writeUTF(f.getName());
            //send file length
            outStream.writeLong(f.length());
            FileInputStream temp = new FileInputStream(f);
            while((length = temp.read(buf)) != -1){
            	outStream.write(buf,0,length);
            }
            outStream.flush();
		}catch(IOException e){
			System.out.println("sendFile Error.");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
