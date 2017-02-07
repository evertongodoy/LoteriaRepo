package br.com.loteria.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.loteria.beans.Concurso;
import br.com.loteria.dao.ConcursoDAO;

public class ControleTopSorteados {

	private Map<Integer, Integer> mapRelacaoSorteados = new HashMap<Integer, Integer>(); 
	
	private List<Integer> listaTopSorteados = new ArrayList<Integer>();
	
	
	/**
	 * Recupera lista dos numeros Top Sorteados no DAO
	 * @param dtInicio
	 * @param dtFim
	 * @return
	 */
	public List<Integer> recuperaTopSorteados(Date dtInicio, Date dtFim){

		List<Concurso> lstConcursoTemp = new ConcursoDAO().consultaConcursoEmIntervaloDatas(dtInicio, dtFim);
		
		// Se encontrou pelo menos 1 concurso
		if(lstConcursoTemp.size() > 0){
			
			// Valida do 1 ao 25 para o concurso da lista
			for(int numero = 1; numero <= 25; numero++){
				
				Integer totalNumero = 0;
				
				// Percorre todos os Concursos para verificar a quantidade de Numero do FOR.
				for(Concurso c : lstConcursoTemp){
					totalNumero = totalNumero + verificaExistenciaNumeroSorteio(numero, c);
				}

				mapRelacaoSorteados.put(numero, totalNumero);

			}
			
			// Montando a lista de retorno com cada Valor do Map
			for (Map.Entry<Integer,Integer> mapNumerosSorteadosTemp : mapRelacaoSorteados.entrySet()) {
				listaTopSorteados.add(mapNumerosSorteadosTemp.getValue());
			}
			
		}

		return listaTopSorteados;
	}
	
	
	
	/**
	 * Valida a lista percorrendo e validando o Numero atual, se existe na lista
	 * @param numero
	 * @param concurso
	 * @return
	 */
	public int verificaExistenciaNumeroSorteio(int numero, Concurso concurso){
		
		int retorno = 0;
		
		if(concurso.getNumero1().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero2().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero3().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero4().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero5().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero6().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero7().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero8().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero9().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero10().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero11().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero12().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero13().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero14().equals(Integer.valueOf(numero))){
			retorno = 1;
		} else if(concurso.getNumero15().equals(Integer.valueOf(numero))){
			retorno = 1;
		}
		
		return retorno;
	}

}
