package leilaobrasil;

public interface UsuarioInterface {
	
	public Leilao criarLeilao(String nomeLeilao, int ano, int mes, int dia, int hora, int minuto);
	public boolean canLogin(String username, String senha);
	
}
