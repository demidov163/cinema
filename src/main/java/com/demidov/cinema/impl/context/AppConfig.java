package com.demidov.cinema.impl.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.demidov.cinema.impl")
@EnableJpaRepositories(basePackages = "com.demidov.cinema.impl.model.repositories")
@Import(value = ModelConfig.class)
public class AppConfig {

    /**
     *    TODO @Autowired
    private Environment env;
     */
    @Bean
    public DataSource setUpDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/cinema");
        ds.setUsername("demidov");
        ds.setPassword("demidov");
        return ds;
    }

    @Bean
    public JpaDialect setUpJpaDialect() {
         return new HibernateJpaDialect();
    }

    @Bean
    public JpaVendorAdapter setUpJpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL9Dialect");
        return jpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter jva, JpaDialect jd) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPersistenceXmlLocation("classpath:com/demidov/cinema/context/persistence.xml");
        bean.setPersistenceUnitName("com.demidov.cinema.impl.model.persistence.unit");
        bean.setDataSource(ds);
        bean.setJpaVendorAdapter(jva);
        bean.setJpaDialect(jd);
        return bean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf, DataSource ds, JpaDialect jpaDialect) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(emf);
        tm.setDataSource(ds);
        tm.setJpaDialect(jpaDialect);
        return tm;
    }



}
