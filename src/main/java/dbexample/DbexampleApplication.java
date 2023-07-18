package dbexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class DbexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbexampleApplication.class, args
		);
	}

}
