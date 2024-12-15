package com.cesar.ebac_md_33;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbacMd33Application {

	public static void main(String[] args) {
		SpringApplication.run(EbacMd33Application.class, args);
	}

	@Bean
	public CommandLineRunner run(SalvarDados salvarDados) {
		return args -> {
			salvarDados.salvarDados();
		};
	}

}
