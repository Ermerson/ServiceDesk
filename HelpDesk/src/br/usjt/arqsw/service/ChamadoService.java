package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
	
	public int novoChamado(Chamado chamado) throws IOException{
		chamado.setDataAbertura(new Date());
		chamado.setDataFechamento(null);
		chamado.setStatus(Chamado.ABERTO);
		return -1;
	}
	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException{
		return dao.listarChamados(fila);
	}

}
