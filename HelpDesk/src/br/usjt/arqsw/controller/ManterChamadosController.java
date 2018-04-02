package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;
/**
 * @description	Controller Chamado
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.0
 */

@Transactional
@Controller
public class ManterChamadosController {
	private FilaService filaService;
	private ChamadoService chamadoService;

	@Autowired
	public ManterChamadosController(FilaService filaService, ChamadoService chamadoService) {
		this.filaService 	= filaService;
		this.chamadoService = chamadoService;
	}

	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	private List<Fila> listarFilas() throws IOException{
			return filaService.listarFilas();
	}
	
	@RequestMapping("/listar_filas_exibir")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	
	@RequestMapping("/listar_chamados_exibir")
	public String listarChamadosExibir(@Valid Fila fila, BindingResult result, Model model) {
		try {
			if (result.hasFieldErrors("id")) {
				model.addAttribute("filas", listarFilas());
				return "ChamadoListar";
			}
			fila = filaService.carregar(fila.getId());
			model.addAttribute("fila", fila);
			List<Chamado> chamados = chamadoService.listarChamados(fila);
			model.addAttribute("chamados", chamados);			
			return "ChamadoListarExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/incluir_novo_chamado")
	public String novoChamado(Model model){
		try{
			model.addAttribute("lista",listarFilas());
			return "NovoChamado";
		}catch(IOException e){
			e.printStackTrace();
			return "Erro";
		}
	}	
	
	@RequestMapping("/novo_chamado")
	public String criarChamado(@Valid Chamado chamado, BindingResult result, Model model) {
		if(result.hasFieldErrors("descricao")) {
			try {
				model.addAttribute("lista", listarFilas());
				return "NovoChamado";
			}catch(IOException e) {
				e.printStackTrace();
				return "Erro";
			}
		}else {
			try {
				//int id = chamadoService.novoChamado(chamado);
				chamado.setNumero(chamadoService.novoChamado(chamado));
				return "ExibirChamado";
			}catch(IOException e) {
				e.printStackTrace();
				return "Erro";
			}
		}
	}

}
