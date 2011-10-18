import java.util.Scanner;
import java.util.Vector;


public class JogoDaVelha {
	
	public static void main(String[] args) throws JogoDaVelhaException{
		
		String[][] tabuleiro = inicializar();
		
		Scanner entrada = new Scanner(System.in);
		
		while(true){
			
			System.out.println("Faça uma jogada: ");
			String passandoJogada = entrada.nextLine();
			
			Vector jogadaVector = interpretarJogada(passandoJogada);
	
			String jogador = (String) jogadaVector.get(0);
			int linha = (Integer) jogadaVector.get(1);
			int coluna = (Integer) jogadaVector.get(2);
			
			jogar(tabuleiro, linha, coluna, jogador);
			
			mostrarTabuleiro(tabuleiro);
			
			boolean jogadorXisGanhou = existeGanhador(tabuleiro, "X");
			boolean jogadorBolaGanhou = existeGanhador(tabuleiro, "O");
			
			if(jogadorXisGanhou || jogadorBolaGanhou){
				System.out.println("Fim do jogo!");
			}else{
				
			}
		}
		
	}
	
	public static void mostrarTabuleiro(String[][]tabuleiro){
		
		for(int i = 0; i < tabuleiro.length; i++){
			for(int j = 0; j < tabuleiro.length; j++){
				System.out.print(tabuleiro[i][j]+ " | ");
			}
			System.out.println("");
		}
	}
	
	
	public static Vector interpretarJogada(String passandoJogada) {
		
		Vector jogada = new Vector();
		
		String[] jogadaArray = passandoJogada.split(" ");
		
		int linha = Integer.parseInt(jogadaArray[1]);
		int coluna = Integer.parseInt(jogadaArray[1]);

		jogada.add(jogadaArray[0]);
		jogada.add(linha);
		jogada.add(coluna);
		
		return jogada;
	}


	public static String[][] inicializar() {
		
		String [][] tabuleiroEsperado = {{"", "", ""},
						 {"", "", ""},
						 {"", "", ""}};							
		
		return tabuleiroEsperado;
	}
	

	public static void jogar(String[][] tabuleiro, int i, int j, String jogador) throws JogoDaVelhaException {
		verificaPosicaoForaDoTabuleiro(tabuleiro, i, j);/*chama o método criado a seguir,
		 												mas ambos estão dentro do método jogar*/
		
		if("".equals(tabuleiro[i][j])){
			tabuleiro[i][j] = jogador;
		} else {
			throw new JogoDaVelhaException("Jogada invalida");
		}
	}

	private static void verificaPosicaoForaDoTabuleiro(String[][] tabuleiro, int i, int j)//criando o método que eu chamei anteriormente
			throws JogoDaVelhaException {
		
		if(i >= tabuleiro.length || j >= tabuleiro.length){
			throw new JogoDaVelhaException("Jogada invalida");
		}
	}

	public static boolean existeGanhador(String[][] tabuleiro, String jogador) {
		
		//CONFIRMANDO GANHADOR XIS		
		
		//linhas
		if("X".equals(jogador) && tabuleiro[0][0] == jogador && tabuleiro[0][1] == jogador && tabuleiro[0][2] == jogador){
			
			return true;
		
		}else if("X".equals(jogador) &&tabuleiro[1][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[1][2] == jogador){
			
			return true;
		
		}else if("X".equals(jogador) &&tabuleiro[2][0] == jogador && tabuleiro[2][1] == jogador && tabuleiro[2][2] == jogador){
			
			return true;
		
		}
		//colunas
		else if("X".equals(jogador) &&tabuleiro[0][0] == jogador && tabuleiro[1][0] == jogador && tabuleiro[2][0] == jogador){
			
			return true;
		
		}else if("X".equals(jogador) &&tabuleiro[0][1] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][1] == jogador){
			
			return true;
		
		}else if("X".equals(jogador) && tabuleiro[0][2] == jogador && tabuleiro[1][2] == jogador && tabuleiro[2][2] == jogador){
			
			return true;
		
		}
		//transversal
		else if("X".equals(jogador) && tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador){
			
			return true;
		
		}else if("X".equals(jogador) && tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador){
			
			return true;
		
		}
	
		//CONFIRMANDO GANHADOR BOLA
		
		//linhas
		if("O".equals(jogador) && tabuleiro[0][0] == jogador && tabuleiro[0][1] == jogador && tabuleiro[0][2] == jogador){
			
			return true;
		
		}else if("O".equals(jogador) &&tabuleiro[1][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[1][2] == jogador){
			
			return true;
		
		}else if("O".equals(jogador) &&tabuleiro[2][0] == jogador && tabuleiro[2][1] == jogador && tabuleiro[2][2] == jogador){
			
			return true;
		
		}
		//colunas
		else if("O".equals(jogador) &&tabuleiro[0][0] == jogador && tabuleiro[1][0] == jogador && tabuleiro[2][0] == jogador){
			
			return true;
		
		}else if("O".equals(jogador) &&tabuleiro[0][1] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][1] == jogador){
			
			return true;
		
		}else if("O".equals(jogador) && tabuleiro[0][2] == jogador && tabuleiro[1][2] == jogador && tabuleiro[2][2] == jogador){
		
			return true;
		
		}
		//transversal
		else if("O".equals(jogador) && tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador){
			
			return true;
		
		}else if("O".equals(jogador) && tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador){
			
			return true;
		
		}else{
		
			return false;
		
		}
	}
}
			
