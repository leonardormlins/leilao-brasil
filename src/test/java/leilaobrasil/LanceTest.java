package leilaobrasil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LanceTest {
	UsuarioComum usuario = new UsuarioComum("joao","123","000");
	Lance lance = new Lance(50000, usuario);

	@Test
	public void testLance() {
		assertNotNull(lance);
	}
	
	@Test
	public void testAtributos() {
		assertEquals("50000.0", String.valueOf(lance.getValor()));
		assertEquals(usuario, lance.getUsuario());
	}

}
