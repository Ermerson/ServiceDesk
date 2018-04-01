package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	private Connection conn;
	
	@Autowired
	public ChamadoDAO(DataSource dataSource) throws IOException{
		try {
			this.conn = dataSource.getConnection();			
		}catch(SQLException e) {
			throw new IOException(e);
		}
	}	
	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException{
		ArrayList<Chamado> lista = new ArrayList<>();
		String query = " SELECT C.ID_CHAMADO, "
							+ "C.DESCRICAO, "
							+ "C.DT_ABERTURA, "
							+ "C.DT_FECHAMENTO, "
							+ "TIMESTAMPDIFF(DAY, C.DT_ABERTURA, C.DT_FECHAMENTO) AS DIAS, "
							+ "C.STATUS, F.NM_FILA "
					 + " FROM CHAMADO C, FILA F "
					 		+ "WHERE C.ID_FILA = F.ID_FILA AND "
					 			+ "C.ID_FILA = ? ";		
		try(PreparedStatement pst = conn.prepareStatement(query);){
			pst.setInt(1, fila.getId());			
			try(ResultSet rs = pst.executeQuery();){
				while(rs.next()){
					Chamado chamado = new Chamado();
					chamado.setNumero(rs.getInt("ID_CHAMADO"));
					chamado.setDescricao(rs.getString("DESCRICAO"));
					chamado.setDataAbertura(rs.getDate("DT_ABERTURA"));
					chamado.setDataFechamento(rs.getDate("DT_FECHAMENTO"));
					chamado.setStatus(rs.getString("STATUS"));
					chamado.setTempoDias(rs.getLong("DIAS"));
					fila.setNome(rs.getString("NM_FILA"));
					chamado.setFila(fila);
					lista.add(chamado);
				}
			} catch(SQLException e){
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch(SQLException e){
			e.printStackTrace();
			throw new IOException(e);
		}
		return lista;
	}
	
}
