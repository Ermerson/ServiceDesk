package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.hibernate.jpa.criteria.expression.ConcatExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * @description	Service Chamado
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.0
 */

@Service
public class ChamadoService {
	ChamadoDAO dao;
	
	@Autowired
	public ChamadoService(ChamadoDAO dao){
		this.dao = dao;
	}
	
	public Chamado novoChamado(Chamado chamado) throws IOException{
		chamado.setDataAbertura(new Date());
		chamado.setDataFechamento(null);
		chamado.setStatus(Chamado.ABERTO);
		return dao.persistChamado(chamado);
	}
	
	public Chamado fecharChamado(int id) throws IOException{
		Chamado chamado = consultarChamado(id);
		chamado.setDataFechamento(new Date());
		chamado.setStatus(Chamado.FECHADO);
		return dao.persistChamado(chamado);
	}
	
	public Chamado consultarChamado(int id) {
		return dao.consultarChamado(id);
	}
	
	public List<Chamado> listarChamados(Fila fila) throws IOException{
		return dao.listarChamados(fila);
	}
	
	public List<Chamado> listarChamados() throws IOException{
		return dao.listarChamados();
	}
	
	
}
