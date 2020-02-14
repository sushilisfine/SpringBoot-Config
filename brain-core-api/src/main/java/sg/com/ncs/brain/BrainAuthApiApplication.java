package sg.com.ncs.brain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient 	
public class BrainAuthApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(BrainAuthApiApplication.class, args);
	}

}
