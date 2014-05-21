/**
 * 
 */
package com.ennovaresearch.mylibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Fabio Gomiero
 *
 */
@Configuration
@ImportResource("classpath*:contextConfig.xml")
@ComponentScan({"com.ennovaresearch.mylibrary.model"})
public class ContextConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
