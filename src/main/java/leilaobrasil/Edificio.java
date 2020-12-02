package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public class Edificio extends Imovel {
	
	@Getter @Setter
	private int andares;
	@Setter
	private boolean comercial;
	@Getter @Setter
	private int numeroSalas;
	
	public Edificio(String endereco, double preco, String descricao, String inscricaoMunicipal,
					double lanceMinimo, int andares, boolean comercial, int numeroSalas) {
		super(endereco, preco, descricao, inscricaoMunicipal, lanceMinimo);
		setAndares(andares);
		setComercial(comercial);
		setNumeroSalas(numeroSalas);
	}
	
	public boolean getComercial() {
		return this.comercial;
	}
}
