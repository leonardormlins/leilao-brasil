package leilaobrasil;

import static org.junit.Assert.*;

import org.junit.Test;

public class TerrenoTest {

	Terreno terreno = new Terreno("Rua Foo, 95", 180000.00, "Casa Foo, Cidade Boo", "1867481911.8519", 50000, 250.00, false, "F1", "Urbana");
	
	@Test
	public void testCasa() {
		assertNotNull(terreno);
	}
	
	@Test
	public void testAtributos() {
		assertEquals("Rua Foo, 95", terreno.getEndereco());
		//Deprecated
		//assertEquals(180000.00, casa.getPrecoOriginal());
		assertEquals("Casa Foo, Cidade Boo", terreno.getDescricao());
		assertEquals("1867481911.8519", terreno.getInscricaoMunicipal());
		//Deprecated
		//assertEquals(100.00, casa.getAreaConstruida());
		//Deprecated
		//assertEquals(250.00, casa.getArea());
		assertEquals("F1", terreno.getQuadra());
		assertEquals("Urbana", terreno.getLocalizacao());
	}
}
