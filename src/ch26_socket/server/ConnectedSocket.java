package ch26_socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {
	
	private final Socket socket;
	
	@Override
	public void run() {
		BufferedReader bufferedReader = null;
											/* 클라 소캣에서 받은 인풋을 서버소켓에서 받음? */
		try {
			while(true) {
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
				System.out.println("입력 데이터: " + requestBody);
			}
		
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}

}
