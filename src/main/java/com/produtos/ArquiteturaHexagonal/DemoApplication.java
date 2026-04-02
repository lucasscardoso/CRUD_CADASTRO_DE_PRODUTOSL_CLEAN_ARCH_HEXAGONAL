package com.produtos.ArquiteturaHexagonal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = "com.produtos.ArquiteturaHexagonal")
@EnableFeignClients(basePackages = "com.produtos.ArquiteturaHexagonal.externals.interfaces")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
