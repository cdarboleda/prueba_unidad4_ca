package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	//Metodos de redireccionamiento a paginas
	@GetMapping("/nuevoProducto")
	public String paginaNuevaProducto(Producto producto) {
		return "vistaNuevoProducto";
	}
	
	@PostMapping("/insertar")
	public String insertarProducto(Producto producto) {
		this.productoService.ingresarProducto(producto);
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String inicio() {
		return "vistaInicio";
	}
	
	@GetMapping("/consultarStock/{codigoBarras}")
	public String consultarStock(@PathVariable("codigoBarras") String codigoBarras, Model modelo) {
		Producto producto = this.productoService.consultarStock(codigoBarras);
		modelo.addAttribute("producto", producto);
		return "vistaStockProducto";
	}

}
