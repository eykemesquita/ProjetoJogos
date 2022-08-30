package com.timegames.projetojogos.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> listar(){
		return repo.findAll();
	}
	
	public Usuario findById(Long id) {
		return repo.findById(id).get();
	}
	
	public Usuario create(Usuario user) {
		return repo.save(user);
	}
	
	public Usuario atualizar(Usuario user, Long id) {
		Usuario userFromDatabase = repo.getReferenceById(id);
		userFromDatabase.setEmail(user.getEmail());
		userFromDatabase.setName(user.getName());
		return repo.save(userFromDatabase);
	}
	
	public void deletar(Long id) {
		repo.deleteById(id);
	}
	
}
