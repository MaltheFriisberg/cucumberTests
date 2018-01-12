package simulator;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import core.ApplicationUser;

public class MobilePhoneSimulator {
	//public static String endpoint = "http://localhost:8080/DTUPayExample/rest";
	{
		Unirest.setObjectMapper(new ObjectMapper() {
			private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

			public <T> T readValue(String value, Class<T> valueType) {
				try {
					return jacksonObjectMapper.readValue(value, valueType);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}

			public String writeValue(Object value) {
				try {
					return jacksonObjectMapper.writeValueAsString(value);
				} catch (JsonProcessingException e) {
					throw new RuntimeException(e);
				}
			}
		});
	}

	public int createAccount(ApplicationUser user) throws UnirestException {
		HttpResponse<String> r = Unirest.post("http://159.89.18.95:8080/burgerService/users").
				header("Content-Type", "application/json").body(user).asString();
		return r.getStatus();
	}

	public boolean accountExists(ApplicationUser user) throws UnirestException {
		HttpResponse<String> r = Unirest.get("http://159.89.18.95:8080/burgerService/users/"+user.getToken()).asString();
		
		return r.getStatus() == 200;
	}

}
