package com.philip.prueba.actions;

import java.util.*;

import org.openxava.actions.*;

import com.philip.prueba.model.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;

public class GenerarDetalleProductoPdf extends JasperReportBaseAction {

	private Producto producto;

	@Override
	protected JRDataSource getDataSource() throws Exception {
		return new JREmptyDataSource();
	}

	@Override
	protected String getJRXML() throws Exception {
		return "reports/productReportPdf.jrxml";
	}

	@Override
	protected Map getParameters() throws Exception {
		Map parameters = new HashMap();
		Producto producto = getProducto();
		producto.setCategoriaString(producto.getCategoria().getDescripcion());
		List<Producto> listaProductos = new ArrayList<>();
		listaProductos.add(producto);
		parameters.put("productDataSet", new JRBeanCollectionDataSource(listaProductos));
		return parameters;
	}

	@Override
	public void execute() throws Exception {
		super.execute();		
	}


	private Producto getProducto() throws Exception {
		if (producto == null) {
			int numero = getView().getValueInt("numero");
			producto = Producto.findById(numero);
		}
		return producto;
	}
	
}
