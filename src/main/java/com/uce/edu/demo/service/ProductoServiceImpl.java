package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoTo;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void ingresarProducto(Producto producto) {
		
		Producto productoDB = this.productoRepository.buscar(producto.getCodigoBarras());
		if(productoDB==null) {
			this.productoRepository.insertar(producto);
		}else {
			Integer stockFinal =productoDB.getStock()+producto.getStock();
			this.productoRepository.actualizarStock(producto.getCodigoBarras(),stockFinal);
		}	
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Integer controlarStock(String codigoBarras, Integer cantidad) {
		// TODO Auto-generated method stub
		Producto productoDB=this.productoRepository.buscar(codigoBarras);
		Integer stockActual = productoDB.getStock();
		Integer cantidadComprada = cantidad;
		if(productoDB==null || stockActual==0) {
			throw new RuntimeException();
		}
		else if(cantidad<=stockActual) {
			stockActual = stockActual-cantidad;
			this.productoRepository.actualizarStock(codigoBarras, stockActual);
		}else {
			cantidadComprada = stockActual;
			stockActual = stockActual-stockActual;//0
			this.productoRepository.actualizarStock(codigoBarras, stockActual);
		}

		return cantidadComprada;
	}
	
	@Override
	//@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto consultarStock(String codigoBarras) {
		return this.productoRepository.consultarStock(codigoBarras);
	}

}
