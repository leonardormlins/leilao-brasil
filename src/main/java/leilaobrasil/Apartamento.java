package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public class Apartamento extends Imovel{
	
	@Getter @Setter
	private String andar;
	@Getter @Setter
	private String bloco;
	@Getter @Setter
	private double valorCondominio;
	@Getter @Setter
	private int numeroAp;
	@Getter @Setter
	private double area;
	@Getter @Setter
	private int comodos;
	@Getter @Setter
	private int garagem;

	public Apartamento(String endereco, double preco, String descricao, String inscricaoMunicipal,
					double lanceMinimo, String andar, String bloco, double valorCondominio, int numeroAp,
					double area, int comodos, int garagem) {
		super(endereco, preco, descricao, inscricaoMunicipal, lanceMinimo);
		setAndar(andar);
		setBloco(bloco);
		setValorCondominio(valorCondominio);
		setNumeroAp(numeroAp);
		setArea(area);
		setComodos(comodos);
		setGaragem(garagem);
	}
}
