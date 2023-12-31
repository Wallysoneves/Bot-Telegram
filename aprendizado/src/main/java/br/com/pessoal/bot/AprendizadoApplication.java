package br.com.pessoal.bot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableCaching
@EnableFeignClients
public class AprendizadoApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(AprendizadoApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}

}
