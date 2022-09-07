package com.uce.edu.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.IProductoService;

@SpringBootApplication
public class PruebaUnidad4CaApplication{
	

	@Autowired
	private IProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad4CaApplication.class, args);

	}


}
