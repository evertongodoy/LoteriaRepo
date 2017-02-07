package br.com.loteria.mbeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.loteria.controle.ControleTopSorteados;

public class TopSorteadosMB {
	
	public List<Integer> listaTopSorteados = new ArrayList<Integer>();
	
	public TopSorteadosMB() {}
	
	
	public List<Integer> buscarTopSorteados(){
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -4);
		
		return listaTopSorteados = new ControleTopSorteados().recuperaTopSorteados(c.getTime(), new Date());
	}

	
	public static void main(String[] args){
		
		List<Integer> lista = new ArrayList<Integer>();
		
		TopSorteadosMB top = new TopSorteadosMB();
		lista = top.buscarTopSorteados();
		
		
		
		Integer i = 1;
		for (Integer num : lista){
			System.out.println(" numero " + i + " = " + num);
			i++;
		}
		
	}
	
	
	
	
}
