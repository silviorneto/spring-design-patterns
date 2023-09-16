package srn.springdesignpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Projeto Spring Boot gerado via Spring Initializr
 * Módulos:
 * - Spring Data JPA
 * - Spring Web
 * - H2 db
 * - OpenFeign
 */

@EnableFeignClients
@SpringBootApplication
public class SpringDesignPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDesignPatternsApplication.class, args);
	}

}
