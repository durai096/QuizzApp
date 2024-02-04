//package com.durai096.QuizeApp.JpaConfig;
//
//import javax.sql.DataSource;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//public class JpaConfig {
//	 @Autowired
//	    private DataSource dataSource;
//	 @Bean
//	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//	        em.setDataSource(dataSource);
//	        em.setPackagesToScan("com.durai096.QuizeApp.Model"); // Package where your JPA entities are located
//	        // Set JPA vendor adapter, persistence provider, and other properties
//
//	        return em;
//
//	    }
//	 @Bean
//	    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//	        JpaTransactionManager transactionManager = new JpaTransactionManager();
//	        transactionManager.setEntityManagerFactory(entityManagerFactory);
//	        return transactionManager;
//	    }
//	 @Bean
//	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//	        return new PersistenceExceptionTranslationPostProcessor();
//	    }
//
//
//}
