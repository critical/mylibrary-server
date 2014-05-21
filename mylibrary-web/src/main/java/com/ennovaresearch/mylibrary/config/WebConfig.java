/**
 * 
 */
package com.ennovaresearch.mylibrary.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ennova
 *
 */
@Configuration
@ComponentScan({"com.ennovaresearch.mylibrary.web", "com.ennovaresearch.mylibrary.rest"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

}
