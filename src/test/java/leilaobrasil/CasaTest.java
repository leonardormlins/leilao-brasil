package leilaobrasil;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasaTest {

	Casa casa = new Casa("Rua Foo, 95", 180000.00, "Casa Foo, Cidade Boo", "1867481911.8519", 100.00, 250.00, 4, false, 2);
	
	@Test
	public void testCasa() {
		assertNotNull(casa);
	}
	
	@Test
	public void testAtributos() {
		assertEquals("Rua Foo, 95", casa.getEndereco());
		//Deprecated
		//assertEquals(180000.00, casa.getPrecoOriginal());
		assertEquals("Casa Foo, Cidade Boo", casa.getDescricao());
		assertEquals("1867481911.8519", casa.getInscricaoMunicipal());
		//Deprecated
		//assertEquals(100.00, casa.getAreaConstruida());
		//Deprecated
		//assertEquals(250.00, casa.getArea());
		assertEquals(2, casa.getGaragem());
	}
}
