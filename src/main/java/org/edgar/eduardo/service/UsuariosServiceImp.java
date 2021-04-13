package org.edgar.eduardo.service;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import org.edgar.eduardo.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImp implements IntUsuariosService {
	
	private List<Usuario> lista = null;
	
	public UsuariosServiceImp() {
		
		lista = new LinkedList<Usuario>();
		try {
		      Usuario u1 = new Usuario();
		      u1.setId(1);
		      u1.setNombre("Edgar");
		      u1.setEmail("edgar@gmail.com");
		      u1.setEstatus(0);
		      u1.setUsername("Edgar1234");
		      u1.setPassword("123456");
		      u1.setFechaRegistro(LocalDate.parse("02-03-2021",
		    		  DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		      lista.add(u1);
		      
		      Usuario u2 = new Usuario();
		      u2.setId(2);
		      u2.setNombre("Eduardo");
		      u2.setEmail("Eduardo@gmail.com");
		      u2.setEstatus(0);
		      u2.setUsername("Eduardo1234");
		      u2.setPassword("123456");
		      u2.setFechaRegistro(LocalDate.parse("03-04-2021",
		    		  DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		      lista.add(u2);
		      
		      Usuario u3 = new Usuario();
		      u3.setId(3);
		      u3.setNombre("Fernando");
		      u3.setEmail("fernando@gmail.com");
		      u3.setEstatus(0);
		      u3.setUsername("Fernando1234");
		      u3.setPassword("123456");
		      u3.setFechaRegistro(LocalDate.parse("04-05-2021",
		    		  DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		      lista.add(u3);
		      
	    }catch(DateTimeParseException ex){
	    	System.out.println("Error : " + ex.getMessage());
		  }
	}

	@Override
	public List<Usuario> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		for(Usuario usuario : lista) {
			if(usuario.getId() == idUsuario) {
				return usuario;
			}
			
		}
		return null;
	}

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		lista.add(usuario);

	}

	@Override
	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		
	}

}
