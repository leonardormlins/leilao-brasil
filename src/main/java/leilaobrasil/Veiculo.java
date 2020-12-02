package leilaobrasil;

import java.util.Calendar;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public abstract class Veiculo implements ProdutoInterface {
	
	@Setter @Getter
	private String descricao;
	@Setter	@Getter
	private String modelo;
	@Setter	@Getter
	private int ano;
	@Setter	@Getter
	private String placa;
	@Setter	@Getter
	private String combustivel;
	@Setter	@Getter
	private int cc;
	@Setter	@Getter
	private String cor;
	@Getter @Setter
	private double lanceMinimo;
	@Getter @Setter
	private List<Lance> lances;
	@Getter @Setter
	private Calendar lastModified;
	
	public Veiculo(String descricao, String modelo, int ano, String placa, String combustivel, int cc, String cor,
			double lanceMinimo) {
		this.descricao = descricao;
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
		this.combustivel = combustivel;
		this.cc = cc;
		this.cor = cor;
		this.lanceMinimo = lanceMinimo;
		this.lastModified = Calendar.getInstance();
	}
	
	public void darLance(double valor, Usuario user) {
		Lance lance;
		Lance ultimoLance;
		double valorUltimoLance;
		if (valor > lanceMinimo) {
			if(lances.isEmpty()) {
				lance = new Lance(valor, user);
			}
			else {
				ultimoLance = lances.get( (lances.size()) -1 );
				valorUltimoLance = ultimoLance.getValor();
				if( valorUltimoLance < valor) {
					lance = ultimoLance;
					lance.setValor(valorUltimoLance + valor);
					lance.setUsuario(user);
					lances.add(lance);
					System.out.println("Lance dado com sucesso!");
				}
				else {
					System.out.println("Lance anterior maior do que requisitado!");
				}
			}
		}
		System.out.println("Deve ser maior que o lance minimo!");
	}
}
