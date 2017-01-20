package br.com.loteria.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.loteria.beans.Concurso;
import br.com.loteria.beans.MinhaAposta;
import br.com.loteria.beans.ResultadoSorteio;

public class ControleConsultaResultado {

	
	public ControleConsultaResultado() {
	}

	/**
	 * Verifica os acertos entre Minhas Apostas x Concursos
	 * @param listaMinhasApostas
	 * @param listaConcursos
	 * @return
	 */
	public List<ResultadoSorteio> validaAcertosEntreApostaSorteios(List<MinhaAposta> listaMinhasApostas, List<Concurso> listaConcursos) {

		List<MinhaAposta> lstMinhasApostasAux = new ArrayList<MinhaAposta>();

		// Retorno
		List<ResultadoSorteio> listaResultadoSorteio = new ArrayList<ResultadoSorteio>();

		// 1 - Cria a lista de numeros para a minha aposta
		for (MinhaAposta ma : listaMinhasApostas) {

			List<Integer> listaIntegerTemp = new ArrayList<Integer>();

			listaIntegerTemp.add(ma.getNumero1());
			listaIntegerTemp.add(ma.getNumero2());
			listaIntegerTemp.add(ma.getNumero3());
			listaIntegerTemp.add(ma.getNumero4());
			listaIntegerTemp.add(ma.getNumero5());
			listaIntegerTemp.add(ma.getNumero6());
			listaIntegerTemp.add(ma.getNumero7());
			listaIntegerTemp.add(ma.getNumero8());
			listaIntegerTemp.add(ma.getNumero9());
			listaIntegerTemp.add(ma.getNumero10());
			listaIntegerTemp.add(ma.getNumero11());
			listaIntegerTemp.add(ma.getNumero12());
			listaIntegerTemp.add(ma.getNumero13());
			listaIntegerTemp.add(ma.getNumero14());
			listaIntegerTemp.add(ma.getNumero15());

			ma.setLstNumerosAposta(listaIntegerTemp);

			lstMinhasApostasAux.add(new MinhaAposta(ma));

		}
				
		List<Integer> lstNumApostaOriginal = new ArrayList<Integer>();

		// Para cada aposta
		for (MinhaAposta ma : lstMinhasApostasAux) {

			// Liga controla de aposta original
			Integer validaAposta = 1;

			List<Concurso> novaListaConc = this.retornaListaConcurso(listaConcursos);

			// Perocorro cada concurso
			for(Concurso conc : novaListaConc){

				// Limpa e armazena a aposta original somente 1 vez
				if(validaAposta.equals(1)){
					lstNumApostaOriginal.clear();
				}
				if(validaAposta.equals(1)){
					lstNumApostaOriginal.add(new Integer(ma.getNumero1()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero2()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero3()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero4()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero5()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero6()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero7()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero8()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero9()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero10()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero11()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero12()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero13()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero14()));
					lstNumApostaOriginal.add(new Integer(ma.getNumero15()));
					
					// Desliga
					validaAposta = 0;
				}
				
				// Garantir que a lista de apostas de "ma" sempre vai ter as apostas originais
				ma.getLstNumerosAposta().clear();
				for(Integer i : lstNumApostaOriginal){
					ma.getLstNumerosAposta().add(i);
				}
				
				// Remove da minha lista de Aposta tudo o que estiver CERTO em Sorteio
				// Sobra os numeros ERRADOS
				ma.getLstNumerosAposta().removeAll(conc.getLstNumerosSorteio());
				
				
				// Retem na lista de Concurso tudo o que estiver CERTO
				// Sobra os numeros CERTOS
				conc.getLstNumerosSorteio().retainAll(lstNumApostaOriginal);
				
				
				if(conc.getLstNumerosSorteio().size() >= 11){
					
					// Cria novo objeto de minha aposta com a lista de erros e acertos
					MinhaAposta mApostaFinal = new MinhaAposta(ma);
					
					if(conc.getLstNumerosSorteio().size() == 11 ){
						mApostaFinal.setTotalGanhoReais(4.00d);
					} else if(conc.getLstNumerosSorteio().size() == 12){
						mApostaFinal.setTotalGanhoReais(8.00d);
					} else if(conc.getLstNumerosSorteio().size() == 13){
						mApostaFinal.setTotalGanhoReais(20.00d);
					} else if(conc.getLstNumerosSorteio().size() > 13){
						mApostaFinal.setTotalGanhoReais(99.99d);
					}
					
					mApostaFinal.setTotalErro(String.valueOf(ma.getLstNumerosAposta().size()));
					mApostaFinal.setNumerosErrados(ma.getLstNumerosAposta().toString());
					mApostaFinal.setTotalAcerto(String.valueOf(conc.getLstNumerosSorteio().size()));
					mApostaFinal.setNumerosAcertados(conc.getLstNumerosSorteio().toString());
					
					// Cria novo objeto de concurso com a lista de acertos
					Concurso concursoFinal = new Concurso(conc);
					ResultadoSorteio rs= new ResultadoSorteio(mApostaFinal, concursoFinal);
					
					listaResultadoSorteio.add(rs);
				}

			}

		}

		return listaResultadoSorteio;

	}

	/**
	 * Monta uma lista de Concurso com lista de numeros sorteados
	 * @param lstConcursoParam
	 * @return
	 */
	private List<Concurso> retornaListaConcurso(List<Concurso> lstConcursoParam){
		
		List<Concurso> lstConcursoAux = new ArrayList<Concurso>();
		
		// 2 - Cria a lista de numeros para o sorteio
		for (Concurso concurso : lstConcursoParam) {
					
			List<Integer> listaIntegerTemp = new ArrayList<Integer>();
			listaIntegerTemp.add(new Integer(concurso.getNumero1()));
			listaIntegerTemp.add(new Integer(concurso.getNumero2()));
			listaIntegerTemp.add(new Integer(concurso.getNumero3()));
			listaIntegerTemp.add(new Integer(concurso.getNumero4()));
			listaIntegerTemp.add(new Integer(concurso.getNumero5()));
			listaIntegerTemp.add(new Integer(concurso.getNumero6()));
			listaIntegerTemp.add(new Integer(concurso.getNumero7()));
			listaIntegerTemp.add(new Integer(concurso.getNumero8()));
			listaIntegerTemp.add(new Integer(concurso.getNumero9()));
			listaIntegerTemp.add(new Integer(concurso.getNumero10()));
			listaIntegerTemp.add(new Integer(concurso.getNumero11()));
			listaIntegerTemp.add(new Integer(concurso.getNumero12()));
			listaIntegerTemp.add(new Integer(concurso.getNumero13()));
			listaIntegerTemp.add(new Integer(concurso.getNumero14()));
			listaIntegerTemp.add(new Integer(concurso.getNumero15()));

			concurso.setLstNumerosSorteio(listaIntegerTemp);

			lstConcursoAux.add(new Concurso(concurso));

		}
		
		return lstConcursoAux;
		
	}
	
}
