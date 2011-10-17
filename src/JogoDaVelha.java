public class JogoDaVelha {

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
		
		}else{
		
			return false;
		
		}
	}
}
			
