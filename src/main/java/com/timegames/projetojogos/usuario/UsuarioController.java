package com.timegames.projetojogos.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar(){
		return  ResponseEntity.ok().body(usuarioService.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(usuarioService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
		return ResponseEntity.ok().body(usuarioService.create(usuario));
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario, @PathVariable Long id){
		return ResponseEntity.ok().body(usuarioService.atualizar(usuario, id));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		usuarioService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
}
