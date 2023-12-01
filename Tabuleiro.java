package main;

public class Tabuleiro {

	public int[][] tabuleiro = new int[3][3];

	public Tabuleiro() {
		zerarTabuleiro();
	}

	// Atribui zero para todas as posições do tabuleiro
	public void zerarTabuleiro() {
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				this.tabuleiro[linha][coluna] = 0;
			}
		}
	}

	// Mostra o tabuleiro
	public void exibirTabuleiro() {
		System.out.println("    C1 | C2  | C3 ");
		for (int linha = 0; linha < 3; linha++) {
			System.out.print("L"+ (linha+1)+ " ");
			for (int coluna = 0; coluna < 3; coluna++) {
				if (tabuleiro[linha][coluna] == 1) {
					System.out.print(" X ");
				}
				if (tabuleiro[linha][coluna] == 2) {
					System.out.print(" O ");
				}
				if (tabuleiro[linha][coluna] == 0) {
					System.out.print("   ");
				}
				if (coluna + 1 != 3) {
					System.out.print(" | ");
				}
			}
			System.out.println();
		}

	}

	// Verifica se há vencedor verticalmente
	public boolean venceuVertical() {
		for (int coluna = 0; coluna < 3; coluna++) {
			if (this.tabuleiro[0][coluna] == this.tabuleiro[1][coluna]
					&& this.tabuleiro[1][coluna] == this.tabuleiro[2][coluna]) {
				if (this.tabuleiro[0][coluna] != 0)
					return true;
			}
		}
		return false;
	}

	// Verifica se há vencedor horizontalmente
	public boolean venceuHorizontal() {
		for (int linha = 0; linha < 3; linha++) {
			if (this.tabuleiro[linha][0] == this.tabuleiro[linha][1]
					&& this.tabuleiro[linha][1] == this.tabuleiro[linha][2]) {
				if (tabuleiro[linha][0] != 0)
					return true;
			}
		}
		return false;
	}

	// Verifica se há vencedor pelas diagonais
	public boolean venceuDiagonal() {
		if (this.tabuleiro[2][0] == this.tabuleiro[1][1] && this.tabuleiro[1][1] == this.tabuleiro[0][2])
			if (this.tabuleiro[1][1] != 0)
				return true;
		if (this.tabuleiro[0][0] == this.tabuleiro[1][1] && this.tabuleiro[1][1] == this.tabuleiro[2][2])
			if (this.tabuleiro[1][1] != 0)
				return true;
		return false;
	}

}