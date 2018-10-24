package com.lei.encrypt;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;

/**
 * 对数据库用户名和密码加密，所以还得有一个解密的过程
 * 
 * @author wujunbo
 *
 */
@Component
public class DataSourceProcess implements BeanPostProcessor {
	@Autowired
	private StringEncryptor encryptor;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof DataSourceProperties) {
			DataSourceProperties dataSourceProperties = (DataSourceProperties) bean;
			dataSourceProperties.setUsername(encryptor.decrypt(dataSourceProperties.getUsername()));
			dataSourceProperties.setPassword(encryptor.decrypt(dataSourceProperties.getPassword()));
			return dataSourceProperties;
		}
		return bean;
	}

}
