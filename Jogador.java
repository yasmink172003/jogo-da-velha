package main;

import java.util.Scanner;

public class Jogador {

	public String nomeJogador;
	public int numeroJogador;
	public boolean vencedor;
	public Scanner entrada = new Scanner(System.in);

	public Jogador(int numeroJogador) {
		System.out.println("Digite o nome do jogador " + numeroJogador + ": ");
		String nomeJogador = entrada.next();
		this.nomeJogador = nomeJogador;
		this.numeroJogador = numeroJogador;
		this.vencedor = false;
	}

	// O jogador faz sua marcação no tabuleiro
	public Tabuleiro jogar(Tabuleiro tabuleiro) {
		int linhaEscolhida = 0;
		int colunaEscolhida = 0;
		// Le a linha e verifica se é valida
		System.out.println("\nDigite a linha: ");
		linhaEscolhida = entrada.nextInt();
		while (linhaEscolhida < 1 || linhaEscolhida > 3) {
			System.out.println("A linha deve ser entre 1 e 3 ");
			linhaEscolhida = entrada.nextInt();
		}

		// Le a coluna e verifica se é valida
		System.out.println("Digite a coluna: ");
		colunaEscolhida = entrada.nextInt();
		while (colunaEscolhida < 1 || colunaEscolhida > 3) {
			System.out.println("A coluna deve ser entre 1 e 3 ");
			colunaEscolhida = entrada.nextInt();
		}

		linhaEscolhida--;
		colunaEscolhida--;
		// Caso o valor da casa esteja zerada, o numero do jogador será atribuido
		if (tabuleiro.tabuleiro[linhaEscolhida][colunaEscolhida] == 0) {
			tabuleiro.tabuleiro[linhaEscolhida][colunaEscolhida] = this.numeroJogador;
		} else { // Se não, utilizará função recursiva para obter uma nova casa válida
			System.out.println("A casa já está preenchida");
			tabuleiro = jogar(tabuleiro);
		}
		return tabuleiro;
	}
}