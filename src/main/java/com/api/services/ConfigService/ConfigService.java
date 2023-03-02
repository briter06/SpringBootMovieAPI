package com.api.services.ConfigService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ConfigService implements IConfigService{
	
	Logger logger = LoggerFactory.getLogger(ConfigService.class);
	
	private Environment env;
	private AppConfig appConfig;
	
	public ConfigService(Environment env) {
		this.env = env;
		this.appConfig = new AppConfig();
	}
	
	public AppConfig getAppConfig() {
		return this.appConfig;
	}
	
	public void initEnvironment() {
		appConfig.randomDataApiUrl = this.getStringProperty("api.random-data.url");
		logger.info("Properties validated");
	}
	
	private String getStringProperty(String propertyId) {
		String result = this.env.getProperty(propertyId);
		if(!(result != null && !result.isEmpty())) {
			throw new RuntimeException(String.format("Invalid property %s", propertyId));
		}
		logger.info(String.format("Property %s validated", propertyId));
		return result;
	}
	
}
