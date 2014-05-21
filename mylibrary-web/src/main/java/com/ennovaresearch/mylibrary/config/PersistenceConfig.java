/**
 * 
 */
package com.ennovaresearch.mylibrary.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Fabio Gomiero
 * 
 */
@Configuration
@EnableTransactionManagement
@ImportResource("classpath*:*persistenceConfig.xml")
@ComponentScan({ "com.ennovaresearch.mylibrary.service" })
@PropertySource({ "classpath:persistence-hsqldb.properties" })
public class PersistenceConfig {

	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jpa.generateDdl}")
	boolean jpaGenerateDdl;

	// Hibernate specific
	@Value("${hibernate.dialect}")
	String hibernateDialect;
	@Value("${hibernate.show_sql}")
	boolean hibernateShowSql;
	@Value("${hibernate.hbm2ddl.auto}")
	String hibernateHbm2ddlAuto;

	@Value("${jdbc.username}")
	private String jdbcUsername;
	@Value("${jdbc.password}")
	private String jdbcPassword;

	/**
	 * 
	 */
	public PersistenceConfig() {

	}

	/**
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(myDataSource());
		factoryBean.setPackagesToScan(new String[] { "com.ennovaresearch.mylibrary.model" });

		final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter() {
			{
				// setDatabase( Database.H2 ); // TODO: is this necessary
				setDatabasePlatform(hibernateDialect);
				setShowSql(hibernateShowSql);
				setGenerateDdl(jpaGenerateDdl);
			}
		};
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setJpaProperties(additionlProperties());
		return factoryBean;
	}

	/**
	 * @return
	 */
	@Bean
	public DataSource myDataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(jdbcUsername);
		dataSource.setPassword(jdbcPassword);
		return dataSource;
	}

	/**
	 * @return
	 */
	@Bean
	public JpaTransactionManager transactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}

	/**
	 * @return
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * @return
	 */
	final Properties additionlProperties() {
		return new Properties() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -7709017642658752416L;

			{
				// use this to inject additional properties in the EntityManager
				setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
				setProperty("hibernate.ejb.naming_strategy", org.hibernate.cfg.ImprovedNamingStrategy.class.getName());
			}
		};
	}
}
