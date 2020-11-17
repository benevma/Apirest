package my.rest.api.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;


public class ClientUtils {
	
	
	/**
	 * Return object T from CLientResponse
	 * @param response
	 * @param clazz
	 * @return
	 */
	public static <T> T getObjectFromResponse(ClientResponse response, Class<T> clazz) {
		try {
			InputStream stream = response.getEntityInputStream();
			StringBuilder textBuilder = new StringBuilder();
			Reader reader = new BufferedReader(
					new InputStreamReader(stream, Charset.forName(StandardCharsets.UTF_8.name())));
			int c = 0;
			while ((c = reader.read()) != -1) {
				textBuilder.append((char) c);
			}
			return getObjectFromJsonString(textBuilder.toString(), clazz);
		} catch (IOException e) {
			return null;
		}
	}
	
	/**
	 * geto obj from json string
	 * 
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> T getObjectFromJsonString(String jsonString, Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

		try {
			if (jsonString != null) {
				jsonString = jsonString.replace("<", "&lt;");
				jsonString = jsonString.replace(">", "&gt;");
				return mapper.readValue(jsonString, clazz);
			}
		} catch (JsonParseException e) {
			return null;
		} catch (JsonMappingException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		return null;
	}
	
	/**
	 * get json String from input object
	 * 
	 * @param input
	 * @return
	 */
	public static String getJsonFromJavaObj(Object input) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		
		String output = null;
		try {
			output = mapper.writeValueAsString(input);
			if (output != null) {
				output = output.replace("&lt;", "<");
				output = output.replace("&gt;", ">");
			}
		} catch (JsonProcessingException e) {
			return null;
		}

		return output;
	}
}
