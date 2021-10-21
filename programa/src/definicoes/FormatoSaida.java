package definicoes;

import exceptions.EscritaNaoPermitidaException;
import main.Uteis;

public class FormatoSaida {
	
	private String formatoSaida = "L";
	
	public String getFormatoSaida() {
		return formatoSaida;
	}
	
	public void definir() {
		boolean valido = false;
		
		System.out.print("Como deseja que as sequencias de tempos \npara cada evolução seja apresentada? [L] linha / [C] coluna: ");
		
		while (true) {
			formatoSaida = Uteis.Input("");
			formatoSaida = formatoSaida.toUpperCase();
			//System.out.println(formatoSaida);
			
			if(formatoSaida.charAt(0) == 'L') {
				formatoSaida = "L";
				return;
			}
			if(formatoSaida.charAt(0) == 'C') {
				formatoSaida = "C";
				return;
			}
			
			System.out.print("Digite 'L' ou 'C': ");
		}
	}
	
	
}
