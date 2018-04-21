package br.usjt.arqsw.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.usjt.arqsw.dao.FilaDAO;
import br.usjt.arqsw.entity.Fila;

/**
 * @description	Service Fila
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.0
 */

@Service
public class FilaService {
	private FilaDAO dao;
	
	@Autowired
	public FilaService(FilaDAO dao) {
		this.dao = dao;
	}
	public List<Fila> listarFilas() throws IOException{
		return dao.listarFilas();
	}
	public Fila carregar(int id) throws IOException{
		return dao.carregar(id);
	}
	
	public void criar(Fila fila) {
		if(fila.getId() > 0) {
			update(fila);
		}else {
			dao.save(fila);
		}
	}
	
	private void update(Fila fila) {
		dao.update(fila);
		
	}
	public void delete(int idFila) throws IOException {
		Fila fila = carregar(idFila);
		dao.remove(fila);
		
	}
	
	
	public void inserirImagem(ServletContext servletContext, Fila fila, MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file
					.getBytes()));
			String path = servletContext.getRealPath(servletContext	.getContextPath());
			path = path.substring(0, path.lastIndexOf(File.separatorChar));
			String nomeArquivo = "img"+fila.getId()+".jpg";
			fila.setImagem(nomeArquivo);
			update(fila);
			File destination = new File(path + File.separatorChar + "img" + File.separatorChar + nomeArquivo);
			if(destination.exists()){
				destination.delete();
			}
			ImageIO.write(src, "jpg", destination);
		}
		
	}
}
