package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.service.ChamadoService;

@RestController
public class ChamadosRest {
	
	private ChamadoService chamadoService;
	
	@Autowired
	public ChamadosRest(ChamadoService chamadoService) {
		this.chamadoService = chamadoService;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="rest/chamado")
	public @ResponseBody List<Chamado> listarChamados() throws IOException{
		List<Chamado> lista = null;
		System.out.println("Passei por aqui");
		lista = chamadoService.listarChamados();			
		return lista;
	}

}
