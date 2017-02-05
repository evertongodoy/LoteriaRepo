package br.com.loteria.mbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.loteria.beans.MinhaAposta;
import br.com.loteria.beans.NumerosExistentes;
import br.com.loteria.controle.ControleMinhaAposta;

@ManagedBean(name = "meusJogosMB")
@SessionScoped
public class MeusJogosMB {

	public MeusJogosMB() {}
	
	private List<NumerosExistentes> lstNumerosExistentes = new ArrayList<NumerosExistentes>();
	
	private Date dataCriacao;
	private Date dataEncerramento;
	private Integer primeiraPosicao;
	private Integer segundaPosicao;
	private Integer terceiraPosicao;
	private Integer quartaPosicao;
	private Integer quintaPosicao;
	private Integer sextaPosicao;
	private Integer setimaPosicao;
	private Integer oitavaPosicao;
	private Integer nonaPosicao;
	private Integer decimaPosicao;
	private Integer decimaPrimeiraPosicao;
	private Integer decimaSegundaPosicao;
	private Integer decimaTerceiraPosicao;
	private Integer decimaQuartaPosicao;
	private Integer decimaQuintaPosicao;
	private String observacao;
	
	
	/**
	 * Metodo responsavel pelo inicio do tratamento dos dados do usuario pra insercao
	 * @throws Exception 
	 */
	public void cadastrarMeuJogo() throws Exception{
		
		Set<Integer> numerosUsuario = new HashSet<Integer>();
		
		numerosUsuario.clear();
		
		numerosUsuario.add(primeiraPosicao);
		numerosUsuario.add(segundaPosicao);
		numerosUsuario.add(terceiraPosicao);
		numerosUsuario.add(quartaPosicao);
		numerosUsuario.add(quintaPosicao);
		numerosUsuario.add(sextaPosicao);
		numerosUsuario.add(setimaPosicao);
		numerosUsuario.add(oitavaPosicao);
		numerosUsuario.add(nonaPosicao);
		numerosUsuario.add(decimaPosicao);
		numerosUsuario.add(decimaPrimeiraPosicao);
		numerosUsuario.add(decimaSegundaPosicao);
		numerosUsuario.add(decimaTerceiraPosicao);
		numerosUsuario.add(decimaQuartaPosicao);
		numerosUsuario.add(decimaQuintaPosicao);
		
		// Remove nulos
		numerosUsuario.remove(null);

		// Valida se existe 15 numeros
		//if (numerosUsuario.size() != 15) throw new Exception("Existem inconsistencias com os números da aposta informada");
		
		MinhaAposta ma = new MinhaAposta(new Date(), 
										 null,
										 this.primeiraPosicao, 
										 this.segundaPosicao, 
										 this.terceiraPosicao, 
										 this.quartaPosicao, 
										 this.quintaPosicao, 
										 this.sextaPosicao, 
										 this.setimaPosicao, 
										 this.oitavaPosicao, 
										 this.nonaPosicao, 
										 this.decimaPosicao, 
										 this.decimaPrimeiraPosicao, 
										 this.decimaSegundaPosicao, 
										 this.decimaTerceiraPosicao, 
										 this.decimaQuartaPosicao, 
										 this.decimaQuintaPosicao,
										 this.observacao);
		
		new ControleMinhaAposta().salvarMinhaAposta(ma);
		
		this.limparTela();
		
	}
	
	
	/**
	 * Limpa os dados da tela apos cadastro
	 */
	public void limparTela(){

		this.primeiraPosicao = 1;
		this.segundaPosicao = 2;
		this.terceiraPosicao = 3;
		this.quartaPosicao = 4;
		this.quintaPosicao = 5;
		this.sextaPosicao = 6;
		this.setimaPosicao = 7;
		this.oitavaPosicao = 8;
		this.nonaPosicao = 9;
		this.decimaPosicao = 10;
		this.decimaPrimeiraPosicao = 11;
		this.decimaSegundaPosicao = 12;
		this.decimaTerceiraPosicao = 13;
		this.decimaQuartaPosicao = 14;
		this.decimaQuintaPosicao = 15;

		this.observacao = "";

	}
	
	
	
	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @return the dataEncerramento
	 */
	public Date getDataEncerramento() {
		return dataEncerramento;
	}




