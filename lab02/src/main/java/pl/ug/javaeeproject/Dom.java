package pl.ug.javaeeproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Dom {
	@Autowired
	private Okno okno;
	@Autowired
	private Drzwi drzwi;

	public static class Okno {
		private int wysokosc;
		private int szerokosc;


		public Okno(int wysokosc, int szerokosc){
			this.wysokosc = wysokosc;
			this.szerokosc = szerokosc;
		}

		public String getSize() {
			String h = String.valueOf(wysokosc);
			String w = String.valueOf(szerokosc);
			String wymiar = String.join(" x ", h, w);
			return wymiar;
		}
	}

	public static class Drzwi {
		private String kolor;

		public Drzwi(String kolor){
			this.kolor = "Czarny";
		}

		public String getKolor() {
			return kolor;
		}

	}
}

