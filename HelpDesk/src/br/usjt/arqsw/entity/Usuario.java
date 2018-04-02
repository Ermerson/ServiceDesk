package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	public static final String LOGADO = "logado";
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int id;
	
	@Column(name="username")
	@NotNull(message="O usuario não pode ser NULO")
	@Min(value=1, message="O usuario não pode ser VAZIO")
	private String username;
	
	//@Column(name="password")
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
