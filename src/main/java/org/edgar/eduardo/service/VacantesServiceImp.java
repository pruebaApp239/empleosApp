package org.edgar.eduardo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.edgar.eduardo.model.Categoria;
import org.edgar.eduardo.model.Vacante;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VacantesServiceImp implements IntVacantesService {
	//atributo de tipo linked list
	private List<Vacante> lista = null;
	
	//metodo constructor
	public VacantesServiceImp() {
		
		lista = new LinkedList<Vacante>();
		try {
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Arquitecto");
			v1.setDescripcion("Relacionado con la construccion");
			v1.setFecha(LocalDate.parse("12-01-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v1.setSalario(9500.0);
			v1.setDestacado(1);
			v1.setEstatus("Aprobada");
			v1.setImagen("43582793_10216428467800307_3718498585122177024_n.jpg");
			
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Contabilidad");
			c1.setDescripcion("Relacionado con contabilidad");
			v1.setCategoria(c1);
			
			lista.add(v1);
			//*****************
			Vacante v2 = new Vacante();
			v2.setId(2);
			v2.setNombre("Tecnico de mantenimiento");
			v2.setDescripcion("Soporte de equipos de computo");
			v2.setFecha(LocalDate.parse("13-02-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v2.setSalario(1000.0);
			v2.setDestacado(0);
			v2.setEstatus("Aprobada");
			v2.setImagen("43828839_1047895232046795_7528663072399949824_n.jpg");
			
			Categoria c2 = new Categoria();
			c2.setId(2);
			c2.setNombre("Arquitecto");
			c2.setDescripcion("Relacionado con la construccion");
			v2.setCategoria(c2);
			
			lista.add(v2);
			//*****************
			Vacante v3 = new Vacante();
			v3.setId(3);
			v3.setNombre("Programador web");
			v3.setDescripcion("Creador de paginas web");
			v3.setFecha(LocalDate.parse("20-03-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v3.setSalario(1000.0);
			v3.setDestacado(1);
			v3.setEstatus("Eliminada");
			
			Categoria c3 = new Categoria();
			c3.setId(3);
			c3.setNombre("Tecnico en mantenimiento");
			c3.setDescripcion("Relacionado con soporte tecnico");
			v3.setCategoria(c3);
			
			lista.add(v3);
			//*****************
			Vacante v4 = new Vacante();
			v4.setId(4);
			v4.setNombre("Desarrollador movil");
			v4.setDescripcion("Creador de aplicaciones moviles");
			v4.setFecha(LocalDate.parse("20-03-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v4.setSalario(1100.0);
			v4.setDestacado(0);
			v4.setEstatus("Creada");
			
			Categoria c4 = new Categoria();
			c4.setId(4);
			c4.setNombre("Ingeniero electronico");
			c4.setDescripcion("Relacionado con la electronica");
			v4.setCategoria(c4);
			
			lista.add(v4);
			//*********************
		}catch(DateTimeParseException ex){
			System.out.println("Error : " + ex.getMessage());
		}
	}

	@Override
	public List<Vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		// TODO Auto-generated method stub
		for(Vacante vacante : obtenerTodas()) {
			if(vacante.getId() == idVacante) {
				return vacante;
			}
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		lista.add(vacante);
		
	}

	@Override
	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return null;
	}

}
