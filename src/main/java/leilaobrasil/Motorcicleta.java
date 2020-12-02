package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public class Motorcicleta extends Veiculo {
	@Getter @Setter
	private int aroRoda;
	@Setter
	private boolean partidaEletrica;
	
	public Motorcicleta(String descricao, String modelo, int ano, String placa, String combustivel, int cc, String cor,
						double lanceMinimo, int aroRoda, boolean partidaEletrica) {
		super(descricao, modelo, ano, placa, combustivel, cc, cor, lanceMinimo);
		setAroRoda(aroRoda);
		setPartidaEletrica(partidaEletrica);
	}
	
	public boolean getPartidaEletrica() {
		return this.partidaEletrica;
	}
}
