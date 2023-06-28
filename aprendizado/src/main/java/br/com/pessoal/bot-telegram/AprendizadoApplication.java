package br.com.pessoal.aprendizado;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AprendizadoApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(AprendizadoApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE); // Configura o modo do banner para exibir no console
		app.run(args);
	}

}
