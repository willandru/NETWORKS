package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public Client() throws Exception {
		
		Socket socket = new Socket("localhost", 2020);
		System.out.println("Succsessful conection to the server.");
		
		// I/O reader
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		
		// PROTOCOL
		String message = in_socket.readLine();
		System.out.println("Server says: "+ message);
		out_socket.println("Thanks");
		
		socket.close();
		System.out.println("Socket closed.");
		
	}
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
