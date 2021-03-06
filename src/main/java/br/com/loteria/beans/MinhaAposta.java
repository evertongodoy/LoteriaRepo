package br.com.loteria.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="minha_aposta")
@NamedQueries({
	@NamedQuery(name = "MinhaAposta.queryListaMinhasApostasAtivas", query = "Select MA from MinhaAposta MA Where MA.dataEncerramento is null ORDER BY MA.dataCriacao, MA.idAposta DESC")
})
public class MinhaAposta {

	@Id
	@GeneratedValue
	@Column(name="id_aposta")
	private Integer idAposta;
	
	@Column(name="data_criacao", nullable = false)
	private Date dataCriacao;
	
	@Column(name="data_encerramento", nullable = true)
	private Date dataEncerramento;
	
	@Column(name="numero_um", nullable = false)
	private Integer numero1;
	
	@Column(name="numero_dois", nullable = false)
	private Integer numero2;
	
	@Column(name="numero_tres", nullable = false)
	private Integer numero3;
	
	@Column(name="numero_quatro", nullable = false)
	private Integer numero4;
	
	@Column(name="numero_cinco", nullable = false)
	private Integer numero5;
	
	@Column(name="numero_seis", nullable = false)
	private Integer numero6;

	@Column(name="numero_sete", nullable = false)
	private Integer numero7;
	
	@Column(name="numero_oito", nullable = false)
	private Integer numero8;
	
	@Column(name="numero_nove", nullable = false)
	private Integer numero9;
	
	@Column(name="numero_dez", nullable = false)
	private Integer numero10;
	
	@Column(name="numero_onze", nullable = false)
	private Integer numero11;
	
	@Column(name="numero_doze", nullable = false)
	private Integer numero12;
	
	@Column(name="numero_treze", nullable = false)
	private Integer numero13;
	
	@Column(name="numero_quatorze", nullable = false)
	private Integer numero14;
	
	@Column(name="numero_quinze", nullable = false)
	private Integer numero15;
	
	@Column(name="obs", nullable = true, length = 2000)
	private String observacao;
	
	@Transient
	private List<Integer> lstNumerosAposta;
	
	@Transient
	private String numerosAcertados;
	
	@Transient
	private String numerosErrados;
	
	@Transient
	private String totalAcerto;
	
	@Transient
	private String totalErro;
	
	@Transient
	private Double totalGanhoReais;
	
	public MinhaAposta() {}
	
	public MinhaAposta(Date dataCriacao, Date dataEncerramento, Integer n1, Integer n2, Integer n3, Integer n4, Integer n5, Integer n6, Integer n7, Integer n8, Integer n9, Integer n10, Integer n11, Integer n12, Integer n13, Integer n14, Integer n15, String observacao) {
		this.dataCriacao = dataCriacao;
		this.dataEncerramento = dataEncerramento;
		this.numero1 = n1;
		this.numero2 = n2;
		this.numero3 = n3;
		this.numero4 = n4;
		this.numero5 = n5;
		this.numero6 = n6;
		this.numero7 = n7;
		this.numero8 = n8;
		this.numero9 = n9;
		this.numero10 = n10;
		this.numero11 = n11;
		this.numero12 = n12;
		this.numero13 = n13;
		this.numero14 = n14;
		this.numero15 = n15;
		this.observacao = observacao;
	}

	/**
	 * Contrutor para manter os valores originais da minha aposta
	 * @param ma
	 */
	public MinhaAposta(MinhaAposta ma){
		this.idAposta = ma.getIdAposta();
		this.dataCriacao = ma.getDataCriacao();
		this.dataEncerramento = ma.getDataCriacao();
		this.lstNumerosAposta = ma.getLstNumerosAposta();
		this.numero1 = ma.getNumero1();
		this.numero2 = ma.getNumero2();
		this.numero3 = ma.getNumero3();
		this.numero4 = ma.getNumero4();
		this.numero5 = ma.getNumero5();
		this.numero6 = ma.getNumero6();
		this.numero7 = ma.getNumero7();
		this.numero8 = ma.getNumero8();
		this.numero9 = ma.getNumero9();
		this.numero10 = ma.getNumero10();
		this.numero11 = ma.getNumero11();
		this.numero12 = ma.getNumero12();
		this.numero13 = ma.getNumero13();
		this.numero14 = ma.getNumero14();
		this.numero15 = ma.getNumero15();
		this.observacao = ma.getObservacao();
		this.setTotalGanhoReais(ma.getTotalGanhoReais());
		this.setTotalAcerto(ma.getTotalAcerto());
		this.setTotalErro(ma.getTotalErro());
		this.setNumerosAcertados(ma.getNumerosAcertados());
		this.setNumerosErrados(ma.getNumerosErrados());
	}
	
	
	
	/**
	 * @return the idAposta
	 */
	public Integer getIdAposta() {
		return idAposta;
	}

