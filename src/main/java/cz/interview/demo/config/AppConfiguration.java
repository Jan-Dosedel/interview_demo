package cz.interview.demo.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"cz.interview.demo.*"})
public class AppConfiguration {

  @Bean
  public DozerBeanMapper dozerBeanMapper(){
    return new DozerBeanMapper();
  }

}
