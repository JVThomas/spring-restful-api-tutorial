package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SprngBootApplication adds the following
//	@Configuration: tags the class as a source of bean definitions for app context
//	@EnableAutoConfiguration: tells Spring Boot to add beans based on classPath settings,
//							  other beans, and property settings
//  @EnableWebMvc: normally would add this, however Spring Boot adds it when it sees spring-webmvc
//				   on classPath
//	@ComponentScan: tells Spring to look for services, configurationss, and components within
//					the 'hello' package, allowing it to find the controllers.
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run() used to launch application
		SpringApplication.run(Application.class, args);
	}
}

//side notes : if using Gradle, you can just run ./gradlew bootRun on command line
// 			   Other option: ./gradlew build to build jar file, then run jar file as:
//							      java -jar build/libs/gs-rest-service-0.1.0.jar
