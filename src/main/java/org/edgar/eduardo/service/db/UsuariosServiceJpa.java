package org.edgar.eduardo.service.db;

import java.util.List;
import java.util.Optional;

import org.edgar.eduardo.model.Usuario;
import org.edgar.eduardo.repository.UsuariosRepository;
import org.edgar.eduardo.service.IntUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UsuariosServiceJpa implements IntUsuariosService {
	
	@Autowired
	private UsuariosRepository repoUsuarios;

	@Override
	public List<Usuario> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoUsuarios.findAll();
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> optional = repoUsuarios.findById(idUsuario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		repoUsuarios.save(usuario);

	}

	@Override
	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		repoUsuarios.deleteById(idUsuario);
	}
	
}
