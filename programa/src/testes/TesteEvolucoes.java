package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import estruturaEvolucoes.EvolucoesMemory;

public class TesteEvolucoes {
	
	EvolucoesMemory memoria = new EvolucoesMemory();

	@Test
	public void memoryVazia() {
		assertEquals(0, memoria.quantidadeEvolucoes());
	}
	
	@Test
	public void memoryAdicionarEvolucoes() {
		memoria.adicionarEvolucao();
		memoria.adicionarEvolucao();
		memoria.adicionarEvolucao();
		
		assertEquals(3, memoria.quantidadeEvolucoes());
	}
	
	@Test
	public void memoryQuantidadeValores() {
		assertEquals(-1, memoria.quantidadeValores(0));
		
		memoria.adicionarEvolucao();
		assertEquals(0, memoria.quantidadeValores(0));
		
		Integer valor = 5;
		memoria.adicionarValor((Object) valor);
		assertEquals(1, memoria.quantidadeValores(0));
		
	}
	
	@Test
	public void memoryAdicionarValores() {

		memoria.adicionarEvolucao();
		assertEquals(0, memoria.quantidadeValores(0));
		
		Integer valor = 5;
		memoria.adicionarValor((Object) valor);
		memoria.adicionarValor((Object) valor);
		memoria.adicionarValor((Object) valor);
		
		assertEquals(3, memoria.quantidadeValores(0));
		
		memoria.adicionarEvolucao();
		memoria.adicionarValor((Object) valor);
		assertEquals(1, memoria.quantidadeValores(1));
		
		
	}

}
