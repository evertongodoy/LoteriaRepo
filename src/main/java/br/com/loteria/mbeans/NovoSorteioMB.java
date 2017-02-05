package br.com.loteria.mbeans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.loteria.beans.Concurso;
import br.com.loteria.beans.NumerosExistentes;
import br.com.loteria.controle.ControleNovoSorteio;

@ManagedBean(name = "novoSorteioMB")
@SessionScoped
public class NovoSorteioMB {

	public NovoSorteioMB() {}

	List<Concurso> listConcurso = new ArrayList<Concurso>();
	
	private List<NumerosExistentes> lstNumerosExistentes = new ArrayList<NumerosExistentes>();
	private Integer numeroSorteio;
	private String dataSorteioSTR;
	private Date dataSorteio;
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
	
	
	
	/**
	 * Metodo responsavel por iniciar o cadastro do sorteio realizando algumas validacoes
	 * @throws Exception 
	 */
	public void prepararCadastroSorteio() throws Exception{

		// Criando um set para evitar numeros duplicados
		Set<Integer> numerosSorteio = new HashSet<Integer>();

		numerosSorteio.add(primeiraPosicao);
		numerosSorteio.add(segundaPosicao);
		numerosSorteio.add(terceiraPosicao);
		numerosSorteio.add(quartaPosicao);
		numerosSorteio.add(quintaPosicao);
		numerosSorteio.add(sextaPosicao);
		numerosSorteio.add(setimaPosicao);
		numerosSorteio.add(oitavaPosicao);
		numerosSorteio.add(nonaPosicao);
		numerosSorteio.add(decimaPosicao);
		numerosSorteio.add(decimaPrimeiraPosicao);
		numerosSorteio.add(decimaSegundaPosicao);
		numerosSorteio.add(decimaTerceiraPosicao);
		numerosSorteio.add(decimaQuartaPosicao);
		numerosSorteio.add(decimaQuintaPosicao);
		
		// Remove nulos
		numerosSorteio.remove(null);

		// Valida se existe 15 numeros
		//if (numerosSorteio.size() != 15) throw new Exception("Existem inconsistencias com os números do sorteio informado");
		
		
		// Data truncada
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataCorrigida = sdf.parse(dataSorteioSTR);


		Concurso concurso = new Concurso(this.numeroSorteio, 
										 sdf.parse(sdf.format(dataCorrigida)), 
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
										 this.decimaQuintaPosicao);
		
		listConcurso.add(concurso);
		
		
		new ControleNovoSorteio().salvarNovoJogo(listConcurso);
		
		// Limpa dados
		//listConcurso.clear();
		this.limparTela();
		
	}
	
	
	/**
	 * Limpa os dados da tela apos cadastro
	 */
	public void limparTela(){

		listConcurso.clear();

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

		this.numeroSorteio = new Integer(0);

	}


	/**
	 * @return the numeroSorteio
	 */
	public Integer getNumeroSorteio() {
		return numeroSorteio;
	}
	/**
	 * @param numeroSorteio the numeroSorteio to set
	 */
	public void setNumeroSorteio(Integer numeroSorteio) {
		this.numeroSorteio = numeroSorteio;
	}
	/**
	 * @return the dataSorteio
	 */
	public Date getDataSorteio() {
		return dataSorteio;
	}
	/**
	 * @param dataSorteio the dataSorteio to set
	 */
	public void setDataSorteio(Date dataSorteio) {
		this.dataSorteio = dataSorteio;
	}
	/**
	 * @return the primeiraPosicao
	 */
	public Integer getPrimeiraPosicao() {
		return primeiraPosicao;
	}
	/**
	 * @param primeiraPosicao the primeiraPosicao to set
	 */
	public void setPrimeiraPosicao(Integer primeiraPosicao) {
		this.primeiraPosicao = primeiraPosicao;
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
	 * @return the oItavaPosicao
	 */
	public Integer getoitavaPosicao() {
		return oitavaPosicao;
	}
	/**
	 * @param oItavaPosicao the oItavaPosicao to set
	 */
	public void setoitavaPosicao(Integer oitavaPosicao) {
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
	 * @return the dataSorteioSTR
	 */
	public String getDataSorteioSTR() {
		return dataSorteioSTR;
	}


	/**
	 * @param dataSorteioSTR the dataSorteioSTR to set
	 */
	public void setDataSorteioSTR(String dataSorteioSTR) {
		this.dataSorteioSTR = dataSorteioSTR;
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
		
	

}
