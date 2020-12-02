package leilaobrasil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	private static boolean canMenuInicial = true;
	private static boolean canLogin = true;
	private static boolean canMenuDepoisLogin = true;
	
	//STORE
	private static UsuarioComum usuarioComum = new UsuarioComum("joao", "123", "00000000000");
	private static UsuarioComum usuarioComum2 = new UsuarioComum("mario", "123", "00000000000");
	private static Financeira financeira = new Financeira("fin", "123", "00000000000");
	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	private static Usuario logado;
	private static List<Leilao> leiloes = new ArrayList<Leilao>();
	private static List<Imovel> produtosImoveis = new ArrayList<Imovel>();
	
	public static void main(String[] args) {
		usuarios.add(usuarioComum);
		usuarios.add(usuarioComum2);
		usuarios.add(financeira);
		
		menuInicial();
		
	}
	
	public static void menuInicial() {
		Scanner input = new Scanner(System.in);
		int opcao; 
		
		System.out.println("Bem vindo ao sistema Leilão Brasil!");
		System.out.println("1) Login\n2) Registrar");
		System.out.println("Escolha uma opção: ");
		opcao = input.nextInt();
		if(opcao == 1) login();
		if(opcao == 2) register();
		else menuInicial();
	}
	
	public static void register() {
		Scanner input = new Scanner(System.in);
		String usuarioInserido, senhaInserida, cpfInserido;
		
		System.out.println("Usuario: ");
		usuarioInserido = input.next();
		System.out.println("Senha: ");
		senhaInserida = input.next();
		System.out.println("CPF: ");
		cpfInserido = input.next();
		System.out.println("TIPO: (1) Comum\n2)Financeira");
		int opcao = input.nextInt();
		if(opcao == 1) {
			UsuarioComum novoUsuario = new UsuarioComum(usuarioInserido,
					senhaInserida, cpfInserido);
			usuarios.add(novoUsuario);
		}
		if(opcao == 2) {
			Financeira novaFinanceira = new Financeira(usuarioInserido,
					senhaInserida, cpfInserido);
			usuarios.add(novaFinanceira);
		}
		menuInicial();
	}
	
	public static void login() {
		Scanner input = new Scanner(System.in);
		String usuarioInserido, senhaInserida;
		
		System.out.println("Usuário: ");
		usuarioInserido = input.next();
		System.out.println("Senha: ");
		senhaInserida = input.next();
		
		for(Usuario user: usuarios) {
			if(user.canLogin(usuarioInserido, senhaInserida)) {
				logado = user;
				System.out.println("Logado com sucesso!!");
				menuDepoisLogin();
			}
		}
		System.out.println("Usuario ou senha incorreta!");
	}
	
	public static void menuDepoisLogin() {
		switch(logado.getTipo()) {
			case 1:
				menuDepoisLoginCom();
				break;
			case 2:
				menuDepoisLoginFin();
				break;
		}
	}
	
	public static void menuDepoisLoginFin() {
		Scanner input = new Scanner(System.in);
		int opcao;
		
		System.out.println("Escolha uma opcao: ");
		System.out.println("1) Criar leilão\n2) Listar leiloes");
		System.out.println("3) Buscar um leilao\n4) Adicionar produto");
		System.out.println("5) Remover leilao\n6) Listar produtos");
		System.out.println("7) Logout\n");
		opcao = input.nextInt();
		
		switch(opcao) {
		case 1:
			criarLeilao();
			break;
		case 2:
			for(Leilao leilao: leiloes) {
				imprimirLeilao(leilao);
			}
			break;
		case 3:
			System.out.println("\n\nInsira o nome do leilao: ");
			String nomeLeilao = input.next();
			System.out.println("TESTE, "+ nomeLeilao);
			Leilao encontrado = buscarLeilao(nomeLeilao);
			if(encontrado == null) {
				System.out.println("Nenhum leilao encontrado com esse nome");
				menuDepoisLogin();
			}
			imprimirLeilao(encontrado);
			break;
		case 4:
			System.out.println("\n\nInsira o nome do leilao: ");
			String nomeLeilaoAddProduto = input.next();
			Leilao encontradoAddProduto = buscarLeilao(nomeLeilaoAddProduto);
			adicionarProdutoLeilao(encontradoAddProduto);
			break;
		case 5:
			System.out.println("\n\nInsira o nome do leilao: ");
			String nomeLeilaoDel= input.next();
			Leilao encontradoDel = buscarLeilao(nomeLeilaoDel);
			removerLeilao(encontradoDel);
			break;
		case 6:
			menuListarProdutos();
			break;
		case 7:
			canLogin = true;
			menuInicial();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}
	
	public static void menuDepoisLoginCom() {
		Scanner input = new Scanner(System.in);
		int opcao;
		
		System.out.println("Escolha uma opcao: ");
		System.out.println("1) Listar leiloes\n2) Dar lance");
		System.out.println("7) Logout\n");
		opcao = input.nextInt();
		
		switch(opcao) {
		case 1:
			for(Leilao leilao: leiloes) {
				imprimirLeilao(leilao);
			}
			break;
		case 2:
			darLance();
			break;
		case 7:
			canLogin = true;
			menuInicial();
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}
	
	public static void darLance() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\nInforme a descricao do Produto\n que você deseja dar o lance: ");
		String desc = input.next();
		buscarProduto(desc);
	}
	
	public static void criarLeilao() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insira o nome do leilão: ");
		String nome = input.next();
		System.out.println("Insira a data encerramento do leilao\nAno do encerramento: ");
		int ano = input.nextInt();
		System.out.println("Mês do encerramento: ");
		int mes = input.nextInt();
		System.out.println("Dia do encerramento: ");
		int dia = input.nextInt();
		System.out.println("Hora do encerramento: ");
		int hora = input.nextInt();
		System.out.println("Minuto do encerramento");
		int minuto = input.nextInt();
		
		Leilao leilao = logado.criarLeilao(nome, ano, mes, dia, hora, minuto);
		leiloes.add(leilao);
		
		System.out.println("Leilão cadastrado!");
		System.out.println("\nDeseja inserir algum produto ao leilão?\n1) Sim\n2) Não");
		int opcao = input.nextInt();
		switch(opcao) {
			case 1:
				adicionarProdutoLeilao(leilao);
				break;
			case 2:
				menuDepoisLogin();
			default:
				menuDepoisLogin();
				break;
		}
			
	}
	
	public static void removerLeilao(Leilao leilao) {
		leiloes.remove(leilao);
		System.out.println("Leilão removido com sucesso!\n\n\n\n");
		menuDepoisLogin();
	}
	
	public static Leilao buscarLeilao(String nomeLeilao) {
		
		for(Leilao leilao: leiloes) {
			if(leilao.getNome().equals(nomeLeilao)) {
				return leilao;
			}
		}
		return null;
		
	}
	
	public static void imprimirLeilao(Leilao leilao) {
		System.out.println("------\n");
		System.out.println("- NOME:");
		System.out.println(leilao.getNome()+"\n");
		System.out.println("- STATUS:");
		System.out.println(leilao.getStatus()+"\n");
		System.out.println("- INSTITUIÇÃO FINANCEIRA:");
		System.out.println(leilao.getInstituicaoFinanceira().getUsuario()+"\n");
		System.out.println("- INSTITUIÇÃO FINANCEIRA CNPJ:");
		System.out.println(leilao.getInstituicaoFinanceira().getCnpj()+"\n");
		System.out.println("- QUANTIDADE DE PRODUTOS:");
		System.out.println(leilao.getQuantidadeProdutos()+"\n\n");
		
		menuDepoisLogin();
	}
	
	public static void imprimirCasa(Casa casa, Leilao leilao) {
		System.out.println("------\n");
		System.out.println("- LEILAO:\n"+leilao.getNome());
		System.out.println("- TIPO: \nCasa\n");
		System.out.println("- ENDERECO:");
		System.out.println(casa.getEndereco()+"\n");
		System.out.println("- PRECO ORIGINAL:");
		System.out.println(casa.getPrecoOriginal()+"\n");
		System.out.println("- DESCRICAO:");
		System.out.println(casa.getDescricao()+"\n");
		System.out.println("- INSCRICAO MUNICIPAL:");
		System.out.println(casa.getInscricaoMunicipal()+"\n");
		System.out.println("- AREA CONSTRUIDA:");
		System.out.println(casa.getAreaConstruida()+"\n");
		System.out.println("- AREA TOTAL:");
		System.out.println(casa.getArea()+"\n");
		System.out.println("- COMODOS:");
		System.out.println(casa.getComodos()+"\n");
		System.out.println("- PISCINA:");
		System.out.println(casa.getPiscina()+"\n");
		System.out.println("- GARAGEM:");
		System.out.println(casa.getGaragem()+"\n\n\n");
	}
	
	public static void imprimirApartamento(Apartamento ap, Leilao leilao) {
		System.out.println("------\n");
		System.out.println("- LEILAO:\n"+leilao.getNome());
		System.out.println("- TIPO: \nApartamento\n");
		System.out.println("- ENDERECO:");
		System.out.println(ap.getEndereco()+"\n");
		System.out.println("- PRECO ORIGINAL:");
		System.out.println(ap.getPrecoOriginal()+"\n");
		System.out.println("- DESCRICAO:");
		System.out.println(ap.getDescricao()+"\n");
		System.out.println("- INSCRICAO MUNICIPAL:");
		System.out.println(ap.getInscricaoMunicipal()+"\n");
		System.out.println("- ANDAR:");
		System.out.println(ap.getAndar()+"\n");
		System.out.println("- BLOCO:");
		System.out.println(ap.getBloco()+"\n");
		System.out.println("- CONDOMINIO VALOR:");
		System.out.println(ap.getValorCondominio()+"\n");
		System.out.println("- NUMERO AP:");
		System.out.println(ap.getNumeroAp()+"\n");
		System.out.println("- AREA:");
		System.out.println(ap.getArea()+"\n");
		System.out.println("- COMODOS:");
		System.out.println(ap.getComodos()+"\n");
		System.out.println("- GARAGEM:");
		System.out.println(ap.getGaragem()+"\n\n\n");
	}
	
	public static void imprimirTerreno(Terreno terreno, Leilao leilao) {
		System.out.println("------\n");
		System.out.println("- LEILAO:\n"+leilao.getNome());
		System.out.println("- TIPO: \nTerreno\n");
		System.out.println("- ENDERECO:");
		System.out.println(terreno.getEndereco()+"\n");
		System.out.println("- PRECO ORIGINAL:");
		System.out.println(terreno.getPrecoOriginal()+"\n");
		System.out.println("- DESCRICAO:");
		System.out.println(terreno.getDescricao()+"\n");
		System.out.println("- INSCRICAO MUNICIPAL:");
		System.out.println(terreno.getInscricaoMunicipal()+"\n");
		System.out.println("- AREA:");
		System.out.println(terreno.getArea()+"\n");
		System.out.println("- MURADO:");
		System.out.println(terreno.getMurado()+"\n");
		System.out.println("- QUADRA:");
		System.out.println(terreno.getQuadra()+"\n");
		System.out.println("- LOCALIZACAO:");
		System.out.println(terreno.getLocalizacao()+"\n\n\n");
	}
	
	public static void imprimirEdificio(Edificio edificio, Leilao leilao) {
		System.out.println("------\n");
		System.out.println("- LEILAO:\n"+leilao.getNome());
		System.out.println("- TIPO: \nEdificio\n");
		System.out.println("- ENDERECO:");
		System.out.println(edificio.getEndereco()+"\n");
		System.out.println("- PRECO ORIGINAL:");
		System.out.println(edificio.getPrecoOriginal()+"\n");
		System.out.println("- DESCRICAO:");
		System.out.println(edificio.getDescricao()+"\n");
		System.out.println("- INSCRICAO MUNICIPAL:");
		System.out.println(edificio.getInscricaoMunicipal()+"\n");
		System.out.println("- ANDARES:");
		System.out.println(edificio.getAndares()+"\n");
		System.out.println("- COMERCIAL:");
		System.out.println(edificio.getComercial()+"\n");
		System.out.println("- NUMERO SALAS:");
		System.out.println(edificio.getNumeroSalas()+"\n\n\n");
	}
	
	public static void imprimirCarro(Carro carro, Leilao leilao) {
		System.out.println("------\n");
		System.out.println("- LEILAO:\n"+leilao.getNome());
		System.out.println("- TIPO: \nCarro\n");
		System.out.println("- DESCRICAO:");
		System.out.println(carro.getDescricao()+"\n");
		System.out.println("- MODELO:");
		System.out.println(carro.getModelo()+"\n");
		System.out.println("- ANO:");
		System.out.println(carro.getAno()+"\n");
		System.out.println("- PLACA:");
		System.out.println(carro.getPlaca()+"\n");
		System.out.println("- COMBUSTIVEL:");
		System.out.println(carro.getCombustivel()+"\n");
		System.out.println("- CC:");
		System.out.println(carro.getCc()+"\n");
		System.out.println("- COR:");
		System.out.println(carro.getCor()+"\n");
		System.out.println("- PORTAS:");
		System.out.println(carro.getPortas()+"\n");
		System.out.println("- ARO RODA:");
		System.out.println(carro.getAroRoda()+"\n");
		System.out.println("- AR CONDICIONADO:");
		System.out.println(carro.getArCondicionado()+"\n");
		System.out.println("- DIRECAO HIDRAULICA:");
		System.out.println(carro.getDirecaoHidraulica()+"\n\n\n");
	}
	
	public static void imprimirMotorcicleta(Motorcicleta moto, Leilao leilao) {
		System.out.println("------\n");
		System.out.println("- LEILAO:\n"+leilao.getNome());
		System.out.println("- TIPO: \nMotorcicleta\n");
		System.out.println("- DESCRICAO:");
		System.out.println(moto.getDescricao()+"\n");
		System.out.println("- MODELO:");
		System.out.println(moto.getModelo()+"\n");
		System.out.println("- ANO:");
		System.out.println(moto.getAno()+"\n");
		System.out.println("- PLACA:");
		System.out.println(moto.getPlaca()+"\n");
		System.out.println("- COMBUSTIVEL:");
		System.out.println(moto.getCombustivel()+"\n");
		System.out.println("- CC:");
		System.out.println(moto.getCc()+"\n");
		System.out.println("- COR:");
		System.out.println(moto.getCor()+"\n");
		System.out.println("- ARO RODA:");
		System.out.println(moto.getAroRoda()+"\n");
		System.out.println("- PARTIDA ELETRICA:");
		System.out.println(moto.getPartidaEletrica()+"\n\n\n");
	}
	
	public static void buscarProduto(String descricao) {
		Scanner input = new Scanner(System.in);
		
		Casa casaEncontrada = null;
		Apartamento apEncontrado = null;
		Terreno terrenoEncontrado = null;
		Edificio edificioEncontrado = null;
		Carro carroEncontrado = null;
		Motorcicleta motoEncontrada = null;
		
		for(Leilao leilao : leiloes) {
			for(Casa casa: leilao.getCasas()) {
				if (casa.getDescricao().equals(descricao)) {
					if(leilao.getStatus().equals("EM ANDAMENTO")) {
						casaEncontrada = casa;
					}
				}
				System.out.println();
			}
		}
		for(Leilao leilao : leiloes) {
			for(Apartamento ap: leilao.getApartamentos()) {
				if (ap.getDescricao().equals(descricao)) {
					if(leilao.getStatus().equals("EM ANDAMENTO")) {
						apEncontrado = ap;
					}
				}
				System.out.println();
			}
		}
		for(Leilao leilao : leiloes) {
			for(Terreno terreno: leilao.getTerrenos()) {
				if (terreno.getDescricao().equals(descricao)) {
					if(leilao.getStatus().equals("EM ANDAMENTO")) {
						terrenoEncontrado = terreno;
					}
				}
				System.out.println();
			}
		}
		for(Leilao leilao : leiloes) {
			for(Edificio edificio: leilao.getEdificios()) {
				if (edificio.getDescricao().equals(descricao)) {
					if(leilao.getStatus().equals("EM ANDAMENTO")) {
						edificioEncontrado = edificio;
					}
				}
				System.out.println();
			}
		}
		for(Leilao leilao : leiloes) {
			for(Carro carro: leilao.getCarros()) {
				if (carro.getDescricao().equals(descricao)) {
					if(leilao.getStatus().equals("EM ANDAMENTO")) {
						carroEncontrado = carro;
					}
				}
				System.out.println();
			}
		}
		for(Leilao leilao : leiloes) {
			for(Motorcicleta moto: leilao.getMotos()) {
				if (moto.getDescricao().equals(descricao)) {
					if(leilao.getStatus().equals("EM ANDAMENTO")) {
						motoEncontrada = moto;
					}
				}
				System.out.println();
			}
		}
		
		System.out.println("Valor lance: ");
		double lanceValor = input.nextDouble();
		
		if(casaEncontrada != null) {
			casaEncontrada.darLance(lanceValor, logado);
		}
		if(apEncontrado != null) {
			apEncontrado.darLance(lanceValor, logado);
		}
		if(terrenoEncontrado != null) {
			terrenoEncontrado.darLance(lanceValor, logado);
		}
		if(edificioEncontrado != null) {
			edificioEncontrado.darLance(lanceValor, logado);
		}
		if(carroEncontrado != null) {
			carroEncontrado.darLance(lanceValor, logado);
		}
		if(motoEncontrada != null) {
			motoEncontrada.darLance(lanceValor, logado);
		}
		menuDepoisLogin();
	}
	
	public static void adicionarProdutoLeilao(Leilao leilao) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nInforme qual tipo de produto: ");
		System.out.println("1)Casa\n2)Apartamento\n3)Terreno\n4)Edificio\n5)Carro\n6)Motorcicleta");
		int opcao = input.nextInt();
		
		switch(opcao) {
			case 1:
				adicionarCasa(leilao);
				break;
			case 2:
				adicionarApartamento(leilao);
				break;
			case 3:
				adicionarTerreno(leilao);
				break;
			case 4:
				adicionarEdificio(leilao);
				break;
			case 5:
				adicionarCarro(leilao);
				break;
			case 6:
				adicionarMotorcicleta(leilao);
				break;
			default: break;
		}
		menuDepoisLogin();
		
	}
	
	public static void menuListarProdutos() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n1) Todos\n2) Imoveis");
		System.out.println("3) Veiculos");
		int opcao = input.nextInt();
		switch(opcao) {
			case 1:
				for(Leilao leilao : leiloes) {
					for(Casa casa: leilao.getCasas()) {
						imprimirCasa(casa, leilao);
					}
				}
				for(Leilao leilao : leiloes) {
					for(Apartamento ap: leilao.getApartamentos()) {
						imprimirApartamento(ap, leilao);
					}
				}
				for(Leilao leilao : leiloes) {
					for(Terreno terreno: leilao.getTerrenos()) {
						imprimirTerreno(terreno, leilao);
					}
				}
				for(Leilao leilao : leiloes) {
					for(Edificio edificio: leilao.getEdificios()) {
						imprimirEdificio(edificio, leilao);
					}
				}
				for(Leilao leilao : leiloes) {
					for(Carro carro: leilao.getCarros()) {
						imprimirCarro(carro, leilao);
					}
				}
				for(Leilao leilao : leiloes) {
					for(Motorcicleta moto: leilao.getMotos()) {
						imprimirMotorcicleta(moto, leilao);
					}
				}
				break;
			case 2:
				for(Leilao leilao : leiloes) {
					for(Casa casa: leilao.getCasas()) {
						imprimirCasa(casa, leilao);
					}
				}
				for(Leilao leilao : leiloes) {
					for(Apartamento ap: leilao.getApartamentos()) {
						imprimirApartamento(ap, leilao);
					}
				}
				for(Leilao leilao : leiloes) {
					for(Terreno terreno: leilao.getTerrenos()) {
						imprimirTerreno(terreno, leilao);
					}
				}
				for(Leilao leilao : leiloes) {
					for(Edificio edificio: leilao.getEdificios()) {
						imprimirEdificio(edificio, leilao);
					}
				}
				break;
			case 3:
				for(Leilao leilao : leiloes) {
					for(Carro carro: leilao.getCarros()) {
						imprimirCarro(carro, leilao);
					}
				}
				for(Leilao leilao : leiloes) {
					for(Motorcicleta moto: leilao.getMotos()) {
						imprimirMotorcicleta(moto, leilao);
					}
				}
				break;
		}
		menuDepoisLogin();
	}
	
	public static void adicionarCasa(Leilao leilao) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\nEndereco:");
		String endereco = input.next();
		System.out.println("\n\nPreço Original (R$):");
		double preco = input.nextDouble();
		System.out.println("\n\nDescrição:");
		String descricao = input.next();
		System.out.println("\n\nInscrição municipal:");
		String inscricaoMunicipal = input.next();
		System.out.println("\n\nArea Construida:");
		double areaConstruida = input.nextDouble();
		System.out.println("\n\nArea Total:");
		double area = input.nextDouble();
		System.out.println("\n\nComodos:");
		int comodos = input.nextInt();
		System.out.println("\n\nTem Piscina?\n (1)Sim(2)Não:");
		int opcao = input.nextInt();
		boolean piscina;
		if(opcao == 1) piscina = true;
		else piscina = false;
		System.out.println("\n\nGaragem:");
		int garagem = input.nextInt();
		System.out.println("\n\nLance Minimo:");
		double lanceMinimo = input.nextDouble();
		
		Casa casa = new Casa(endereco, preco, descricao, inscricaoMunicipal,
				lanceMinimo, areaConstruida, area, comodos, piscina, garagem);
		
		leilao.addCasa(casa);
	}
	
	public static void adicionarApartamento(Leilao leilao) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\nEndereco:");
		String endereco = input.next();
		System.out.println("\n\nPreço Original (R$):");
		double preco = input.nextDouble();
		System.out.println("\n\nDescrição:");
		String descricao = input.next();
		System.out.println("\n\nInscrição municipal:");
		String inscricaoMunicipal = input.next();
		System.out.println("\n\nAndar:");
		String andar = input.next();
		System.out.println("\n\nBloco:");
		String bloco = input.next();
		System.out.println("\n\nValor condominio:");
		double condominio = input.nextDouble();
		System.out.println("\n\nNumero apartamento:");
		int apartamento = input.nextInt();
		System.out.println("\n\nArea:");
		double area = input.nextDouble();
		System.out.println("\n\nComodos:");
		int comodos = input.nextInt();
		System.out.println("\n\nGaragem:");
		int garagem = input.nextInt();
		System.out.println("\n\nLance Minimo:");
		double lanceMinimo = input.nextDouble();
		
		Apartamento ap = new Apartamento(endereco, preco, descricao, inscricaoMunicipal,
				lanceMinimo, andar, bloco, condominio, apartamento, area, comodos, garagem);
		
		leilao.addApartamento(ap);
	}
	public static void adicionarTerreno(Leilao leilao) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\nEndereco:");
		String endereco = input.next();
		System.out.println("\n\nPreço Original (R$):");
		double preco = input.nextDouble();
		System.out.println("\n\nDescrição:");
		String descricao = input.next();
		System.out.println("\n\nInscrição municipal:");
		String inscricaoMunicipal = input.next();
		System.out.println("\n\nArea:");
		double area = input.nextDouble();
		System.out.println("\n\nÉ murado?\n (1)Sim (2)Não:");
		int opcao = input.nextInt();
		boolean murado;
		if(opcao == 1) murado= true;
		else murado = false;
		System.out.println("\n\nQuadra:");
		String quadra = input.next();
		System.out.println("\n\nLocalização:");
		String localizacao = input.next();
		System.out.println("\n\nLance Minimo:");
		double lanceMinimo = input.nextDouble();
		
		Terreno terreno = new Terreno(endereco, preco, descricao, inscricaoMunicipal,
				lanceMinimo, area, murado, quadra, localizacao);
		
		leilao.addTerreno(terreno);
	}
	public static void adicionarEdificio(Leilao leilao) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\nEndereco:");
		String endereco = input.next();
		System.out.println("\n\nPreço Original (R$):");
		double preco = input.nextDouble();
		System.out.println("\n\nDescrição:");
		String descricao = input.next();
		System.out.println("\n\nInscrição municipal:");
		String inscricaoMunicipal = input.next();
		System.out.println("\n\nAndares:");
		int andares = input.nextInt();
		System.out.println("\n\nComercial?\n (1)Sim(2)Não:");
		int opcao = input.nextInt();
		boolean comercial;
		if(opcao == 1) comercial= true;
		else comercial = false;
		System.out.println("\n\nNumeroSalas:");
		int numeroSalas = input.nextInt();
		System.out.println("\n\nLance Minimo:");
		double lanceMinimo = input.nextDouble();
		
		Edificio edificio = new Edificio(endereco, preco, descricao, inscricaoMunicipal,
							lanceMinimo, andares, comercial, numeroSalas);
		
		leilao.addEdificio(edificio);
	}
	
	public static void adicionarCarro(Leilao leilao) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\nDescricao:");
		String descricao = input.next();
		System.out.println("\n\nModelo:");
		String modelo = input.next();
		System.out.println("\n\nAno:");
		int ano = input.nextInt();
		System.out.println("\n\nPlaca:");
		String placa = input.next();
		System.out.println("\n\nCombustivel:");
		String combustivel = input.next();
		System.out.println("\n\nCC:");
		int cc = input.nextInt();
		System.out.println("\n\nCor:");
		String cor = input.next();
		System.out.println("\n\nPortas:");
		int portas = input.nextInt();
		System.out.println("\n\nAro:");
		int aro = input.nextInt();
		System.out.println("\n\nArCondicionado?\n (1)Sim(2)Não:");
		int opcao = input.nextInt();
		boolean arCondicionado;
		if(opcao == 1) arCondicionado = true;
		else arCondicionado = false;
		System.out.println("\n\nDirecao?\n (1)Sim(2)Não:");
		opcao = input.nextInt();
		boolean direcao;
		if(opcao == 1) direcao = true;
		else direcao = false;
		System.out.println("\n\nLance Minimo:");
		double lanceMinimo = input.nextDouble();
		
		Carro carro = new Carro(descricao, modelo, ano, placa, combustivel, cc, cor, lanceMinimo,
					portas, aro, arCondicionado, direcao);
		
		leilao.addCarro(carro);
		
	}
	public static void adicionarMotorcicleta(Leilao leilao) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\nDescricao:");
		String descricao = input.next();
		System.out.println("\n\nModelo:");
		String modelo = input.next();
		System.out.println("\n\nAno:");
		int ano = input.nextInt();
		System.out.println("\n\nPlaca:");
		String placa = input.next();
		System.out.println("\n\nCombustivel:");
		String combustivel = input.next();
		System.out.println("\n\nCC:");
		int cc = input.nextInt();
		System.out.println("\n\nCor:");
		String cor = input.next();
		System.out.println("\n\nAro Roda:");
		int aroRoda = input.nextInt();
		System.out.println("\n\nPartida Eletrica?\n (1)Sim(2)Não:");
		int opcao = input.nextInt();
		boolean partidaEletrica;
		if(opcao == 1) partidaEletrica = true;
		else partidaEletrica = false;
		System.out.println("\n\nLance Minimo:");
		double lanceMinimo = input.nextDouble();
		
		Motorcicleta moto = new Motorcicleta(descricao, modelo, ano, placa, combustivel, cc, cor,
							lanceMinimo, aroRoda, partidaEletrica);
		
		leilao.addMotorcicleta(moto);
	}
}

