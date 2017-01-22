package br.com.loteria.controle;

import java.util.List;

import br.com.loteria.beans.Concurso;
import br.com.loteria.dao.ConcursoDAO;

public class ControleNovoSorteio {

	public ControleNovoSorteio() { }
	
	/**
	 * Recebe lista de concursos como argumento e chama procedimento para gravacao no DAO
	 * @param listaConcurso
	 */
	public void salvarNovoJogo(List<Concurso> listaConcurso){
		new ConcursoDAO().salvarDadosConcurso(listaConcurso);
	}

	/**
	 * Recupera no DAO todos os concursos exixtentes
	 * @return
	 */
	public List<Concurso> recuperarTodosSorteios(){
		return new ConcursoDAO().consultaTodosConcursos();
	}
	
	/**
	 * Recupera uma lista de concursos no DAO a partir do ID informado
	 * @return
	 */
	public List<Concurso> recuperarSorteiosMaioresIguaisPorID(Integer numeroConcurso){
		return new ConcursoDAO().consultaConcursosMaioresIguaisPorID(numeroConcurso);
	}
	
	/**
	 * Recupera uma lista de concursos no DAO a partir de um intervalo de sorteio informado
	 * @param numeroInicial
	 * @param numeroFinal
	 * @return
	 */
	public List<Concurso> recuperarSorteiosEmIntervalosDeConcurso(Integer numeroInicial, Integer numeroFinal){
		return new ConcursoDAO().consultaConcursosEmIntervalo(numeroInicial, numeroFinal);
	}
	
}
