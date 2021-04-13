package org.edgar.eduardo.service;

import java.util.LinkedList;
import java.util.List;

import org.edgar.eduardo.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriasServiceImp implements IntCategoriasService {
	
	private List<Categoria> lista = null;
	
public CategoriasServiceImp() {
		
		lista = new LinkedList<Categoria>();
		
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Arquitecto");
			c1.setDescripcion("asdasd");
			lista.add(c1);
			//
			Categoria c2= new Categoria();
			c2.setId(2);
			c2.setNombre("asdads");
			c2.setDescripcion("asas");
			lista.add(c2);
			//
			Categoria c3 = new Categoria();
			c3.setId(3);
			c3.setNombre("dfgdfg");
			c3.setDescripcion("dfgdfg");
			lista.add(c3);
			
}
	@Override
	public List<Categoria> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		for(Categoria categoria : obtenerTodas()) {
			if(categoria.getId() == idCategoria) {
				return categoria;
			}
		}
		return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		// TODO Auto-generated method stub
		lista.add(categoria);
		
	}
	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
