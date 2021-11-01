package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import estruturaEvolucoes.EvolucoesMemory;
import estruturaEvolucoes.EvolucoesTime;
import exceptions.ArquivoNaoEncontradoException;
import main.LeitorArquivo;

public class TesteLerArquivo {
	EvolucoesMemory memories = new EvolucoesMemory();
	EvolucoesTime times = new EvolucoesTime();
	
	@Test
	public void abrirAnalysisMemory() throws ArquivoNaoEncontradoException {
		LeitorArquivo leitor = new LeitorArquivo();
		assertEquals(21, leitor.lerArquivo(memories));
		//memories.Show();
	}
	
	@Test
	public void abrirAnalysisTime() throws ArquivoNaoEncontradoException {
		LeitorArquivo leitor = new LeitorArquivo();
		assertEquals(21, leitor.lerArquivo(times));
		//times.Show();
	}

	@Test(expected = ArquivoNaoEncontradoException.class)
	public void abrirDesconhecido() throws ArquivoNaoEncontradoException {
		LeitorArquivo leitor = new LeitorArquivo();
		memories.setNomeEntrada("ArquivoQualquer.out");
		assertEquals(21, leitor.lerArquivo(memories));
	}

}
