package leilaobrasil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MotorcicletaTest {
	
	Motorcicleta moto = new Motorcicleta("MotoConservada","Falcon", 2005, "AQS2162", "Flex", 800, "Cinza", 50000, 17, true);

	@Test
	public void testMoto() {
		assertNotNull(moto);
	}
	
	@Test
	public void testAtributos() {
		assertEquals("Falcon", moto.getModelo());
		assertEquals(2005, moto.getAno());
		assertEquals("AQS2162", moto.getPlaca());
		assertEquals("Flex", moto.getCombustivel());
		assertEquals(800, moto.getCc());
		assertEquals("Cinza", moto.getCor());
		assertEquals(17, moto.getAroRoda());
	}

}
