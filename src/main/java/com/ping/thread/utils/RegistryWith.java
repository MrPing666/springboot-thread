package com.ping.thread.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@Service
public class RegistryWith extends Registry {

	/**
	 * 当前容器
	 */
	private static List<ApplicationContext> acList = new ArrayList<ApplicationContext>();

	private static Map<String, String> properties = new HashMap<String, String>();
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private ApplicationContext ac;
	
//	@Resource
//	private MyPlaceholderConfigurer mc;

	@PostConstruct
	public void init() {
		acList.add(ac);
		Registry.setInstance(this);
		
//		try {
//			initProperites();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

//	private void initProperites() throws IOException {
//		Properties props = mc.getProperties();
//		setProperties((Map)props);
//	}

	public void setProperties(Map<String, String> p) {
		properties.putAll(p);
	}

	public <T> T getBean(Class<T> t) {
		T superBean = super.getBean(t);
		if (superBean != null) {
			return superBean;
		}

		for (ApplicationContext ac : acList) {
			T bean = ac.getBean(t);
			if (bean != null) {
				return bean;
			}
		}

		return null;
	}

	@Override
	public String getProperty(String name) {
		return properties.get(name);
	}

}
