/**
 * 
 */
package br.com.loteria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;



import br.com.loteria.beans.Concurso;
import br.com.loteria.utils.JpaUtil;

/**
 * @author Everton
 *
 */
public class ConcursoDAO {

	public ConcursoDAO() {}
	
	/**
	 *  Salvar os dados do Novo Concurso
	 * @param listConcurso
	 */
	public void salvarDadosConcurso(List<Concurso> listConcurso){
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		for(Concurso c : listConcurso){
			
			manager.persist(c);
			
		}
		
		tx.commit();
		
		manager.close();
		
		JpaUtil.close();
		
	}

	
	/**
	 * Recupera todos os concursos
	 * @param listaNumerosSorteados
	 * @return
	 */
	public List<Concurso> consultaTodosConcursos(){
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<Concurso> query = manager.createNamedQuery("Concurso.queryListaTodosConcursos", Concurso.class);
		
		List<Concurso> lstConcurso = query.getResultList();
		
		manager.close();
		
		JpaUtil.close();

		return lstConcurso;
	}
	
	
	/**
	 * Recupera uma lista de Concursos a partir de um numero de sorteio informado
	 * @param numeroConcursoInicial
	 * @return
	 */
	public List<Concurso> consultaConcursosMaioresIguaisPorID(Integer numeroConcursoInicial){
		
		EntityManager manager = JpaUtil.getEntityManager();
		
		TypedQuery<Concurso> query = manager.createNamedQuery("Concurso.queryListaConcursosIgualAcimaID", Concurso.class);
		
		List<Concurso> lstConcurso = query.setParameter("numeroConcurso", numeroConcursoInicial).getResultList();
		
		manager.close();
		
		JpaUtil.close();

		return lstConcurso;
	}
	
	

	


	
	

}
