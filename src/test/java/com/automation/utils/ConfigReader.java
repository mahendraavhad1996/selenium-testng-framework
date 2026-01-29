package com.automation.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	// load config only once
	public static Properties loadProperties() {

		if (prop == null) {
			try {

				prop = new Properties();
				InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

				if (is == null) {
					throw new RuntimeException("config.properties not found");
				}

				prop.load(is);

			} catch (Exception e) {
				throw new RuntimeException("Failed to load config.properties", e);
			}
		}

		return prop;
	}

}
