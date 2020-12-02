package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public class Carro extends Veiculo{
	@Getter @Setter
	private int portas;
	@Getter @Setter
	private int aroRoda;
	@Setter
	private boolean arCondicionado;
	@Setter
	private boolean direcaoHidraulica;
	
	public Carro(String descricao, String modelo, int ano, String placa, String combustivel, int cc, String cor, 
			double lanceMinimo, int portas, int aroRoda, boolean arCondicionado, boolean direcaoHidraulica) {
		super(descricao, modelo, ano, placa, combustivel, cc, cor, lanceMinimo);
		setPortas(portas);
		setAroRoda(aroRoda);
		setArCondicionado(arCondicionado);
		setDirecaoHidraulica(direcaoHidraulica);
	}
	
	public boolean getArCondicionado() {
		return this.arCondicionado;
	}
	
	public boolean getDirecaoHidraulica() {
		return this.direcaoHidraulica;
	}
}
