package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import estruturaEvolucoes.EvolucoesMemory;
import estruturaEvolucoes.EvolucoesTime;
import exceptions.ArquivoNaoEncontradoException;
import main.Menu;
import main.Persistencia;

public class TesteLerArquivo {
	EvolucoesMemory memories = new EvolucoesMemory();
	EvolucoesTime times = new EvolucoesTime();
	Persistencia persistencia = new Persistencia();
	
	@Test
	public void abrirAnalysisMemory() throws ArquivoNaoEncontradoException {
		assertEquals(21, persistencia.lerArquivo(memories));
		//memories.Show();
	}
	
	@Test
	public void abrirAnalysisTime() throws ArquivoNaoEncontradoException {
		assertEquals(21, persistencia.lerArquivo(times));
		//times.Show();
	}

	@Test(expected = ArquivoNaoEncontradoException.class)
	public void abrirDesconhecido() throws ArquivoNaoEncontradoException {
		memories.setNomeEntrada("ArquivoQualquer.out");
		assertEquals(21, persistencia.lerArquivo(memories));
	}

}
