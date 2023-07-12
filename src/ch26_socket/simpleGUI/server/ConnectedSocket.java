package ch26_socket.simpleGUI.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ch26_socket.simpleGUI.server.dto.RequestBodyDto;
import ch26_socket.simpleGUI.server.dto.SendMessage;
import ch26_socket.simpleGUI.server.entity.Room;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConnectedSocket extends Thread {

	private final Socket socket;
	private Gson gson = new Gson();
	
	private String username;
	
	@Override
	public void run() {
		gson = new Gson();
		
		while(true) {
			try {
				BufferedReader bufferedReader = 
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String requestBody = bufferedReader.readLine();
			
				requestController(requestBody);
				
//				SimpleGuiServer.connectedSocketList.forEach(connectedSocket -> {
//					try {
//						PrintWriter printWriter = 
//								new PrintWriter(connectedSocket.socket.getOutputStream(), true);
//						printWriter.println(requestBody);
//						
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				});
//				for(ConnectedSocket connectedSocket : SimpleGuiServer.connectedSocketList) {
//					
//				}
//				
//				for(int i = 0; i < SimpleGuiServer.connectedSocketList.size(); i++) {
//					
//				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void requestController(String requestBody) {
	
//		RequestBodyDto<?> requestBodyDto = gson.fromJson(requestBody, RequestBodyDto.class);
		
//		TypeToken<RequestBodyDto<SendMessage>> token = new TypeToken<RequestBodyDto<SendMessage>>() {};
//		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, new TypeToken<>( ) {}.getType());
		
//		toJson > map으로 변환 ?
		
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResource();
		
		switch (resource) {
			case "connection" : 
				connection(requestBody);
				break;
				
			case "createRoom" : 
				createRoom(requestBody);
				break;
				
			case "join" :
				join(requestBody);
				break;
				
			case "sendMessage" :
				sendMessage(requestBody);
				break;
				
			// .....
			case "exitRoom" : 
				exitRoom(requestBody);
				break;

			default:
				break;
		}
		
	}
	
	private void connection(String requestBody) {
		username = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		
		List<String> roomNameList = new ArrayList<>();
		
		SimpleGuiServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});
		
		RequestBodyDto<List<String>> updateRoomListRequestBodyDto =
				new RequestBodyDto<List<String>>("updateRoomList", roomNameList);

		ServerSender.getInstance().send(socket, updateRoomListRequestBodyDto);
	}
	
	private void createRoom(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		
		Room newRoom = Room.builder()
			.roomName(roomName)
			.owner(username)
			.userList(new ArrayList<ConnectedSocket>())
			.build();
		
		SimpleGuiServer.roomList.add(newRoom);
		
		List<String> roomNameList = new ArrayList<>();
		
		SimpleGuiServer.roomList.forEach(room -> {
			roomNameList.add(room.getRoomName());
		});
		
		RequestBodyDto<List<String>> updateRoomListRequestBodyDto =
				new RequestBodyDto<List<String>>("updateRoomList", roomNameList);
		
		SimpleGuiServer.connectedSocketList.forEach(con -> {	
									// 각각의 client socket에 뿌려줌
			ServerSender.getInstance().send(con.socket, updateRoomListRequestBodyDto);
		});
		
	}
	
	private void join(String requestBody) {
		String roomName = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
		
		SimpleGuiServer.roomList.forEach(room -> {
			if(room.getRoomName().equals(roomName)) {
				room.getUserList().add(this);
				List<String> usernameList = new ArrayList<>();
				
				room.getUserList().forEach(con -> {
					usernameList.add(con.username);
				});
				
				room.getUserList().forEach(connectedSocket -> {
					RequestBodyDto<List<String>> updateUserListDto = new RequestBodyDto<List<String>>("updateUserList", usernameList);
					RequestBodyDto<String> joinMessageDto = new RequestBodyDto<String>("showMessage", username + "님이 입장하셨습니다.");
					
					ServerSender.getInstance().send(connectedSocket.socket, updateUserListDto);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ServerSender.getInstance().send(connectedSocket.socket, joinMessageDto);					
				});
			}
		});
	}
	
	private void sendMessage(String requestBody) {
		TypeToken<RequestBodyDto<SendMessage>> typeToken = new TypeToken<>() {};
		
		RequestBodyDto<SendMessage> requestBodyDto = gson.fromJson(requestBody, typeToken.getType());
		SendMessage sendMessage = requestBodyDto.getBody();
		
		SimpleGuiServer.roomList.forEach(room -> {
			if(room.getUserList().contains(this)) {
				room.getUserList().forEach(connectedSocket -> {
				RequestBodyDto<String> dto = 
						new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() + ": " + sendMessage.getMessageBody());		
				ServerSender.getInstance().send(connectedSocket.socket, dto);				
				});		
			}
		});	
//		SimpleGuiServer.connectedSocketList.forEach(connectedSocket -> {
//			RequestBodyDto<String> dto = 
//					new RequestBodyDto<String>("showMessage", sendMessage.getFromUsername() + ": " + sendMessage.getMessageBody());		
//			ServerSender.getInstance().send(connectedSocket.socket, dto);				
//		});
	}
	
	// ......
	private void exitRoom(String requestBody) {
		
		SimpleGuiServer.roomList.forEach(room -> {
			if(room.getUserList().contains(this)) {
				room.getUserList().forEach(connectedSocket -> {
						if(connectedSocket == room.getUserList()) {
							room.getUserList().remove(connectedSocket);
						}			
					});		
			}
		});		
	}
	
}
