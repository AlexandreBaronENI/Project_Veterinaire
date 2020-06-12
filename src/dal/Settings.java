package dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {

	private static Properties properties;	
	
	static {
		properties = new Properties();
		try {
			properties.load(Settings.class.getResourceAsStream("database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProPerty(String key) {
		return properties.getProperty(key);
	}

}
