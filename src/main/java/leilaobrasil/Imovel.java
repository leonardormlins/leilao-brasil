package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public abstract class Imovel {
	@Setter @Getter
	private String endereco;
	@Setter @Getter
	private double precoOriginal;
	@Setter @Getter
	private String descricao;
	@Setter @Getter
	private String inscricaoMunicipal;

	public Imovel(String endereco, double precoOriginal, String descricao, String inscricaoMunicipal) {
		this.endereco = endereco;
		this.precoOriginal = precoOriginal;
		this.descricao = descricao;
		this.inscricaoMunicipal = inscricaoMunicipal;
	};
}
