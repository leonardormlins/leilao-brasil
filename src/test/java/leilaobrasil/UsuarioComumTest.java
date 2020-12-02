package leilaobrasil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UsuarioComumTest {

	UsuarioComum usuarioComum = new UsuarioComum("joao", "123", "00000000000");
	
	@Test
	public void testUsuarioComum() {
		assertNotNull(usuarioComum);
	}

	@Test
	public void testAtributos() {
		assertEquals("joao", usuarioComum.getUsuario());
		assertEquals("123", usuarioComum.getSenha());
		assertEquals(true, usuarioComum.canLogin("joao", "123"));
		assertEquals("00000000000", usuarioComum.getCpf());
	}
}
