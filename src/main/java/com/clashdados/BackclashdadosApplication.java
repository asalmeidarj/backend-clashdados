package com.clashdados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BackclashdadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackclashdadosApplication.class, args);
	}
	
	@GetMapping("teste-conexao")
	public String testeConexao() {
		return "Servidor conectado";
	}

}
