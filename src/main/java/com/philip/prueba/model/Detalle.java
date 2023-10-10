package com.philip.prueba.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.philip.prueba.calculations.*;

import lombok.*;

@Embeddable
@Getter @Setter
public class Detalle {

	int cantidad;
	 
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Producto producto;
    
    @DefaultValueCalculator(value = CalculadorPrecioPorUnidad.class, properties = @PropertyValue(name="numeroProducto", from="producto.numero"))
	@Money
	BigDecimal precioPorUnidad;
   
    @Money
    @Depends("precioPorUnidad, cantidad")
    public BigDecimal getTotal() {
        if (precioPorUnidad == null) return BigDecimal.ZERO;
        return new BigDecimal(cantidad).multiply(precioPorUnidad);
    }
    
    int santi;
    
}
