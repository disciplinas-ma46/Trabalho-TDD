package estruturaEvolucoes;

import java.util.ArrayList;

public class Evolucoes {
	public final ArrayList<ArrayList<Object>> evolucoes = new ArrayList<ArrayList<Object>>();
	
	public int adicionarValor(Object valor) {
		int tamanho = quantidadeEvolucoes();
		if(tamanho == 0) {
			return -1;
		}
		evolucoes.get(tamanho-1).add(valor);
		return quantidadeEvolucoes();
	}
	
	public void adicionarEvolucao() {
		evolucoes.add(new ArrayList<Object>());
	}
	
	public int quantidadeEvolucoes() {
		return evolucoes.size();
	}
	
	public int quantidadeValores(int idxEvolucao) {
		try {
			return evolucoes.get(idxEvolucao).size();
		}
		catch(IndexOutOfBoundsException e) {
			return -1;
		}
	}
	
	public Object getValor(int idxEvolucao, int idxValor) {
		try {
			return evolucoes.get(idxEvolucao).get(idxValor);
			
		}
		catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	public void Show() {
		int i = 0;
		for(ArrayList<Object> evolucao : evolucoes) {
			System.out.println("Evolução " + i);
			for(Object valor : evolucao) {
				System.out.println(valor);
			}
			i++;
		}
	}
	
}
