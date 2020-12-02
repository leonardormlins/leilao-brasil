package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public class UsuarioComum extends Usuario{
	
	@Getter @Setter
	private String cpf;
	
	public UsuarioComum(String usuario, String senha, String cpf) {
		super(usuario, senha, 1);
		setCpf(cpf);
	}
	
	public Leilao criarLeilao(String nomeLeilao, int ano, int mes, int dia, int hora, int minuto) {
		return null;
	}
}
