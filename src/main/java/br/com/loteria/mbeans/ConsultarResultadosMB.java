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
	
	
	private Integer numeroConcursoValidacaoInicial;
	private Integer numeroConcursoValidacaoFinal;


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
		
		// Lista que sera apresentada na tela
		listaResultadoSorteio = new ArrayList<ResultadoSorteio>();

		//Armazenara todos os concursos da analise 
		List<Concurso> lstTodosConcursos;
		
		// Guarda os ID das apostas selecionadas para validar abaixo
		for (MinhaAposta ma : listaMinhasApostas) {
            if (checked.get(ma.getIdAposta())) {
            	this.listaMinhasApostasSelecionadas.add(ma);
            }
        }

		// Verifica se foi selecionada alguma aposta, caso contrario, lanca erro
		if (! this.listaMinhasApostasSelecionadas.isEmpty()){
			
			// Se informou um numero de concurso, recupara todos a partir dessem caso contrario, recupera todos
			if (this.numeroConcursoValidacaoInicial > 0){
				
				// Verifica se tem um final
				if(numeroConcursoValidacaoFinal > 0){
					lstTodosConcursos = new ControleNovoSorteio().recuperarSorteiosEmIntervalosDeConcurso(numeroConcursoValidacaoInicial, numeroConcursoValidacaoFinal);	
				} else {
					lstTodosConcursos = new ControleNovoSorteio().recuperarSorteiosMaioresIguaisPorID(numeroConcursoValidacaoInicial);
				}
			} else {
				lstTodosConcursos = new ControleNovoSorteio().recuperarTodosSorteios();
			}

			// Iniciando validacao
			listaResultadoSorteio = new ControleConsultaResultado().validaAcertosEntreApostaSorteios(listaMinhasApostasSelecionadas, lstTodosConcursos);

			// Limpa variaveis
			checked.clear();
			listaMinhasApostasSelecionadas.clear();
			listaMinhasApostas.clear();
			
			
		} else {
			System.out.println("LANCAR ERRO SELECAO APOSTA NAO REALIZADA");
		}
		
		
		
		
		
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



	/**
	 * @return the numeroConcursoValidacaoInicial
	 */
	public Integer getNumeroConcursoValidacaoInicial() {
		
		if(numeroConcursoValidacaoInicial == null){
			return new Integer(0);
		}

		return numeroConcursoValidacaoInicial;
	}



	/**
	 * @param numeroConcursoValidacaoInicial the numeroConcursoValidacaoInicial to set
	 */
	public void setNumeroConcursoValidacaoInicial(Integer numeroConcursoValidacaoInicial) {
		
		if(numeroConcursoValidacaoInicial == null){
			this.setNumeroConcursoValidacaoInicial(new Integer(0));
		}
		
		this.numeroConcursoValidacaoInicial = numeroConcursoValidacaoInicial;
	}



	/**
	 * @return the numeroConcursoValidacaoFinal
	 */
	public Integer getNumeroConcursoValidacaoFinal() {
		
		if(numeroConcursoValidacaoFinal == null){
			return new Integer(0);
		}
		return numeroConcursoValidacaoFinal;
	}



	/**
	 * @param numeroConcursoValidacaoFinal the numeroConcursoValidacaoFinal to set
	 */
	public void setNumeroConcursoValidacaoFinal(Integer numeroConcursoValidacaoFinal) {
		
		if(numeroConcursoValidacaoFinal == null){
			this.setNumeroConcursoValidacaoFinal(new Integer(0));
		}	

		this.numeroConcursoValidacaoFinal = numeroConcursoValidacaoFinal;
	}
	
	
	
	
}
