package commonutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtils {

	public String getDataFromPropertyFile(String Key) throws IOException {
		
         FileInputStream fis=new FileInputStream("src\\test\\resources\\vtigerData.properties");
		 
		 Properties p=new Properties();
		 p.load(fis);
		 String value=p.getProperty(Key);
		 return value;
	
	}

}
