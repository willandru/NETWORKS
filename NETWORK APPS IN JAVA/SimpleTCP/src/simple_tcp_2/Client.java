package simple_tcp_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public Client() throws Exception {
		
		Socket socket = new Socket("localhost", 2020);
		System.out.println("Succsessful conection to the server.");
		
		// I/O streams
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		Scanner keyboard = new Scanner(System.in);
		
		// PROTOCOL
		String userNumber;
		while((in_socket.readLine()).startsWith("Guess")) {
			System.out.println("Server says Guess a number from 1 to 10 : ");
			
			int guessNumber = (int)(Math.random()*10+1);	
			System.out.println(guessNumber);
			out_socket.println(guessNumber);		
		}
		System.out.println("You got it¡");
		
		socket.close();
		System.out.println("Socket closed. ");
		
	}
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
