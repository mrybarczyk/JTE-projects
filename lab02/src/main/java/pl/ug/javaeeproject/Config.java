package pl.ug.javaeeproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Dom.class)
public class Config {
    @Bean
    public Dom.Okno getOkno() {
        return new Dom.Okno(90, 30);
    }

    @Bean
    public Dom.Drzwi getDrzwi(){
        return new Dom.Drzwi("Czarny");
    }

}
