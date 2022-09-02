package ru.deevdenis.flowershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.deevdenis.flowershop.config", "ru.deevdenis.flowershop.controllers","ru.deevdenis.flowershop.DAO","ru.deevdenis.flowershop.servises",})
public class FlowershopApplication {
	public static void main(String[] args) {
		SpringApplication.run(FlowershopApplication.class, args);
	}

}
