package pl.edu.ug.tent.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwebApplication.class, args);
	}

}