	/**
	 * @param idAposta the idAposta to set
	 */
	public void setIdAposta(Integer idAposta) {
		this.idAposta = idAposta;
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
	 * @return the numero1
	 */
	public Integer getNumero1() {
		return numero1;
	}

	/**
	 * @param numero1 the numero1 to set
	 */
	public void setNumero1(Integer numero1) {
		this.numero1 = numero1;
	}

	/**
	 * @return the numero2
	 */
	public Integer getNumero2() {
		return numero2;
	}

	/**
	 * @param numero2 the numero2 to set
	 */
	public void setNumero2(Integer numero2) {
		this.numero2 = numero2;
	}

	/**
	 * @return the numero3
	 */
	public Integer getNumero3() {
		return numero3;
	}

	/**
	 * @param numero3 the numero3 to set
	 */
	public void setNumero3(Integer numero3) {
		this.numero3 = numero3;
	}

	/**
	 * @return the numero4
	 */
	public Integer getNumero4() {
		return numero4;
	}

	/**
	 * @param numero4 the numero4 to set
	 */
	public void setNumero4(Integer numero4) {
		this.numero4 = numero4;
	}

	/**
	 * @return the numero5
	 */
	public Integer getNumero5() {
		return numero5;
	}

	/**
	 * @param numero5 the numero5 to set
	 */
	public void setNumero5(Integer numero5) {
		this.numero5 = numero5;
	}

	/**
	 * @return the numero6
	 */
	public Integer getNumero6() {
		return numero6;
	}

	/**
	 * @param numero6 the numero6 to set
	 */
	public void setNumero6(Integer numero6) {
		this.numero6 = numero6;
	}

	/**
	 * @return the numero7
	 */
	public Integer getNumero7() {
		return numero7;
	}

	/**
	 * @param numero7 the numero7 to set
	 */
	public void setNumero7(Integer numero7) {
		this.numero7 = numero7;
	}

	/**
	 * @return the numero8
	 */
	public Integer getNumero8() {
		return numero8;
	}

	/**
	 * @param numero8 the numero8 to set
	 */
	public void setNumero8(Integer numero8) {
		this.numero8 = numero8;
	}

	/**
	 * @return the numero9
	 */
	public Integer getNumero9() {
		return numero9;
	}

	/**
	 * @param numero9 the numero9 to set
	 */
	public void setNumero9(Integer numero9) {
		this.numero9 = numero9;
	}

	/**
	 * @return the numero10
	 */
	public Integer getNumero10() {
		return numero10;
	}

	/**
	 * @param numero10 the numero10 to set
	 */
	public void setNumero10(Integer numero10) {
		this.numero10 = numero10;
	}

	/**
	 * @return the numero11
	 */
	public Integer getNumero11() {
		return numero11;
	}

	/**
	 * @param numero11 the numero11 to set
	 */
	public void setNumero11(Integer numero11) {
		this.numero11 = numero11;
	}

	/**
	 * @return the numero12
	 */
	public Integer getNumero12() {
		return numero12;
	}

	/**
	 * @param numero12 the numero12 to set
	 */
	public void setNumero12(Integer numero12) {
		this.numero12 = numero12;
	}

	/**
	 * @return the numero13
	 */
	public Integer getNumero13() {
		return numero13;
	}

	/**
	 * @param numero13 the numero13 to set
	 */
	public void setNumero13(Integer numero13) {
		this.numero13 = numero13;
	}

	/**
	 * @return the numero14
	 */
	public Integer getNumero14() {
		return numero14;
	}

	/**
	 * @param numero14 the numero14 to set
	 */
	public void setNumero14(Integer numero14) {
		this.numero14 = numero14;
	}

	/**
	 * @return the numero15
	 */
	public Integer getNumero15() {
		return numero15;
	}

	/**
	 * @param numero15 the numero15 to set
	 */
	public void setNumero15(Integer numero15) {
		this.numero15 = numero15;
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

	/**
	 * @return the lstNumerosAposta
	 */
	@Transient
	public List<Integer> getLstNumerosAposta() {
		return lstNumerosAposta;
	}
	
	

	/**
	 * @param lstNumerosAposta the lstNumerosAposta to set
	 */
	@Transient
	public void setLstNumerosAposta(List<Integer> lstNumerosAposta) {
		this.lstNumerosAposta = lstNumerosAposta;
	}

	
	
	/**
	 * @return the numerosAcertados
	 */
	@Transient
	public String getNumerosAcertados() {
		return numerosAcertados;
	}

	/**
	 * @param numerosAcertados the numerosAcertados to set
	 */
	@Transient
	public void setNumerosAcertados(String numerosAcertados) {
		this.numerosAcertados = numerosAcertados;
	}

	/**
	 * @return the numerosErrados
	 */
	public String getNumerosErrados() {
		return numerosErrados;
	}

	/**
	 * @param numerosErrados the numerosErrados to set
	 */
	public void setNumerosErrados(String numerosErrados) {
		this.numerosErrados = numerosErrados;
	}
	
	/**
	 * @return the totalAcerto
	 */
	public String getTotalAcerto() {
		return totalAcerto;
	}

	/**
	 * @param totalAcerto the totalAcerto to set
	 */
	public void setTotalAcerto(String totalAcerto) {
		this.totalAcerto = totalAcerto;
	}

	/**
	 * @return the totalErro
	 */
	public String getTotalErro() {
		return totalErro;
	}

	/**
	 * @param totalErros the totalErros to set
	 */
	public void setTotalErro(String totalErro) {
		this.totalErro = totalErro;
	}

	

	/**
	 * @return the totalGanhoReais
	 */
	public Double getTotalGanhoReais() {
		return totalGanhoReais;
	}

	/**
	 * @param totalGanhoReais the totalGanhoReais to set
	 */
	public void setTotalGanhoReais(Double totalGanhoReais) {
		this.totalGanhoReais = totalGanhoReais;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataEncerramento == null) ? 0 : dataEncerramento.hashCode());
		result = prime * result + ((idAposta == null) ? 0 : idAposta.hashCode());
		result = prime * result + ((numero1 == null) ? 0 : numero1.hashCode());
		result = prime * result + ((numero10 == null) ? 0 : numero10.hashCode());
		result = prime * result + ((numero11 == null) ? 0 : numero11.hashCode());
		result = prime * result + ((numero12 == null) ? 0 : numero12.hashCode());
		result = prime * result + ((numero13 == null) ? 0 : numero13.hashCode());
		result = prime * result + ((numero14 == null) ? 0 : numero14.hashCode());
		result = prime * result + ((numero15 == null) ? 0 : numero15.hashCode());
		result = prime * result + ((numero2 == null) ? 0 : numero2.hashCode());
		result = prime * result + ((numero3 == null) ? 0 : numero3.hashCode());
		result = prime * result + ((numero4 == null) ? 0 : numero4.hashCode());
		result = prime * result + ((numero5 == null) ? 0 : numero5.hashCode());
		result = prime * result + ((numero6 == null) ? 0 : numero6.hashCode());
		result = prime * result + ((numero7 == null) ? 0 : numero7.hashCode());
		result = prime * result + ((numero8 == null) ? 0 : numero8.hashCode());
		result = prime * result + ((numero9 == null) ? 0 : numero9.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MinhaAposta other = (MinhaAposta) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataEncerramento == null) {
			if (other.dataEncerramento != null)
				return false;
		} else if (!dataEncerramento.equals(other.dataEncerramento))
			return false;
		if (idAposta == null) {
			if (other.idAposta != null)
				return false;
		} else if (!idAposta.equals(other.idAposta))
			return false;
		if (numero1 == null) {
			if (other.numero1 != null)
				return false;
		} else if (!numero1.equals(other.numero1))
			return false;
		if (numero10 == null) {
			if (other.numero10 != null)
				return false;
		} else if (!numero10.equals(other.numero10))
			return false;
		if (numero11 == null) {
			if (other.numero11 != null)
				return false;
		} else if (!numero11.equals(other.numero11))
			return false;
		if (numero12 == null) {
			if (other.numero12 != null)
				return false;
		} else if (!numero12.equals(other.numero12))
			return false;
		if (numero13 == null) {
			if (other.numero13 != null)
				return false;
		} else if (!numero13.equals(other.numero13))
			return false;
		if (numero14 == null) {
			if (other.numero14 != null)
				return false;
		} else if (!numero14.equals(other.numero14))
			return false;
		if (numero15 == null) {
			if (other.numero15 != null)
				return false;
		} else if (!numero15.equals(other.numero15))
			return false;
		if (numero2 == null) {
			if (other.numero2 != null)
				return false;
		} else if (!numero2.equals(other.numero2))
			return false;
		if (numero3 == null) {
			if (other.numero3 != null)
				return false;
		} else if (!numero3.equals(other.numero3))
			return false;
		if (numero4 == null) {
			if (other.numero4 != null)
				return false;
		} else if (!numero4.equals(other.numero4))
			return false;
		if (numero5 == null) {
			if (other.numero5 != null)
				return false;
		} else if (!numero5.equals(other.numero5))
			return false;
		if (numero6 == null) {
			if (other.numero6 != null)
				return false;
		} else if (!numero6.equals(other.numero6))
			return false;
		if (numero7 == null) {
			if (other.numero7 != null)
				return false;
		} else if (!numero7.equals(other.numero7))
			return false;
		if (numero8 == null) {
			if (other.numero8 != null)
				return false;
		} else if (!numero8.equals(other.numero8))
			return false;
		if (numero9 == null) {
			if (other.numero9 != null)
				return false;
		} else if (!numero9.equals(other.numero9))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}
	
	


	
	

}
