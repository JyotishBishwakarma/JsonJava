import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;



public class jsonToJava {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=null;
		conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "Happy123#");
		
		//object of statement class will help to execute queries
		
		Statement st=conn.createStatement();
		ResultSet rs= st.executeQuery("select * from CustomerInfo where Location ='Asia';");
		ArrayList<CustomerDetails> a = new ArrayList<CustomerDetails>();
		ObjectMapper o=new ObjectMapper();
		JSONArray ja=new JSONArray();
		
		while(rs.next()) {
			CustomerDetails c=new CustomerDetails();
			c.setCourseName(rs.getString(1));
			c.setPurchasedDate(rs.getString(2));
			c.setAmount(rs.getInt(3));
			c.setLocation(rs.getString(4));
			a.add(c);
		}
		
		
		//o.writeValue(new File("E:\\workspace2\\JsonJava\\customerInfo.json"), a);
		
		for(int i=0;i<a.size();i++) {
			//o.writeValue(new File("E:\\workspace2\\JsonJava\\customerInfo"+i+".json"), a.get(i));
			
			//Create json string from Java object using GSON
			Gson g=new Gson();
			String jsonString = g.toJson(a.get(i));
			ja.add(jsonString);
			
		}
		
		//JSON Simple
		JSONObject jo=new JSONObject();
		jo.put("data", ja);   //creating JSON Array
		System.out.println(jo.toJSONString());
		String unescapeString = StringEscapeUtils.unescapeJava(jo.toJSONString());
		System.out.println(unescapeString);
		
		String string1 = unescapeString.replace("\"{", "{");
		String finalString= string1.replace("}\"", "}");
		System.out.println(finalString);
		
		try(FileWriter file = new FileWriter("E:\\workspace2\\JsonJava\\SingleJson.json")){
			file.write(finalString);
		}
		
		
		conn.close();
		
	}

}
