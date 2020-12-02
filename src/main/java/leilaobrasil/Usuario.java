package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public abstract class Usuario implements UsuarioInterface{
	@Getter @Setter
	private String usuario;
	@Getter @Setter
	private String senha;
	@Getter @Setter
	private int tipo; //1 - COMUM ; 2 - FINANCEIRA 
	
	public Usuario(String usuario, String senha, int tipo) {
		this.usuario = usuario;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	public boolean canLogin(String usuario, String senha) {
		if(this.usuario.equals(usuario) && this.senha.equals(senha)) return true;
		else return false;
	}
	
	
}
