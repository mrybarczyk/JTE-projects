package pl.ug.javaeeproject;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaEeProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(JavaEeProjectApplication.class, args);
		System.out.println(ctx.getBean(Dom.Drzwi.class).getKolor());
		System.out.println(ctx.getBean(Dom.Okno.class).getSize());
        ctx.close();
	}

}
