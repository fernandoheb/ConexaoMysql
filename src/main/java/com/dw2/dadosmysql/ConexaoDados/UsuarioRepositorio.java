package com.dw2.dadosmysql.ConexaoDados;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.dw2.dadosmysql.ConexaoDados.Usuario;

public interface UsuarioRepositorio extends CrudRepository <Usuario, Long> {

	 List<Usuario> findBySobrenome(String Sobrenome);
	 List<Usuario> findByNome(String Nome);
	 List<Usuario> findByEmail(String Email);
	 
	 Usuario findById(long id);
	
}
