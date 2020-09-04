package com.dw2.dadosmysql.ConexaoDados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)	
	private long Id_usuario;
	
	
	private String nome;
	
	private String sobrenome;
	
	private String email;

	public long getId_usuario() {
		return Id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		Id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [Id_usuario=" + Id_usuario + ", Nome=" + nome + ", Sobrenome=" + sobrenome + ", Email=" + email
				+ "]";
	}
	
	

}
