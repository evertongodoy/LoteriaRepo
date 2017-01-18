package br.com.loteria.controle;

import java.util.ArrayList;
import java.util.List;

import br.com.loteria.beans.Concurso;
import br.com.loteria.beans.MinhaAposta;
import br.com.loteria.beans.ResultadoSorteio;

public class ControleConsultaResultado {

	public ControleConsultaResultado() {}
	
	private static List<Integer> listaNumerosMinhaApostaOriginal = new ArrayList<Integer>();
	

	public List<ResultadoSorteio> validaAcertosEntreApostaSorteios(List<MinhaAposta> listaMinhasApostas, List<Concurso> listaConcursos){
		
		List<MinhaAposta> lstMinhasApostasAux = new ArrayList<MinhaAposta>();
		
		List<Concurso> lstConcursoAux = new ArrayList<Concurso>();
		
		List<ResultadoSorteio> listaREsultadoSorteio = new ArrayList<ResultadoSorteio>();
		
		
		// 1 - Cria a lista de numeros para a minha aposta
		for(MinhaAposta ma : listaMinhasApostas){
			
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
			
			lstMinhasApostasAux.add(ma);
			
		}
		
		
		// 2 - Cria a lista de numeros para o sorteio
		for(Concurso concurso : listaConcursos){
			
			List<Integer> listaIntegerTemp = new ArrayList<Integer>();
			
			listaIntegerTemp.add(concurso.getNumero1());
			listaIntegerTemp.add(concurso.getNumero2());
			listaIntegerTemp.add(concurso.getNumero3());
			listaIntegerTemp.add(concurso.getNumero4());
			listaIntegerTemp.add(concurso.getNumero5());
			listaIntegerTemp.add(concurso.getNumero6());
			listaIntegerTemp.add(concurso.getNumero7());
			listaIntegerTemp.add(concurso.getNumero8());
			listaIntegerTemp.add(concurso.getNumero9());
			listaIntegerTemp.add(concurso.getNumero10());
			listaIntegerTemp.add(concurso.getNumero11());
			listaIntegerTemp.add(concurso.getNumero12());
			listaIntegerTemp.add(concurso.getNumero13());
			listaIntegerTemp.add(concurso.getNumero14());
			listaIntegerTemp.add(concurso.getNumero15());
			
			concurso.setLstNumerosSorteio(listaIntegerTemp);
			
			lstConcursoAux.add(concurso);
			
		}
		
		// Listas ja populadas. Limpar e Reiniciar as originais
		listaMinhasApostas.clear(); 
		listaConcursos.clear();
		
		listaMinhasApostas.addAll(lstMinhasApostasAux);
		listaConcursos.addAll(lstConcursoAux);
		
		
		
		
		// 3 - Aplica validacao. Percorre cada aposta minha para comparar com todos os sorteios
		for(MinhaAposta ma : listaMinhasApostas){
			// Backup original para nao perder os valroes origianis da minha aposta	
			listaNumerosMinhaApostaOriginal.clear();
			for(Integer n : ma.getLstNumerosAposta()){
				listaNumerosMinhaApostaOriginal.add(n);
			}
			
			for(Concurso concurso : listaConcursos){
				
				// Reter sempre da minha lista de numeros da aposta original
				concurso.getLstNumerosSorteio().retainAll(listaNumerosMinhaApostaOriginal);
				concurso.getLstNumerosSorteio().remove(null);
				if(concurso.getLstNumerosSorteio().size() >= 11){
					
					String[] retorno = this.retornaNumerosAcertosErros(listaNumerosMinhaApostaOriginal, concurso);
					
					ma.setNumerosAcertados(retorno[2]);
					ma.setTotalAcerto(retorno[3]);
					
					ma.setNumerosErrados(retorno[0]);
					ma.setTotalErro(retorno[1]);
					
					if(ma.getTotalAcerto().equals("11")){
						ma.setTotalGanhoReais(4.00d);
					} else if (ma.getTotalAcerto().equals("12")){
						ma.setTotalGanhoReais(8.00d);
					} else if(ma.getTotalAcerto().equals("13")){
						ma.setTotalGanhoReais(20.00d);
					} else if(Integer.parseInt(ma.getTotalAcerto()) > 13 ){
						ma.setTotalGanhoReais(99.99d);
					} 

					ResultadoSorteio rs = new ResultadoSorteio(new MinhaAposta(ma), new Concurso(concurso));
					listaREsultadoSorteio.add(rs);
					
				}

			}
			
		}

		return listaREsultadoSorteio;
		
	}
	
	                                         // MinhaAposta maAnalise
	private String[] retornaNumerosAcertosErros(List<Integer> lstMinhaAposta, Concurso concursoAnalise){
		
		String[] totalCertoErrado = new String[4];
		
		//List<Integer> numApostaAux = new ArrayList<Integer>();
		//numApostaAux.addAll(maAnalise.getLstNumerosAposta());
		
		List<Integer> listaNova = new ArrayList<Integer>();
		
		for(Integer i : lstMinhaAposta){
			listaNova.add(i);
		}
		
		
		String ok = "";
		String nOk = "";

		// Corretos
		
		Integer i = 0;
		for(Integer numero : concursoAnalise.getLstNumerosSorteio()){
			if(ok == ""){
				ok = numero.toString();
				i++;
			} else {
				ok = ok + ", " + numero.toString();
				i++;
			}
		}
		
		totalCertoErrado[2] = ok;
		totalCertoErrado[3] = i.toString();

		
		// Incorretos
		
		//ma.getLstNumerosAposta().removeAll(concurso.getLstNumerosSorteio());
		//numApostaAux.removeAll(concursoAnalise.getLstNumerosSorteio());
		//maAnalise.getLstNumerosAposta().removeAll(concursoAnalise.getLstNumerosSorteio());
		listaNova.removeAll(concursoAnalise.getLstNumerosSorteio());
		
		Integer j = 0;
		for(Integer numero : listaNova/*numApostaAux  ma.getLstNumerosAposta()*/){
			if(nOk == ""){
				nOk = numero.toString();
				j++;
			} else {
				nOk = nOk + ", " + numero.toString();
				j++;
			}
		}
		
		totalCertoErrado[0] = nOk;
		totalCertoErrado[1] = j.toString();

		return totalCertoErrado;
	}
	
	
}
