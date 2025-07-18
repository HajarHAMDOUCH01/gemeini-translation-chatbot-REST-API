package rest.project.jakarta.hello;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import swiss.ameri.gemini.api.Content;
import swiss.ameri.gemini.api.GenAi;
import swiss.ameri.gemini.api.GenerativeModel;
import swiss.ameri.gemini.api.ModelVariant;
import swiss.ameri.gemini.gson.GsonJsonParser;


@Path("translate")
public class Translate {

	@POST
	@Path("test")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Message translate(Message message) throws InterruptedException, ExecutionException, TimeoutException {
		swiss.ameri.gemini.spi.JsonParser parser = new GsonJsonParser();
		String apiKey = "YOUR GEMINI API_KEY";
		GenAi genAi = new GenAi(apiKey,parser);
		String text = message.getText();
		String sender = message.getSender();
		var model = GenerativeModel.builder()
		    .modelName(ModelVariant.GEMINI_1_5_PRO)
		    .addContent(new Content.TextContent(
		            Content.Role.USER.roleName(),
		            "Translate the following text into Moroccan Darija only, without mentioning the detected language, explanations, or anything else, plus don't give many options of the translated text , choose only one: " + text
		    ))
		    .build();

	    var responseText = genAi.generateContent(model).get(40, TimeUnit.SECONDS).text().replace("\n", "");

		return new Message(responseText, "gemini"); 
	}
}
