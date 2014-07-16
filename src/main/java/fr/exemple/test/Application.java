package fr.exemple.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import fr.exemple.test.model.repository.global.MyRepositoryFactoryBean;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableMongoRepositories(
		basePackages = {"fr.exemple.test"},
		repositoryFactoryBeanClass = MyRepositoryFactoryBean.class
)
public class Application {

    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(Application.class);
    	app.setShowBanner(false);
    	app.run(args);
    }
}
