package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoTo;

public interface IProductoRepository {
	public void insertar(Producto producto);
	public void actualizarStock(String codigoBarras, Integer stock);
	public Producto buscar(String codigoBarras);
	public Producto consultarStock(String codigoBarras);
}
