package br.usjt.arqsw.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;

/**
 * @description	Entidade Chamado
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.0
 */
@Entity
public class Chamado {
	private int numero;	
	private Date dataAbertura;	
	private Date dataFechamento;	
	private String status;
	private long tempoDias;
	@NotNull 
	@Size(max=100,min=10, message="O tamanho da descriÃ§Ã£o deve estar entre 10 e 100 caracteres")
	private String descricao;	
	@NotNull
	private Fila fila;	
	
	public static final String ABERTO = "aberto";
	public static final String FECHADO = "fechado";
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Fila getFila() {
		return fila;
	}
	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public void setTempoDias(long tempoDias) {
		if (dataFechamento == null) {
			this.tempoDias = 0;
		}else {
			this.tempoDias = tempoDias;
		}
	}
	
	public long getTempoDias(){		
		return this.tempoDias;		
	}
	
	@Override
	public String toString() {
		return "Chamado [numero=" + numero + ", dataAbertura=" + dataAbertura
				+ ", dataFechamento=" + dataFechamento + ", status=" + status
				+ ", descricao=" + descricao + ", fila=" + fila + "]";
	}

}
