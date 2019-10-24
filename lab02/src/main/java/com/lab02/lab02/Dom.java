package com.lab02.lab02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Dom {
	private Okno okno;
	private Drzwi drzwi;

	public Dom(Okno okno, Drzwi drzwi){
		this.okno = okno;
		this.drzwi = drzwi;
	}

	public static class Okno {
		private int wysokosc;
		private int szerokosc;

		public Okno(int wysokosc, int szerokosc){
			this.wysokosc = wysokosc;
			this.szerokosc = szerokosc;
		}
	}

	public static class Drzwi {
		private String kolor;

		@Autowired
		public Drzwi(String kolor){
			this.kolor = "Czarny";
		}

		//public Drzwi(String kolor){
		//	this.kolor = kolor;
		//}
	}

	@Configuration
	@ComponentScan(basePackageClasses = Dom.class)
	public class Config {
		@Bean
		public Okno getOkno() {
			return new Okno(90, 30);
		}

		@Bean
		public Drzwi getDrzwi(){
			return new Drzwi("Czarny");
		}

	}
}
