package org.bizhunt.vendor.web;

import org.apache.wicket.protocol.ws.api.message.IWebSocketPushMessage;

public class ChatMessageEvent implements IWebSocketPushMessage{
	
	private static final long serialVersionUID = -4938778930894651868L;
	private String message;

	public ChatMessageEvent(String message){
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
