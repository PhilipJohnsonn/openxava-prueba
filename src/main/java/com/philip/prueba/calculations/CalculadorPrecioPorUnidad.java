package com.philip.prueba.calculations;

import static org.openxava.jpa.XPersistence.getManager;

import org.openxava.calculators.*;

import com.philip.prueba.model.*;

import lombok.*;

public class CalculadorPrecioPorUnidad implements ICalculator{
	
	@Getter @Setter     
    int numeroProducto;

	@Override
	public Object calculate() throws Exception {
		Producto producto = getManager().find(Producto.class, numeroProducto);
		return producto.getPrecio();
    }
	
}
