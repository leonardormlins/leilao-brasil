package leilaobrasil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class FinanceiraTest {

	Financeira financeira = new Financeira("fin", "123", "00000000000");
	Leilao leilao = financeira.criarLeilao("leilao", 2020, 12, 10, 1, 1);
	
	@Test
	public void testFinanceira() {
		assertNotNull(financeira);
	}

	@Test
	public void testAtributos() {
		assertEquals("fin", financeira.getUsuario());
		assertEquals("00000000000", financeira.getCnpj());
		assertEquals("123", financeira.getSenha());
		assertEquals(true, financeira.canLogin("fin", "123"));
		assertEquals(leilao.getNome(), financeira.criarLeilao("leilao", 2020, 12, 10, 1, 1).getNome());		
	}
}
