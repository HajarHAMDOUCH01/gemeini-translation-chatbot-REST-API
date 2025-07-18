package rest.project.jakarta.hello;

import java.lang.reflect.Constructor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;

public class Message {

	private String text;
	private String sender;
	
	public Message() {
	    // Default constructor
	}


	public Message(String text, String sender) {
        this.text = text;
        this.sender = sender;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	 @JsonbTransient
	 public JSONObject getMessage(){
		JSONObject message = new JSONObject();
		message.put("sender", this.getSender());
		message.put("text", this.getText());
		return message;
	}
}