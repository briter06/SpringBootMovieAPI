package com.api.services.ConfigService;

public interface IConfigService {
	AppConfig getAppConfig();
	void initEnvironment();
}
