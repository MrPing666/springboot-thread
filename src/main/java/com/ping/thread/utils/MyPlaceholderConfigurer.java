package com.ping.thread.utils;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import java.io.IOException;
import java.util.Properties;

public class MyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	public Properties getProperties() throws IOException {
		Properties properties = super.mergeProperties();
		PropertyUtil.init(properties);
		return properties;
	}
	
}
