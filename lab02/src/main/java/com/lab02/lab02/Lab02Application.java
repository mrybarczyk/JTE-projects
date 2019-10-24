package com.lab02.lab02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Lab02Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab02Application.class, args);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(Dom.Config.class);
		ctx.refresh();

		Dom.Okno wschod = ctx.getBean(Dom.Okno.class);
		Dom.Drzwi wejscie = ctx.getBean(Dom.Drzwi.class);
		//Dom.Okno wschod = new Dom.Okno(60,90);
		//Dom.Drzwi wejscie = new Dom.Drzwi("Czerwony");
		Dom szyszkowa = new Dom(wschod, wejscie);
		ctx.close();
	}

}

