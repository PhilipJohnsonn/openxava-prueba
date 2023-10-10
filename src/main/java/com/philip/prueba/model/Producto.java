package com.philip.prueba.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.jpa.*;

import lombok.*;

@Entity
@Getter @Setter
public class Producto {

	@Id
	@Column(length = 9)
	int numero;
	
	@Column(length = 50)
	@Required
	String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList
	Categoria categoria;
	
	@Money
	BigDecimal precio;
	
	@Files
	@Column(length = 32)
	String fotos;
	
	@TextArea
	String observaciones;
	
	@Hidden
	String categoriaString;
	
	public static Producto findById(int id) throws NoResultException {
		Query query = XPersistence.getManager().createQuery("FROM Producto WHERE numero = :id");
		query.setParameter("id", id);
		return (Producto) query.getSingleResult();
	}
	
}
