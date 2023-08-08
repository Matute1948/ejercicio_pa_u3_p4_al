package com.uce.edu.ec.ejercicio_pa_u3_p4_al;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.DetalleFactura;
import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.Factura;
import com.uce.edu.ec.ejercicio_pa_u3_p4_al.repository.modelo.Producto;
import com.uce.edu.ec.ejercicio_pa_u3_p4_al.service.IFacturaService;
import com.uce.edu.ec.ejercicio_pa_u3_p4_al.service.IProductoService;

@SpringBootApplication
public class EjercicioPaU3P4AlApplication implements CommandLineRunner{
	private static final Logger LOG = LoggerFactory.getLogger(EjercicioPaU3P4AlApplication.class);
	@Autowired
	private IProductoService productoService;
	@Autowired 
	private IFacturaService facturaService;
	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU3P4AlApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Producto producto11 = new Producto();
		Producto producto12 = producto11;
		Producto producto21 = new Producto();
		Producto producto22 = producto21;

		List<Producto> lisPro = new ArrayList<>();

		producto11.setNombre("paracetamol");
		producto11.setCategoria("Pastillas");
		producto11.setCodigoBarras("12345678");
		producto11.setPrecio(new BigDecimal(0.50));
		producto11.setStock(4);
		
		producto21.setNombre("Pedialite");
		producto21.setCategoria("Hidratante");
		producto21.setCodigoBarras("87654321");
		producto21.setPrecio(new BigDecimal(2.50));
		producto21.setStock(7);

		producto12.setStock(2);
		producto22.setStock(3);

		lisPro.add(producto11);
		lisPro.add(producto21);
		this.productoService.agregar(producto11);
		this.productoService.agregar(producto12);
		this.productoService.agregar(producto21);
		this.productoService.agregar(producto22);

		this.facturaService.agregar(lisPro, "1724219685");
		

		

		

		
	}

}
