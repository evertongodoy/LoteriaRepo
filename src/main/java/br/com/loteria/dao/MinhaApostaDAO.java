package br.com.loteria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.loteria.beans.MinhaAposta;
import br.com.loteria.utils.JpaUtil;

public class MinhaApostaDAO {

	public MinhaApostaDAO() {}
	
	/**
	 * Salvar os dados da minha aposta
	 * @param listConcurso
	 */
	public void salvarDadosMinhaAposta(MinhaAposta ma){
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
					
		manager.persist(ma);
				
		tx.commit();
		
		manager.close();
		
		JpaUtil.close();
		
	}
	
	/**
	 * Recuperar todas as minhas apostas ativas
	 * @return
	 */
	public List<MinhaAposta> recuperarMinhasApostasDAO(){
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<MinhaAposta> query = manager.createNamedQuery("MinhaAposta.queryListaMinhasApostasAtivas", MinhaAposta.class);
		
		List<MinhaAposta> lstMinhasApostas = query.getResultList();
		
		manager.close();
		
		JpaUtil.close();

		return lstMinhasApostas;
		
	}
	
	
}
