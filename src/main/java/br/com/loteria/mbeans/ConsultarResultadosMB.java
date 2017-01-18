package br.com.loteria.mbeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.loteria.beans.Concurso;
import br.com.loteria.beans.MinhaAposta;
import br.com.loteria.beans.ResultadoSorteio;
import br.com.loteria.controle.ControleConsultaResultado;
import br.com.loteria.controle.ControleMinhaAposta;
import br.com.loteria.controle.ControleNovoSorteio;

@ManagedBean(name = "consultarResultadosMB")
@SessionScoped
public class ConsultarResultadosMB {
	
	public ConsultarResultadosMB() {}
	
	private List<MinhaAposta> listaMinhasApostas;
	
	// Trata as Selecoes das apostas
	private Map<Integer, Boolean> checked = new HashMap<Integer, Boolean>();
	private List<MinhaAposta> listaMinhasApostasSelecionadas = new ArrayList<MinhaAposta>();
	private List<ResultadoSorteio> listaResultadoSorteio;
	


	/**
	 * Prepara o inicio da busca de todas as minhas apostas
	 */
	public void prepararListaMinhasApostas(){
		
		listaMinhasApostas = new ControleMinhaAposta().recuperaMinhasApostas();

	}
	

	
	/**
	 * Prepara o procedimento de conferencia das apostas e sorteios
	 */
	public void prepararConferenciaDeAcertosApostas(){
		
		listaResultadoSorteio = new ArrayList<ResultadoSorteio>();

		for (MinhaAposta ma : listaMinhasApostas) {
            if (checked.get(ma.getIdAposta())) {
            	listaMinhasApostasSelecionadas.add(ma);
            }
        }

		for(MinhaAposta ma : listaMinhasApostasSelecionadas){
			System.out.println("APOSTA SELECIONADA ID = " + ma.getIdAposta() + " E DATA " + ma.getDataCriacao() );
		}
		
		// ANTES, colocar aquim uam validacao para saber se foi selecionado alguma coisa.. e o codigo acima vou deletar.. era so pra teste
		List<Concurso> lstTodosConcursos = new ControleNovoSorteio().recuperarTodosSorteios();
		
		
		// Inicia validacao
		listaResultadoSorteio = new ControleConsultaResultado().validaAcertosEntreApostaSorteios(listaMinhasApostasSelecionadas, lstTodosConcursos);
		
		/*
		for(ResultadoSorteio rs : listaResultadoSorteio){
			rs.getConcursoGanhador().getLstNumerosSorteio().size()
		}
		*/
		
		// Limpa variaveis
		checked.clear();
		listaMinhasApostasSelecionadas.clear();
		listaMinhasApostas.clear();
		
		
		
	}
	
	

	
	
	/**
	 * @return the listaMinhasApostas
	 */
	public List<MinhaAposta> getListaMinhasApostas() {
		return listaMinhasApostas;
	}

	/**
	 * @param listaMinhasApostas the listaMinhasApostas to set
	 */
	public void setListaMinhasApostas(List<MinhaAposta> listaMinhasApostas) {
		this.listaMinhasApostas = listaMinhasApostas;
	}



	/**
	 * @return the checked
	 */
	public Map<Integer, Boolean> getChecked() {
		return checked;
	}



	/**
	 * @param checked the checked to set
	 */
	public void setChecked(Map<Integer, Boolean> checked) {
		this.checked = checked;
	}

	/**
	 * @return the listaREsultadoSorteio
	 */
	public List<ResultadoSorteio> getListaResultadoSorteio() {
		return listaResultadoSorteio;
	}

	/**
	 * @param listaREsultadoSorteio the listaREsultadoSorteio to set
	 */
	public void setListaREsultadoSorteio(List<ResultadoSorteio> listaResultadoSorteio) {
		this.listaResultadoSorteio = listaResultadoSorteio;
	}
	
	
	
	
}
