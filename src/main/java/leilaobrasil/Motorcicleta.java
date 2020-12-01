package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public class Motorcicleta extends Veiculo {
	@Getter @Setter
	private int aroRoda;
	@Getter @Setter
	private boolean partidaEletrica;
	
	public Motorcicleta(String modelo, int ano, String placa, String combustivel, int cc, String cor,
							int aroRoda, boolean partidaEletrica) {
		super(modelo, ano, placa, combustivel, cc, cor);
		setAroRoda(aroRoda);
		setPartidaEletrica(partidaEletrica);
	}
}
