package shop.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import jakarta.persistence.EntityManagerFactory;
import shop.controller.ShopController;

import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;


@Configuration
@ComponentScan({"shop", "shop.model.entity", "shop.model.repository"})
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages ="shop.model.repository")
public class JpaConfig {

    Logger logger = Logger.getLogger(JpaConfig.class.getName());
    @Autowired
    private Environment env;

    public JpaConfig() {
        super();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        logger.log(Level.INFO, "DataSource log");
        dataSource.setDriverClassName(env.getProperty("jdbc.driver_class"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("shop");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        logger.log(Level.INFO, "entityManagerFactory log");
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        logger.log(Level.INFO, "entityManagerFactory log");
        return transactionManager;
    }
}
