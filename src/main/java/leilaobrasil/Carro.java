package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public class Carro extends Veiculo{
	@Getter @Setter
	private int portas;
	@Getter @Setter
	private int aroRoda;
	@Getter @Setter
	private boolean arCondicionado;
	@Getter @Setter
	private boolean direcaoHidraulica;
	
	public Carro(String modelo, int ano, String placa, String combustivel, int cc, String cor, 
			int portas, int aroRoda, boolean arCondicionado, boolean direcaoHidraulica) {
		super(modelo, ano, placa, combustivel, cc, cor);
		setPortas(portas);
		setAroRoda(aroRoda);
		setArCondicionado(arCondicionado);
		setDirecaoHidraulica(direcaoHidraulica);
	}
}
