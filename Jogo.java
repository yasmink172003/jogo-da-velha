package main;

import java.util.Scanner;

public class Jogo {

	public Tabuleiro tabuleiro;
	public Jogador jogador1;
	public Jogador jogador2;
	public Scanner entrada = new Scanner(System.in);

	public Jogo() {
		System.out.println("Bem vindo!");
		this.tabuleiro = new Tabuleiro();
		this.jogador1 = new Jogador(1);
		this.jogador2 = new Jogador(2);
	}

	// Verifica se o tabuleiro foi vencido por algum jogador
	public boolean existeVencedor(Tabuleiro tabuleiro) {
		if (tabuleiro.venceuVertical())
			return true;
		if (tabuleiro.venceuHorizontal())
			return true;
		if (tabuleiro.venceuDiagonal())
			return true;
		return false;
	}
	
	//Jogador faz marcação no tabuleiro e retorna o tabuleiro marcado
	public Tabuleiro vezJogador(Jogador jogador, Tabuleiro tabuleiro) {
		System.out.println("\n Vez de " + jogador.nomeJogador + "! \n");
		mostrarTabuleiro();
		return jogador.jogar(tabuleiro);
	}

	public void mostrarTabuleiro() {
		this.tabuleiro.exibirTabuleiro();
	}

	// Inicia o jogo
	public void iniciarJogo() {
		int jogadasRestantes = 9;
		// Verifica se o jogo ja acabou
		while (jogadasRestantes != 0) {
			
			if (jogadasRestantes != 0) {
				this.tabuleiro = vezJogador(jogador1, this.tabuleiro);
				// Caso verdadeiro, o jogador 1 será o vencedor e zera as jogadas restantes
				if (existeVencedor(this.tabuleiro)) {
					jogadasRestantes = 0;
					jogador1.vencedor = true;
				} else {// caso não haja o vencedor ainda, diminui um numero de jogada até o fim
					jogadasRestantes--;
				}
			}
			
			if (jogadasRestantes != 0) {
				this.tabuleiro = vezJogador(jogador2, this.tabuleiro);
				// Caso verdadeiro, o jogador 2 será vencedor e zera as jogadas restantes
				if (existeVencedor(this.tabuleiro)) {
					jogadasRestantes = 0;
					jogador2.vencedor = true;
				} else { // caso não haja o vencedor ainda, diminui um numero de jogada até o fim
					jogadasRestantes--;
				}
			}
		}
		mostrarTabuleiro();
		// verifica quem ganhou ou se empatou
		if (jogador1.vencedor)
			System.out.println("\n Parabéns, " + jogador1.nomeJogador + ". Você venceu!");
		else if (jogador2.vencedor)
			System.out.println("\n Parabéns, " + jogador2.nomeJogador + ". Você venceu!");
		else {
			System.out.println("\nJogo empatado!");
		}

	}
}