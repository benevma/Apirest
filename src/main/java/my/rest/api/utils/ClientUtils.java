package my.rest.api.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ClientUtils {
	
	
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
