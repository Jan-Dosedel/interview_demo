package cz.interview.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"cz.interview.demo.*"})
public class AppConfiguration {

}
