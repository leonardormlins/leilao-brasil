package leilaobrasil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class EdificioTest {

	Edificio edificio = new Edificio("Rua Foo, 95", 180000.00, "Casa Foo, Cidade Boo", "1867481911.8519", 20, true, 80);
	
	@Test
	public void testCasa() {
		assertNotNull(edificio);
	}
	
	@Test
	public void testAtributos() {
		assertEquals("Rua Foo, 95", edificio.getEndereco());
		//Deprecated
		//assertEquals(180000.00, casa.getPrecoOriginal());
		assertEquals("Casa Foo, Cidade Boo", edificio.getDescricao());
		assertEquals("1867481911.8519", edificio.getInscricaoMunicipal());
		assertEquals(20, edificio.getAndares());
		assertEquals(80, edificio.getNumeroSalas());
	}
}
