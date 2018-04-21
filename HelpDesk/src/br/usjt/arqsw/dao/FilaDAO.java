package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;


/**
 * @description	Data Access Layser Fila
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.0
 */

@Repository
public class FilaDAO {
	private Connection conn;
	
	@PersistenceContext
	EntityManager manager;
	
	
	public Fila carregar(int id) throws IOException{
		return manager.find(Fila.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fila> listarFilas() throws IOException{
		return manager.createQuery("select f from Fila f").getResultList();
	}
	
	public void save(Fila fila) {
		manager.persist(fila);
		
	}

	public void update(Fila fila) {
		manager.merge(fila);
		
	}

	public void remove(Fila fila) {
		manager.remove(fila);
	}


}
