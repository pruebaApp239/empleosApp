package org.edgar.eduardo.repository;

import org.edgar.eduardo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

	
}
