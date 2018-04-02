package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @description	Entidade Chamado
 * @author 		Ermerson Rafael - 816122707
 * @category	Aplicações e Serviços
 * @since		21/02/2018
 * @version		v1.0.0.0
 */
@Entity
@Table(name="Chamado")
public class Chamado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final String ABERTO = "aberto";
	public static final String FECHADO = "fechado";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_chamado")
	@NotNull(message="O chamado não pode ser nulo")	
	private int numero;
	
	@NotNull
	@Column(name="descricao")
	@Size(max=100,min=10, message="O tamanho da descrição deve estar entre 10 e 100 caracteres")
	private String descricao;	
	
	@Column(name="dt_Abertura")	
	private Date dataAbertura;
	
	@Column(name="dt_Fechamento")	
	private Date dataFechamento;
	
	@Column(name="Status")	
	private String status;
	
	private long tempoDias;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_fila")
	private Fila fila;	
	
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
