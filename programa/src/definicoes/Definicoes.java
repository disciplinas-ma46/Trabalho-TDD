package definicoes;

import exceptions.EscritaNaoPermitidaException;

public class Definicoes {
	
	public Delimitador delimitador;
	public CaminhoSaida saida;
	public FormatoSaida formato;
	
	public Definicoes() {
		delimitador = new Delimitador();
		saida = new CaminhoSaida();
		formato = new FormatoSaida();
	}
	
	//String caminhoSaida, char delimitador, String formato
	public String getCaminhoSaida() {
		return saida.getCaminhoSaida();
	}
	
	public char getDelimitador() {
		return delimitador.getDelimitador();
	}
	
	public String getFormatoSaida() {
		return formato.getFormatoSaida();
	}
	
	public void definirDelimitador() {
		delimitador.definir();
	}
	
	public void definirCaminhoSaida() throws EscritaNaoPermitidaException {
		saida.definir();
	}
	
	public void definirFormatoSaida() {
		formato.definir();
	}
	
	
}

