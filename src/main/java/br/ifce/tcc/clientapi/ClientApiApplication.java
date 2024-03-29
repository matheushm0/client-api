package br.ifce.tcc.clientapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApiApplication.class, args);
	}

}
