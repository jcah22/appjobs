package com.jcah.spring.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jcah.spring.app.model.Vacante;

@Controller
public class MostrarHome {
	
	@GetMapping("/")
	public String index(Model m) {
		
		String nombre ="Auxiliar de Contabilidad";
		Date fechaPub =  new Date();
		double salario = 9000.0;
		boolean vigente = true;
		
		m.addAttribute("nombre", nombre);
		m.addAttribute("fecha", fechaPub);
		m.addAttribute("salario", salario);
		m.addAttribute("vigente", vigente);
		
		return "index";
		
	}
	
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		
		List<String> lista = new LinkedList<>();
		lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		
		return "listado";
		
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de Comunicaciones");
		vacante.setDescripcion("se solicita ingeniero para dar soporte a intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		model.addAttribute("vacante", vacante);
		
		
		return "detalle";
	}
	
	private List<Vacante> getVacantes(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new ArrayList<Vacante>();
		
		try {
			//oferta de trabajo1
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero civil");
			vacante1.setDescripcion("Ingeniero civil para diseñar puente peatonal");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalario(12000.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");
			
			
			// oferta de trabajo 2
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("contador publico");
			vacante2.setDescripcion("contador con 5 años de experiencia titulado");
			vacante2.setFecha(sdf.parse("12-10-2019"));
			vacante2.setSalario(12000.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			//vacante #3 
			
			Vacante vacante3= new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electrico");
			vacante3.setDescripcion("Ingeniero electromecanico para mantenimiento de la instalacion electrica");
			vacante3.setFecha(sdf.parse("14-08-2020"));
			vacante3.setSalario(10500.0);
			vacante3.setDestacado(0);
			
			
			//vacante #4
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador Grafico");
			vacante4.setDescripcion("Diseñador grafico para diseñar la publicidad de la empresa");
			vacante4.setFecha(sdf.parse("12-06-2021"));
			vacante4.setSalario(11500.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa4.png");
			
			
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		
			
		}catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	
		return lista;
		
	}

	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
		model.addAttribute("vacantes", lista);
		
		return "tabla";
	}
	

}
