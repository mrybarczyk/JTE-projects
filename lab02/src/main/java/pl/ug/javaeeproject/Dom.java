package pl.ug.javaeeproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Dom {
	private Okno okno;
	private Drzwi drzwi;

	public Dom(@Autowired Okno okno, @Autowired Drzwi drzwi){
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

		public Drzwi() {}

		public Drzwi(String kolor){
			this.kolor = "Czarny";
		}

		public String getKolor() {
			return kolor;
		}

	}
}

