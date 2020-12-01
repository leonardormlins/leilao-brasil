package leilaobrasil;

import lombok.Getter;
import lombok.Setter;

public abstract class Veiculo {
	@Setter	@Getter
	private String modelo = "Uno";
	@Setter	@Getter
	private int ano = 1991;
	@Setter	@Getter
	private String placa = "BHN2662";
	@Setter	@Getter
	private String combustivel = "Gasolina";
	@Setter	@Getter
	private int cc = 1000;
	@Setter	@Getter
	private String cor = "Cinza";
	
	public Veiculo(String modelo, int ano, String placa, String combustivel, int cc, String cor) {
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
		this.combustivel = combustivel;
		this.cc = cc;
		this.cor = cor;
	}
}
