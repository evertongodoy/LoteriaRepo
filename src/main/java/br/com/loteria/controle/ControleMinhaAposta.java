package br.com.loteria.controle;

import java.util.List;

import br.com.loteria.beans.MinhaAposta;
import br.com.loteria.dao.MinhaApostaDAO;

public class ControleMinhaAposta {

	public ControleMinhaAposta() {}

	/**
	 * Faz a chamada no DAO para salvar a minha aposta
	 * @param ma
	 */
	public void salvarMinhaAposta(MinhaAposta ma){
		new MinhaApostaDAO().salvarDadosMinhaAposta(ma);
	}	
	
	/**
	 * Recupera no DAO todas as apostas ativas
	 * @return
	 */
	public List<MinhaAposta> recuperaMinhasApostas(){
		return new MinhaApostaDAO().recuperarMinhasApostasDAO();
		
	}

}
