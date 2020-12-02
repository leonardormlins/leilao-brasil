package leilaobrasil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import lombok.Getter;
import lombok.Setter;

public class Financeira extends Usuario{
	@Getter @Setter
	private String cnpj;
	
	public Financeira(String usuario, String senha, String cnpj) {
		super(usuario, senha, 2);
		setCnpj(cnpj);
	}
	
	public Leilao criarLeilao(String nomeLeilao, int ano, int mes, int dia, int hora, int minuto) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	    Calendar calendar = new GregorianCalendar();
	    calendar.set(Calendar.YEAR, ano);
	    calendar.set(Calendar.YEAR, mes);
	    calendar.set(Calendar.YEAR, dia);
	    calendar.set(Calendar.YEAR, hora);
	    calendar.set(Calendar.YEAR, minuto);
		return new Leilao(nomeLeilao, this, calendar);
	}
}
