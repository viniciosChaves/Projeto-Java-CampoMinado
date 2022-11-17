import br.com.cod3r.cm.modelo.Tabuleiro;
import br.com.cod3r.cm.visao.TabuleiroConsole;

public class aplicacao {
public static void main(String[] args) {
	Tabuleiro tabuleiro = new Tabuleiro(20, 20, 10);
	
	new TabuleiroConsole(tabuleiro);
	
	
	
}
}
