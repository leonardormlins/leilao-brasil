package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public class Terreno extends Imovel{
	
	@Getter @Setter
	private double area;
	@Setter
	private boolean murado;
	@Getter @Setter
	private String quadra;
	@Getter @Setter
	private String localizacao;

	public Terreno(String endereco, double preco, String descricao, String inscricaoMunicipal,
					double lanceMinimo, double area, boolean murado, String quadra,
					String localizacao) {
		super(endereco, preco, descricao, inscricaoMunicipal, lanceMinimo);
		setArea(area);
		setMurado(murado);
		setQuadra(quadra);
		setLocalizacao(localizacao);
	}
	
	public boolean getMurado() {
		return this.murado;
	}
}
