package br.com.funcionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.EnableKafka;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@EnableEurekaClient
@EnableKafka
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Funcionario API", version = "v1"),
servers = {@Server(url= "http://localhost:8080")},
tags = {@Tag(name = "Fncionario", description = "API Documentation")}
)
public class FuncionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncionarioApplication.class, args);
	}

}
