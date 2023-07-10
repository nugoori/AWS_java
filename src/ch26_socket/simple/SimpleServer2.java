package ch26_socket.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer2 {

	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			Socket socket = serverSocket.accept();
			
			Thread thread = new Thread(() -> {
				while(true) {
					BufferedReader bufferedReader;
					
					try {
						InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
						bufferedReader = new BufferedReader(inputStreamReader);
						System.out.println(bufferedReader.readLine());
						
					} catch (IOException e) {
						e.printStackTrace();
					}		
				}
				
			});
			
			thread.start();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
