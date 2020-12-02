package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public class Lance {
	
	@Getter @Setter
	private double valor;
	
	@Getter @Setter
	private Usuario usuario;
	
	public Lance(double valor, Usuario usuario) {
		this.valor = valor;
		this.usuario = usuario;
	}
}
