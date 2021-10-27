package simple_tcp_wireshark;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() throws Exception{
		
		ServerSocket server_socket= new ServerSocket(2020);// OPening a new port
		System.out.println("Port 2020 has been opened.");
			
		Socket socket =  server_socket.accept();
		System.out.println("Client "+ socket.getInetAddress()+" has connected" );
		
		// I/O buffers
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		out_socket.println("Welcome!"); //Send welcome to the client
		String message= in_socket.readLine();
		System.out.println("Client says: "+ message);
		
		//COMUNICATION IS OVER
		socket.close();
		System.out.println("Socket is closed");
	}
	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
