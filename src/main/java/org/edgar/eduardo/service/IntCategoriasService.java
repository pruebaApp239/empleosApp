package org.edgar.eduardo.service;

import java.util.List;
import org.edgar.eduardo.model.Categoria;
import org.edgar.eduardo.model.Vacante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IntCategoriasService {

	public List<Categoria> obtenerTodas();
	public Categoria buscarPorId(Integer idCategoria);
	public void guardar(Categoria categoria);
	public void eliminar (Integer idCategoria);
	Page<Categoria>buscarTodas(Pageable page);

}