	/**
	 * @param dataEncerramento the dataEncerramento to set
	 */
	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}




	/**
	 * @param primeiraPosicao the primeiraPosicao to set
	 */
	public void setPrimeiraPosicao(Integer primeiraPosicao) {
		this.primeiraPosicao = primeiraPosicao;
	}
	
	/**
	 * @return the primeiraPosicao
	 */
	public Integer getPrimeiraPosicao() {
		return primeiraPosicao;
	}
	
	/**
	 * @return the segundaPosicao
	 */
	public Integer getSegundaPosicao() {
		return segundaPosicao;
	}

	/**
	 * @param segundaPosicao the segundaPosicao to set
	 */
	public void setSegundaPosicao(Integer segundaPosicao) {
		this.segundaPosicao = segundaPosicao;
	}

	/**
	 * @return the terceiraPosicao
	 */
	public Integer getTerceiraPosicao() {
		return terceiraPosicao;
	}

	/**
	 * @param terceiraPosicao the terceiraPosicao to set
	 */
	public void setTerceiraPosicao(Integer terceiraPosicao) {
		this.terceiraPosicao = terceiraPosicao;
	}

	/**
	 * @return the quartaPosicao
	 */
	public Integer getQuartaPosicao() {
		return quartaPosicao;
	}

	/**
	 * @param quartaPosicao the quartaPosicao to set
	 */
	public void setQuartaPosicao(Integer quartaPosicao) {
		this.quartaPosicao = quartaPosicao;
	}

	/**
	 * @return the quintaPosicao
	 */
	public Integer getQuintaPosicao() {
		return quintaPosicao;
	}

	/**
	 * @param quintaPosicao the quintaPosicao to set
	 */
	public void setQuintaPosicao(Integer quintaPosicao) {
		this.quintaPosicao = quintaPosicao;
	}

	/**
	 * @return the sextaPosicao
	 */
	public Integer getSextaPosicao() {
		return sextaPosicao;
	}

	/**
	 * @param sextaPosicao the sextaPosicao to set
	 */
	public void setSextaPosicao(Integer sextaPosicao) {
		this.sextaPosicao = sextaPosicao;
	}

	/**
	 * @return the setimaPosicao
	 */
	public Integer getSetimaPosicao() {
		return setimaPosicao;
	}

	/**
	 * @param setimaPosicao the setimaPosicao to set
	 */
	public void setSetimaPosicao(Integer setimaPosicao) {
		this.setimaPosicao = setimaPosicao;
	}

	/**
	 * @return the outavaPosicao
	 */
	public Integer getOitavaPosicao() {
		return oitavaPosicao;
	}

	/**
	 * @param outavaPosicao the outavaPosicao to set
	 */
	public void setOitavaPosicao(Integer oitavaPosicao) {
		this.oitavaPosicao = oitavaPosicao;
	}

	/**
	 * @return the nonaPosicao
	 */
	public Integer getNonaPosicao() {
		return nonaPosicao;
	}

	/**
	 * @param nonaPosicao the nonaPosicao to set
	 */
	public void setNonaPosicao(Integer nonaPosicao) {
		this.nonaPosicao = nonaPosicao;
	}

	/**
	 * @return the decimaPosicao
	 */
	public Integer getDecimaPosicao() {
		return decimaPosicao;
	}

	/**
	 * @param decimaPosicao the decimaPosicao to set
	 */
	public void setDecimaPosicao(Integer decimaPosicao) {
		this.decimaPosicao = decimaPosicao;
	}

	/**
	 * @return the decimaPrimeiraPosicao
	 */
	public Integer getDecimaPrimeiraPosicao() {
		return decimaPrimeiraPosicao;
	}

	/**
	 * @param decimaPrimeiraPosicao the decimaPrimeiraPosicao to set
	 */
	public void setDecimaPrimeiraPosicao(Integer decimaPrimeiraPosicao) {
		this.decimaPrimeiraPosicao = decimaPrimeiraPosicao;
	}

	/**
	 * @return the decimaSegundaPosicao
	 */
	public Integer getDecimaSegundaPosicao() {
		return decimaSegundaPosicao;
	}

	/**
	 * @param decimaSegundaPosicao the decimaSegundaPosicao to set
	 */
	public void setDecimaSegundaPosicao(Integer decimaSegundaPosicao) {
		this.decimaSegundaPosicao = decimaSegundaPosicao;
	}

	/**
	 * @return the decimaTerceiraPosicao
	 */
	public Integer getDecimaTerceiraPosicao() {
		return decimaTerceiraPosicao;
	}

	/**
	 * @param decimaTerceiraPosicao the decimaTerceiraPosicao to set
	 */
	public void setDecimaTerceiraPosicao(Integer decimaTerceiraPosicao) {
		this.decimaTerceiraPosicao = decimaTerceiraPosicao;
	}

	/**
	 * @return the decimaQuartaPosicao
	 */
	public Integer getDecimaQuartaPosicao() {
		return decimaQuartaPosicao;
	}

	/**
	 * @param decimaQuartaPosicao the decimaQuartaPosicao to set
	 */
	public void setDecimaQuartaPosicao(Integer decimaQuartaPosicao) {
		this.decimaQuartaPosicao = decimaQuartaPosicao;
	}

	/**
	 * @return the decimaQuintaPosicao
	 */
	public Integer getDecimaQuintaPosicao() {
		return decimaQuintaPosicao;
	}

	/**
	 * @param decimaQuintaPosicao the decimaQuintaPosicao to set
	 */
	public void setDecimaQuintaPosicao(Integer decimaQuintaPosicao) {
		this.decimaQuintaPosicao = decimaQuintaPosicao;
	}
	
	/**
	 * @return the lstNumerosExistentes
	 */
	public List<NumerosExistentes> getLstNumerosExistentes() {
		
		lstNumerosExistentes.clear();
		
		lstNumerosExistentes.add(new NumerosExistentes(1, "1"));
		lstNumerosExistentes.add(new NumerosExistentes(2, "2"));
		lstNumerosExistentes.add(new NumerosExistentes(3, "3"));
		lstNumerosExistentes.add(new NumerosExistentes(4, "4"));
		lstNumerosExistentes.add(new NumerosExistentes(5, "5"));
		lstNumerosExistentes.add(new NumerosExistentes(6, "6"));
		lstNumerosExistentes.add(new NumerosExistentes(7, "7"));
		lstNumerosExistentes.add(new NumerosExistentes(8, "8"));
		lstNumerosExistentes.add(new NumerosExistentes(9, "9"));
		lstNumerosExistentes.add(new NumerosExistentes(10, "10"));
		lstNumerosExistentes.add(new NumerosExistentes(11, "11"));
		lstNumerosExistentes.add(new NumerosExistentes(12, "12"));
		lstNumerosExistentes.add(new NumerosExistentes(13, "13"));
		lstNumerosExistentes.add(new NumerosExistentes(14, "14"));
		lstNumerosExistentes.add(new NumerosExistentes(15, "15"));
		lstNumerosExistentes.add(new NumerosExistentes(16, "16"));
		lstNumerosExistentes.add(new NumerosExistentes(17, "17"));
		lstNumerosExistentes.add(new NumerosExistentes(18, "18"));
		lstNumerosExistentes.add(new NumerosExistentes(19, "19"));
		lstNumerosExistentes.add(new NumerosExistentes(20, "20"));
		lstNumerosExistentes.add(new NumerosExistentes(21, "21"));
		lstNumerosExistentes.add(new NumerosExistentes(22, "22"));
		lstNumerosExistentes.add(new NumerosExistentes(23, "23"));
		lstNumerosExistentes.add(new NumerosExistentes(24, "24"));
		lstNumerosExistentes.add(new NumerosExistentes(25, "25"));
		
		return lstNumerosExistentes;
	}




	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}




	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	
	
	
	

}
