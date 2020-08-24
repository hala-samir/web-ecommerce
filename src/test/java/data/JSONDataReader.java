package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONDataReader {
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	public void JsonReader() throws FileNotFoundException, IOException, ParseException 
	{
		String filePath= System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.json";
		File srcFile= new File(filePath);
		JSONParser parser= new JSONParser();
		JSONArray jArray=(JSONArray)parser.parse(new FileReader(srcFile));
		for(Object jsonObj: jArray)
		{
			JSONObject person=(JSONObject)jsonObj; 
			firstName=(String) person.get("firstName");
			System.out.println(firstName);
			lastName=(String) person.get("lastName");
			System.out.println(lastName);
			email=(String) person.get("mail");
			System.out.println(email);
			password=(String) person.get("password");
			System.out.println(password);
		}


	}

}
