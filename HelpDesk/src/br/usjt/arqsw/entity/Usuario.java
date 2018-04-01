package br.usjt.arqsw.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @description	Entidade Usuario
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.2
 */
public class Usuario {
	
	public static final String LOGADO = "logado";
	
	private int id;
	
	@NotNull(message="O usuario não pode ser NULO")
	@Min(value=1, message="O usuario não pode ser VAZIO")
	private String username;
	
	@NotNull(message="A senha não pode ser NULO")
	@Size(min=1, max=50, message="O TAMANHO da senha deve estar entre 1 e 50")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	

}
