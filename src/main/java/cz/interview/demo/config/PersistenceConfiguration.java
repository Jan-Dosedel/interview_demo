package cz.interview.demo.config;

import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("cz.interview.demo.dao")
public class PersistenceConfiguration {

  private static final String PERSISTENCE_UNIT_NAME = "hibernateJpaPU";
  private static final String ENTITY_PACKAGE = "cz.interview.demo.service.domain.entity";

  // DB config
  @Value("${database.host:localhost}")
  private String dbHost;
  @Value("${database.port:3306}")
  private String dbPort;
  @Value("${database.name:demo_app}")
  private String dbName;
  @Value("${database.connectionString:jdbc:mysql://%s:%s/%s?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false}")
  private String connectionString;
  // Hibernate config
  @Value("${hibernate.ddl:none}")
  private String hibernateDdl;
  @Value("${hibernate.dialect:org.hibernate.dialect.MySQL8Dialect}")
  private String hibernateDialect;
  @Value("${hibernate.import:/scripts/import.sql}")
  private String hibernateImport;


  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSourceSql());
    em.setPackagesToScan(ENTITY_PACKAGE);
    em.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    em.setJpaProperties(additionalProperties());
    return em;
  }

  @Bean(name = "dataSourceSql")
  public DriverManagerDataSource dataSourceSql() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl(getConnectionString());
    dataSource.setDriverClassName("org.h2.Driver");
    // FIXME move to password file
    dataSource.setUsername("root");
    dataSource.setPassword("admin");
    return dataSource;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  private Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", this.hibernateDdl);
    properties.setProperty("hibernate.dialect", this.hibernateDialect);
    properties.put("hibernate.show_sql", "true");
    properties.put("hibernate.hbm2ddl.import_files", this.hibernateImport);
    return properties;
  }

  private String getConnectionString() {
    return String.format(this.connectionString, this.dbHost, this.dbPort, this.dbName);
  }
}
