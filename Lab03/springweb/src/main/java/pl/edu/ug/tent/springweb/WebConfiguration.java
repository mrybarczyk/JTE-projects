package pl.edu.ug.tent.springweb;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

  @Bean
  public ServletRegistrationBean servletRegistrationHelloBean(){

    return  new ServletRegistrationBean(new HelloServlet(), "/calc");
  }

}
