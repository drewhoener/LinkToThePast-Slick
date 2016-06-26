package me.rockerjman222.lttp.input;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	private Properties properties = new Properties();

	public void saveProperty(String title, String value) {
		try {
			this.properties.setProperty(title, value);
			this.properties.store(new FileOutputStream("Config.txt"), null);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
