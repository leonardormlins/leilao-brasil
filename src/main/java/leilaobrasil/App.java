package leilaobrasil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		Carro carro = new Carro("Uno", 1991, "BHN2662", "Gasolina", 1000, "Cinza", 4, 13, false, false);
		System.out.println(carro.getAroRoda());
	}
}
