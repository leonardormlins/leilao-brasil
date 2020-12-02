package leilaobrasil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Leilao {
	
		@Getter @Setter
		private String nome;
		@Getter @Setter
		private int id;
		private List<Casa> casas;
		@Getter
		private List<Apartamento> apartamentos;
		@Getter
		private List<Terreno> terrenos;
		@Getter
		private List<Edificio> edificios;
		@Getter
		private List<Carro> carros;
		@Getter
		private List<Motorcicleta> motos;
		@Getter
		private Financeira instituicaoFinanceira;
		private Calendar dataInicio;
		private Calendar dataFim;
		
		public Leilao(String nome, Financeira instituicaoFinanceira, Calendar dataFim) {
			this.nome = nome;
			this.instituicaoFinanceira = instituicaoFinanceira;
			this.dataInicio = Calendar.getInstance();
			this.dataFim = dataFim;
			this.casas = new ArrayList<Casa>();
			this.apartamentos = new ArrayList<Apartamento>();
			this.terrenos = new ArrayList<Terreno>();
			this.edificios = new ArrayList<Edificio>();
			this.carros = new ArrayList<Carro>();
			this.motos = new ArrayList<Motorcicleta>();
			
		}
		
		public String getStatus() {
			int comparacao = dataFim.compareTo(Calendar.getInstance());
			if (comparacao == -1) {
				return "EM ANDAMENTO";
			}
			else if (comparacao == 1) {
				return "EM ABERTO";
			}
			else return "FINALIZADO";
		}
		
		public int getQuantidadeProdutos() {
			int quantidade = 0;
			quantidade = casas.size() + apartamentos.size() + terrenos.size()
							+ edificios.size() + carros.size() + motos.size();
			return quantidade;
		}
		
		public void addCasa(Casa casa) {
			casas.add(casa);
		}
		
		public void addApartamento(Apartamento ap) {
			apartamentos.add(ap);
		}
		
		public void addTerreno(Terreno terreno) {
			terrenos.add(terreno);
		}
		
		public void addEdificio(Edificio edificio) {
			edificios.add(edificio);
		}
		
		public void addCarro(Carro carro) {
			carros.add(carro);
		}
		
		public void addMotorcicleta(Motorcicleta moto) {
			motos.add(moto);
		}
		
		public List<Casa> getCasas() {
			Collections.sort(casas, (o1, o2) -> o1.getLastModified().compareTo(o2.getLastModified()));
			return casas;
		}
		public List<Apartamento> getApartamentos() {
			Collections.sort(apartamentos, (o1, o2) -> o1.getLastModified().compareTo(o2.getLastModified()));
			return apartamentos;
		}
		public List<Terreno> getTerrenos() {
			Collections.sort(terrenos , (o1, o2) -> o1.getLastModified().compareTo(o2.getLastModified()));
			return terrenos;
		}
		public List<Edificio> getEdificios() {
			Collections.sort(edificios, (o1, o2) -> o1.getLastModified().compareTo(o2.getLastModified()));
			return edificios;
		}
		
		
}
