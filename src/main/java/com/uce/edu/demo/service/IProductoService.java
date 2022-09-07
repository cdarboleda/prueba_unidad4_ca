package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoTo;

public interface IProductoService {
	public void ingresarProducto(Producto producto);
	public Integer controlarStock(String codigoBarras,Integer cantidad);
	public Producto consultarStock(String codigoBarras);
}
