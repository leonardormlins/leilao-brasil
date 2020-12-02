package leilaobrasil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AppTest {

	App app = new App();
	Financeira financeira = new Financeira("fin", "123", "00000000000");
	Leilao leilao = financeira.criarLeilao("leilao", 2020, 12, 10, 1, 1);
	
	@Test
	public void testApp() {
		assertNotNull(app);
	}

	@Test
	public void testAtributos() {
		assertEquals(leilao, app.buscarLeilao("leilao"));
	}
}
