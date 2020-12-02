package leilaobrasil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class LeilaoTest {

	private static Financeira financeira = new Financeira("fin", "123", "00000000000");
	Leilao leilao = financeira.criarLeilao("leilao", 2020, 12, 1, 10, 15);
	@Test
	public void testLeilao() {
		assertNotNull(leilao);
	}

	@Test
	public void testAtributos() {
		assertEquals("leilao", leilao.getNome());
		assertEquals("EM ANDAMENTO", leilao.getStatus());
		assertNotNull(leilao.getApartamentos());
	}
}
