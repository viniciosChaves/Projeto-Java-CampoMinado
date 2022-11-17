package br.com.cod3r.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.cod3r.cm.excecao.ExplosaoException;
import br.com.cod3r.cm.excecao.SairException;
import br.com.cod3r.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
private Tabuleiro tabuleiro;
private Scanner entrada = new Scanner(System.in);
private String anotherString;

public TabuleiroConsole(Tabuleiro tabuleiro) {
	
	this.tabuleiro = tabuleiro;
	executarJogo();
}

private void executarJogo() {
	try {
		boolean continuar = true;
		while(continuar) {
			cicloDojogo();
			System.out.println("outra partida ? (S/n) ");
			String resposta = entrada.nextLine();
			if ("n".equalsIgnoreCase(resposta)) {
				continuar = false;
			}else {}
			tabuleiro.reiniciar();
		}
	}catch (SairException e) {
	System.out.println("Tchau!!");
	
	}finally {
		entrada.close();
	}
	
}

private void cicloDojogo() {
	try {
		while(!tabuleiro.objetivoAlcancado()) {
			System.out.println(tabuleiro);
			
			String digitado = capturarValorDigitado("Digite (x , y): ");
			
			Iterator<Integer>xy =Arrays.stream(digitado.split(","))
			.map(e ->Integer.parseInt(e.trim())).iterator();
			
			digitado =capturarValorDigitado("1 pra abrir ou 2 -(des)marcar");
			
			
			if ("1".equals(digitado)) {
				tabuleiro.abrir(xy.next(), xy.next());
			}else if ("2".equals(digitado)) {
				tabuleiro.Marcar(xy.next(), xy.next());;
			}
		}
		System.out.println(tabuleiro);
		System.out.println("voce ganhou");
	}catch(ExplosaoException e) {
		System.out.println(tabuleiro);
		System.out.println("Voce perdeu!! ");
	}
	
}

	private String  capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		return digitado;
	}

}
