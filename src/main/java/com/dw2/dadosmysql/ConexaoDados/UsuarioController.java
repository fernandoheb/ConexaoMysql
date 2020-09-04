package com.dw2.dadosmysql.ConexaoDados;

import java.util.List;
import java.util.Optional;
import java.util.function.LongToIntFunction;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepositorio repositorio;

	@PostMapping(path = "/add")
	public @ResponseBody String novoUsuario(@RequestParam String nome, @RequestParam String sobrenome,
			@RequestParam String email) {
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setSobrenome(sobrenome);
		user.setEmail(email);
		repositorio.save(user);
		return "Valores salvos com sucesso";
	}
	
	@PostMapping(path = "/adduser")
	public @ResponseBody String novoUsuario2(@RequestBody Usuario newUser) {
			repositorio.save(newUser);
		return "Usuário inserido com sucesso";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Usuario> retornaTodos() {
		return repositorio.findAll();
	}

	@GetMapping(path = "/user")
	public @ResponseBody Optional<Usuario> retornaUser(@RequestParam Long id) {
		return repositorio.findById(id);
	}
	
	@GetMapping(path ="/locate_user/{id}")
	public @ResponseBody Optional<Usuario> retornaUser2 (@PathVariable(required = true,name="id") 
	Long id) {
		return repositorio.findById(id);
	}
	
	@DeleteMapping(path ="delete_user/{id}")
	public @ResponseBody String deleteUser (@PathVariable(required = true , name ="id") Long id) {
		Optional<Usuario> user = repositorio.findById(id);
		if (user.isPresent()) {
			repositorio.delete(user.get());
			return "Usuário deletado com sucesso";
		}
		return "Usuário não encontrado";
	}
	
	@PutMapping(path="update_user/{id}")
	public @ResponseBody Optional<Usuario> updateUser(@PathVariable(required = true, name="id") Long id,
			@RequestBody Usuario user){
			Optional<Usuario> u = repositorio.findById(id);
				if(u.isPresent()) {
					u.get().setNome(user.getNome());
					u.get().setEmail(user.getEmail());
					u.get().setSobrenome(user.getSobrenome());
					repositorio.save(u.get());	
					return u;
				}		
		return null;		
	}
	
	@PutMapping(path = "/user/{id}")
	public @ResponseBody ResponseEntity<Usuario> alteraUser(@PathVariable(required = true, name = "id") Long id,
			@RequestBody Usuario user) {
		Optional<Usuario> u = repositorio.findById(id);
		if (u.isPresent()) {			
			u.get().setNome(user.getNome());
			u.get().setEmail(user.getEmail());
			u.get().setSobrenome(user.getSobrenome());			
			return ResponseEntity.ok(repositorio.save(u.get()));
		}
		return ResponseEntity.status(404).build();
	}	
	
	@GetMapping(path="locate_by_nome/{Nome}")
	public @ResponseBody List<Usuario> locateByNome(@PathVariable(required = true, name="Nome") String Nome){
		return repositorio.findByNome(Nome);		
	}
	
	@GetMapping(path="locate_by_sobrenome/{Sobrenome}")
	public @ResponseBody List<Usuario> locateBySobrenome(@PathVariable(required = true,name="Sobrenome") String Sobrenome ){
		return repositorio.findBySobrenome(Sobrenome);	
	}
 	
	@GetMapping(path="locate_by_email/{Email}")
	public @ResponseBody List<Usuario> locateByEmail(@PathVariable(required = true,name="Email") String Email ){
		return repositorio.findByEmail(Email);	
	}
	
	
	
	
	
	
	
	

	
	
	

}
