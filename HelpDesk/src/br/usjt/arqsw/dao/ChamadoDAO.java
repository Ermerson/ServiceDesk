package br.usjt.arqsw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;


/**
 * @description	Data Access Layser Chamado
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.0
 */

@Repository
public class ChamadoDAO {
	
	@PersistenceContext
	EntityManager manager;
	
		
	public int criarChamado(Chamado chamado) {
		manager.persist(chamado);
		return chamado.getNumero();
	}
	
	@SuppressWarnings("unchecked")
	public List<Chamado> listarChamados(Fila fila){
		fila = manager.find(Fila.class, fila.getId());
		String JPASQL = "select c from Chamado c where c.fila= :fila and c.status = :status";
		
		Query query = manager.createQuery(JPASQL);
		query.setParameter("fila", fila);
		query.setParameter("status", Chamado.ABERTO);
		
		
		List<Chamado> result = query.getResultList();
		return result;
	}
	
}
