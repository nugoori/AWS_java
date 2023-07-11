package ch26_socket.simpleGUI.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;

public class ClientReceiver extends Thread{
	
	// private final Socket socket; > client에서 receiver를 생성할 때 socket을 매개변수로 받아오는게 아니라
	// client를 싱글톤패턴으로 만들어서 생성한 client객체를 getInstance로 가져와서 그 client의 getter로 socket을 가져옴
	
	@Override
	public void run() {
		SimpleGUIClient simpleGUIClient = SimpleGUIClient.getInstance();
		while (true) {
			try {
				BufferedReader bufferedReader =
						new BufferedReader(new InputStreamReader(simpleGUIClient.getSocket().getInputStream()));
				String requestBody = bufferedReader.readLine();
				
				requestController(requestBody);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}		
	}
	
	private void requestController(String requestBody) {
		Gson gson = new Gson();
		
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch(resource) {
		
			case "showMessage":
				String messageContent = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getTextArea().append(messageContent + "\n");
				
				break;
			
			case "updateUserList" : 
				List<String> usernameList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
				SimpleGUIClient.getInstance().getUserListModel().clear();
				SimpleGUIClient.getInstance().getUserListModel().addAll(usernameList);;
				
				break;
		}
	}
	
}
