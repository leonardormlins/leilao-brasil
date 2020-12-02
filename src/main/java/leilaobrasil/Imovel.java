package leilaobrasil;

import java.util.Calendar;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public abstract class Imovel implements ProdutoInterface {
	@Setter @Getter
	private String endereco;
	@Setter @Getter
	private double precoOriginal;
	@Setter @Getter
	private String descricao;
	@Setter @Getter
	private String inscricaoMunicipal;
	@Setter @Getter
	private double lanceMinimo;
	@Setter @Getter
	private List<Lance> lances;
	@Setter @Getter
	private Calendar lastModified;
	
	public Imovel(String endereco, double precoOriginal, String descricao, String inscricaoMunicipal,
				double lanceMinimo) {
		this.endereco = endereco;
		this.precoOriginal = precoOriginal;
		this.descricao = descricao;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.lanceMinimo = lanceMinimo;
		this.lastModified = Calendar.getInstance();
	};
	
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
