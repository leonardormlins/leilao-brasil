package leilaobrasil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class CarroTest {
	
	Carro carro = new Carro("Uno", 1991, "BHN2662", "Gasolina", 1000, "Cinza", 4, 13, false, false);

	@Test
	public void testCarro() {
		assertNotNull(carro);
	}
	
	@Test
	public void testAtributos() {
		assertEquals("Uno", carro.getModelo());
		assertEquals(1991, carro.getAno());
		assertEquals("BHN2662", carro.getPlaca());
		assertEquals("Gasolina", carro.getCombustivel());
		assertEquals(1000, carro.getCc());
		assertEquals("Cinza", carro.getCor());
		assertEquals(4, carro.getPortas());
		assertEquals(13, carro.getAroRoda());
	}

}
