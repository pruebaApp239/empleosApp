package org.edgar.eduardo.repository;

import org.edgar.eduardo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
