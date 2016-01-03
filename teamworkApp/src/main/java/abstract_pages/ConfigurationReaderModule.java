package abstract_pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReaderModule {

	private static ConfigurationReaderModule INSTANCE = new ConfigurationReaderModule();
	
	private Properties webDriverProperties;
	
	private ConfigurationReaderModule() {
		super();
		webDriverProperties = new Properties();
	}
	
	public void readFileFromProperties() {
		try {
			FileInputStream fis = new FileInputStream("/tmp/webDriverProperties.txt");
			webDriverProperties.load(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writePropertiesToFile() {
		try {
			FileOutputStream fos = new FileOutputStream("/tmp/webDriverProperties.txt");
			webDriverProperties.store(fos, "properties");
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConfigurationReaderModule getInstance() {
		return INSTANCE;
	}
	
	public void setUrl(String url) {
		webDriverProperties.setProperty("url", url);
	}
	
	public void setUserName(String userName) {
		webDriverProperties.setProperty("userName", userName);
	}
	
	public void setPassword(String password) {
		webDriverProperties.setProperty("password", password);
	}
	
	public String getUrl() {
		return webDriverProperties.getProperty("url");
	}
	
	public String getUserName() {
		return webDriverProperties.getProperty("userName");
	}
	public String getPassword() {
		return webDriverProperties.getProperty("password");
	}
	
}
