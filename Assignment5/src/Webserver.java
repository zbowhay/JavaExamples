// Webserver Main Method

import java.io.*;
import java.net.*;

public class Webserver {
	private static ServerSocket server;
	private static Socket clientSocket;
	public static void main(String[] args){
		try{
			server = new ServerSocket(8003, 10);
		}catch(Exception e){
			System.out.println("failed to initiate ServerSocket.");
		}
		BufferedReader in = null;
		PrintWriter out = null;
		ThreadRunner tr = null;
		while(true){
			try{
				clientSocket = server.accept();
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new PrintWriter(clientSocket.getOutputStream(),true);
				tr = new ThreadRunner(clientSocket);
				Thread t = new Thread(tr);
				t.start();
			}catch(Exception e){
				System.out.println("Error while establishing connections and thread.");
				e.printStackTrace();
			}
		}
	}
}
