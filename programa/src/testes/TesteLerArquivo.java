package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import estruturaEvolucoes.EvolucoesMemory;
import estruturaEvolucoes.EvolucoesTime;
import exceptions.ArquivoNaoEncontradoException;
import main.Menu;

public class TesteLerArquivo {
	EvolucoesMemory memories = new EvolucoesMemory();
	EvolucoesTime times = new EvolucoesTime();
	Menu menu = new Menu();
	
	@Test
	public void abrirAnalysisMemory() throws ArquivoNaoEncontradoException {
		assertEquals(21, menu.lerArquivo(memories));
		//memories.Show();
	}
	
	@Test
	public void abrirAnalysisTime() throws ArquivoNaoEncontradoException {
		assertEquals(21, menu.lerArquivo(times));
		//times.Show();
	}

	@Test(expected = ArquivoNaoEncontradoException.class)
	public void abrirDesconhecido() throws ArquivoNaoEncontradoException {
		memories.setNomeEntrada("ArquivoQualquer.out");
		assertEquals(21, menu.lerArquivo(memories));
	}

}
