package stanislaw.appdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan	// Allows to scan all classes to look for different declarations
public class AppdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppdemoApplication.class, args);
	}

}
