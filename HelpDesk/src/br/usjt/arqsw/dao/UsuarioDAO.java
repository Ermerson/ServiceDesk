package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;




/**
 * @description	Data Access Layer Usuario
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.1
 */
@Repository
public class UsuarioDAO {
	
	private Connection conn;
	
	@Autowired
	public UsuarioDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		}catch (SQLException e) {
			throw new IOException(e);
		}
	}
	
	public boolean validaUsuario(Usuario usuario) throws IOException {
		String query = "SELECT USERNAME, PASSWORD  FROM USUARIO WHERE USERNAME = ? AND PASSWORD = ? ";		
		try(PreparedStatement pst = conn.prepareStatement(query);){
			pst.setString(1, usuario.getUsername());
			pst.setString(2, usuario.getPassword());
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					return true;
				}else {
					return false;
				}
			}catch(SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	
	

}
