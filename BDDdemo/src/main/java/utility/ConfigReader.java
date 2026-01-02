package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class ConfigReader {

	// Load properties once when the class is initialized
	private static final Properties props = new Properties();

	static {
		try (FileReader fr = new FileReader("./src/main/resources/config.properties")) {
			props.load(fr);
		} catch (FileNotFoundException e) {
			LoggerUtils.error("Config properties file not found: " + e.getMessage());
		} catch (IOException e) {
			LoggerUtils.error("Error reading config properties file: " + e.getMessage());
		}
	}

	public static String getPropertyValueByKey(String key) {
		// 2. read data

		String value = null;

		if (props.containsKey(key) == false) {
			try {
				throw new Exception("Key: " + key + " is not specified in properties file.");
			} catch (Exception e) {
				LoggerUtils.error("Could not fetch key -" + e);
			}
			return null;
		} else {
			value = props.get(key).toString();
			if (StringUtils.isEmpty(value)) {
				try {
					throw new Exception("Value is not specified for key: " + key + " in properties file.");
				} catch (Exception e) {
					LoggerUtils.error("Could not fetch value for provided key" + e);
				}
			}
			return value;
		}

	}

	public static String getBrowser() {
		LoggerUtils.info("Fetching browser name from config properties file.- " + getPropertyValueByKey("browser"));
		return getPropertyValueByKey("browser");

	}

	public static String getUrl() {
		LoggerUtils.info("Fetching application URL from config properties file.- " + getPropertyValueByKey("appURL"));
		return getPropertyValueByKey("appURL");
	}

	public static String getEmail() {
		LoggerUtils.info("Fetching email from config properties file.- " + getPropertyValueByKey("email"));
		return getPropertyValueByKey("username");
	}

	public static String getPassword() {
		LoggerUtils.info("Fetching password from config properties file.- " + getPropertyValueByKey("password"));
		return getPropertyValueByKey("password");
	}

	public static String getOperatingSystem() {
		LoggerUtils.info("Fetching OS from config properties file.- " + getPropertyValueByKey("os"));
		return getPropertyValueByKey("os");
	}

	public static String getexecution_environment() {
		LoggerUtils.info("Fetching execution environment from config properties file.- "
				+ getPropertyValueByKey("execution_environment"));
		return getPropertyValueByKey("execution_env");
	}
}
