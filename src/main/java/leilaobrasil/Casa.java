package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public class Casa extends Imovel{
	
	@Getter @Setter
	private double areaConstruida;
	@Getter @Setter
	private double area;
	@Getter @Setter
	private int comodos;
	@Getter @Setter
	private boolean piscina;
	@Getter @Setter
	private int garagem;

	public Casa(String endereco, double preco, String descricao, String inscricaoMunicipal,
				double areaConstruida, double area, int comodos, boolean piscina, int garagem) {
		super(endereco, preco, descricao, inscricaoMunicipal);
		setAreaConstruida(areaConstruida);
		setArea(area);
		setComodos(comodos);
		setPiscina(piscina);
		setGaragem(garagem);
	}
}
