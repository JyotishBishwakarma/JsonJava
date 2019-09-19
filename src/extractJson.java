import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class extractJson {
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper o=new ObjectMapper();
		CustomerDetailsAppium ca=o.readValue("E:\\workspace2\\JsonJava\\customerInfo0.json", CustomerDetailsAppium.class);
		ca.getStudentName();
		
	}

}
