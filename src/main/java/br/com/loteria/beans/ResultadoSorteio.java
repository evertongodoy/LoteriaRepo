package br.com.loteria.beans;

public class ResultadoSorteio {

	private MinhaAposta minhaApostaGanhadora = new MinhaAposta();
	private Concurso concursoGanhador = new Concurso();
	
	public ResultadoSorteio() {}
	
	public ResultadoSorteio(MinhaAposta ma, Concurso concurso) {
		this.minhaApostaGanhadora = ma;
		this.concursoGanhador = concurso;
	}

	/**
	 * @return the minhaApostaGanhadora
	 */
	public MinhaAposta getMinhaApostaGanhadora() {
		return minhaApostaGanhadora;
	}

	/**
	 * @param minhaApostaGanhadora the minhaApostaGanhadora to set
	 */
	public void setMinhaApostaGanhadora(MinhaAposta minhaApostaGanhadora) {
		this.minhaApostaGanhadora = minhaApostaGanhadora;
	}

	/**
	 * @return the concursoGanhador
	 */
	public Concurso getConcursoGanhador() {
		return concursoGanhador;
	}

	/**
	 * @param concursoGanhador the concursoGanhador to set
	 */
	public void setConcursoGanhador(Concurso concursoGanhador) {
		this.concursoGanhador = concursoGanhador;
	}

	
	
	
}
