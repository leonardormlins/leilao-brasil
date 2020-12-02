package leilaobrasil;

import static org.junit.Assert.*;

import org.junit.Test;

public class ApartamentoTest {

	Apartamento ap = new Apartamento("Rua Foo, 95", 180000.00, "Casa Foo, Cidade Boo", "1867481911.8519",
										50000, "Vigesimo", "B", 280.00 ,80, 200.00, 5, 2);
	
	@Test
	public void testAp() {
		assertNotNull(ap);
	}
	
	@Test
	public void testAtributos() {
		assertEquals("Rua Foo, 95", ap.getEndereco());
		//Deprecated
		//assertEquals(180000.00, casa.getPrecoOriginal());
		assertEquals("Casa Foo, Cidade Boo", ap.getDescricao());
		assertEquals("1867481911.8519", ap.getInscricaoMunicipal());
		assertEquals("Vigesimo", ap.getAndar());
		assertEquals("B", ap.getBloco());
		//Deprecated
		//assertEquals(280.00, ap.getValorCondominio());
		assertEquals(80, ap.getNumeroAp());
		//Deprecated
		//assertEquals(200.00, ap.getArea());
		assertEquals(5, ap.getComodos());
		assertEquals(2, ap.getGaragem());
	}

}
