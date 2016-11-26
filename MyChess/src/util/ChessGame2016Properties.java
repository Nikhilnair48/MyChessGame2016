package util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ChessGame2016Properties {
	
	/*public static void main(String[] args) {
		ChessGame2016Properties prop = new ChessGame2016Properties();
		prop.loadProperties();
		System.out.println(ChessGame2016Properties.getProperty("test"));
	}*/
	
	private static HashMap<String, String> map;
	
	static {
		map = new HashMap<>();
		
		InputStream stream = null;	//config.properties
		Properties prop = new Properties();
		
		try {
			stream = ChessGame2016Properties.class.getClassLoader().getResourceAsStream("config.properties");
			if(stream != null)
				prop.load(stream);
			else
				System.out.println("The file does not have any contents.");
			
			Object[] keys = prop.keySet().toArray();
			for(int i = 0; i < keys.length; i++) {
				map.put(String.valueOf(keys[i]), String.valueOf(prop.get(keys[i])));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ChessGame2016Properties() { }
	
	public static String getProperty(String property) {
		return map.get(property);
	}
	
	/*public void loadProperties() {
		map = new HashMap<>();
		
		InputStream stream = null;	//config.properties
		Properties prop = new Properties();
		
		try {
			stream = getClass().getClassLoader().getResourceAsStream("config.properties");
			if(stream != null)
				prop.load(stream);
			else
				System.out.println("The file does not have any contents.");
			
			Object[] keys = prop.keySet().toArray();
			for(int i = 0; i < keys.length; i++) {
				map.put(String.valueOf(keys[i]), String.valueOf(prop.get(keys[i])));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
}