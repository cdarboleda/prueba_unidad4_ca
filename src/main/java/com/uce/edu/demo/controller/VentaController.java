package com.uce.edu.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.VentaReporte;
import com.uce.edu.demo.service.IVentaService;

@Controller
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	private IVentaService ventaService;
	
    // GET
    @GetMapping("/buscar/{fecha}/{categoria}/{cantidad}")
    public String buscarTodos(
    		@DateTimeFormat(pattern="yyyy-MM-dd") LocalDateTime fecha,
    		@PathVariable("categoria") String categoria,
    		@PathVariable("cantidad") Integer cantidad,
    		Model modelo) {
    	List<VentaReporte> lista = this.ventaService.reporteVentas(fecha, categoria, cantidad);
        modelo.addAttribute("reporteVentas", lista);
        return "vistaReporteVentas";
    }

}
