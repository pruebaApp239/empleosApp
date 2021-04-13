package org.edgar.eduardo.repository;

import java.util.List;

import org.edgar.eduardo.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	
	//query methods (metodos personalizados por un campo en especifico)
	 List<Vacante> findByEstatus(String estatus);
	 List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
	 List<Vacante> findBySalarioBetween(double s1, double s2);
	 List<Vacante> findByEstatusIn(String[] estatus);
 }
