import static org.junit.Assert.*;

import org.junit.Test;


public class JogoDaVelhaTest {

	@Test
	public void deveInicializarJogoVazio() {
		String[][] tabuleiroEsperado = new String[][] {{"", "", ""}, 
										  			   {"", "", ""}, 
										  			   {"", "", ""}};
		
		String[][] tabuleiroEncontrado = JogoDaVelha.inicializar();
		assertArrayEquals(tabuleiroEsperado, tabuleiroEncontrado);
	}
	
	@Test
	public void deveAlterarPosicaoZeroZeroDoTabuleiroComJogadorBola() throws Exception {
		String[][] tabuleiroEsperado = new String[][] {{"O", "", ""}, 
										  			   {"", "", ""}, 
										  			   {"", "", ""}};
		String[][] tabuleiro = new String[][] {{"", "", ""}, 
										  	   {"", "", ""}, 
										  	   {"", "", ""}};
		JogoDaVelha.jogar(tabuleiro, 0, 0, "O");
		assertArrayEquals(tabuleiroEsperado, tabuleiro);
	}

	@Test
	public void deveAlterarPosicaoZeroDoisDoTabuleiroComJogadorXis() throws Exception {
		String[][] tabuleiroEsperado = new String[][] {{"", "", "X"}, 
										  			   {"", "", ""}, 
										  			   {"", "", ""}};
		String[][] tabuleiro = new String[][] {{"", "", ""}, 
										  	   {"", "", ""}, 
										  	   {"", "", ""}};
		JogoDaVelha.jogar(tabuleiro, 0, 2, "X");
		assertArrayEquals(tabuleiroEsperado, tabuleiro);
	}
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDeveAlterarPosicaoUmDoisJaOcupadaPeloJogadorBola() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", "O"}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 1, 2, "X");
	}
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDeveAlterarPosicaoDoisDoisJaOcupadaPeloJogadorXis() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", "X"}};
		JogoDaVelha.jogar(tabuleiroInicial, 2, 2, "O");
	}
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDeveAlterarPosicaoUmUmJaOcupadaPeloProprioJogador() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "O", ""}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 1, 1, "O");
	}
	
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDevePermitirPosicaoTresUmForaDoTabuleiro() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 3, 1, "O");
	}
	
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDevePermitirPosicaoCincoUmForaDoTabuleiro() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 5, 1, "O");
	}
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDevePermitirPosicaoDoisSeisForaDoTabuleiro() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 2, 6, "O");
	}
	
	@Test(expected = JogoDaVelhaException.class)
	public void naoDevePermitirPosicaoDoisTresForaDoTabuleiro() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		JogoDaVelha.jogar(tabuleiroInicial, 2, 3, "O");
	}
	
	@Test
	public void deveConfirmarGanhadorXisPrimeiraLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"X", "X", "X"}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		
		assertTrue(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorXisSegundaLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"X", "X", "X"}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		
		assertTrue(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorXisTerceiraLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"X", "X", "X"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		
		assertTrue(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorBolaPrimeiraLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"O", "O", "O"}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		
		assertTrue(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorBolaSegundaLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"O", "O", "O"}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		
		assertTrue(existeGanhador);
	}
	
	@Test
	public void deveConfirmarGanhadorBolaTerceiraLinha() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"O", "O", "O"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		
		assertTrue(existeGanhador);
	}
	
	
	@Test // adicionado
	public void deveConfirmarGanhadorXisPrimeiraColuna() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"X", "", ""}, 
										  			  {"X", "", ""}, 
										  			  {"X", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		
		assertTrue(existeGanhador);
	}
	
	@Test // adicionado
	public void deveConfirmarGanhadorXisSegundaColuna() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "X", ""}, 
										  			  {"", "X", ""}, 
										  			  {"", "X", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		
		assertTrue(existeGanhador);
	}
	
	@Test // adicionado
	public void deveConfirmarGanhadorXisTerceiraColuna() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", "X"}, 
										  			  {"", "", "X"}, 
										  			  {"", "", "X"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		
		assertTrue(existeGanhador);
	}
	
	@Test // adicionado
	public void deveConfirmarGanhadorBolaPrimeiraColuna() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"O", "", ""}, 
										  			  {"O", "", ""}, 
										  			  {"O", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		
		assertTrue(existeGanhador);
	}
	
	@Test // adicionado
	public void deveConfirmarGanhadorBolaSegundaColuna() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "O", ""}, 
										  			  {"", "O", ""}, 
										  			  {"", "O", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		
		assertTrue(existeGanhador);
	}
	
	@Test // adicionado
	public void deveConfirmarGanhadorBolaTerceiraColuna() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", "O"}, 
										  			  {"", "", "O"}, 
										  			  {"", "", "O"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		
		assertTrue(existeGanhador);
	}
	
	@Test // adicionado
	public void deveConfirmarGanhadorXisTransversalColuna() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"X", "", ""}, 
										  			  {"", "X", ""}, 
										  			  {"", "", "X"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		
		assertTrue(existeGanhador);
	}
	
	@Test // adicionado
	public void deveConfirmarGanhadorBolaTransversalColuna() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"O", "", ""}, 
										  			  {"", "O", ""}, 
										  			  {"", "", "O"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		
		assertTrue(existeGanhador);
	}
	
	@Test
	public void naoDeveConfirmarGanhadorXisTabuleiroVazio() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		
		assertFalse(existeGanhador);
	}
	
	@Test
	public void naoDeveConfirmarGanhadorXisPrimeiraLinhaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"X", "", "X"}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		assertFalse(existeGanhador);
	}
	
	@Test
	public void naoDeveConfirmarGanhadorXisSegundaLinhaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"X", "X", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		assertFalse(existeGanhador);
	}
	
	@Test
	public void naoDeveConfirmarGanhadorXisTerceiraLinhaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "X", "X"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		assertFalse(existeGanhador);
	}
	
	@Test //adicionado
	public void naoDeveConfirmarGanhadorXisPrimeiraColunaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"X", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"X", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		assertFalse(existeGanhador);
	}
	
	@Test //adicionado
	public void naoDeveConfirmarGanhadorXisSegundaColunaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "X", ""}, 
										  			  {"", "X", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		assertFalse(existeGanhador);
	}
	
	@Test //adicionado
	public void naoDeveConfirmarGanhadorXisTerceiraColunaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", "X"}, 
										  			  {"", "", "X"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		assertFalse(existeGanhador);
	}
	
	@Test //adicionado
	public void naoDeveConfirmarGanhadorBolaPrimeiraLinhaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"O", "", "O"}, 
										  			  {"", "", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		assertFalse(existeGanhador);
	}
	
	@Test //adicionado
	public void naoDeveConfirmarGanhadorBolaSegundaLinhaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"O", "O", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		assertFalse(existeGanhador);
	}
	
	@Test //adicionado
	public void naoDeveConfirmarGanhadorBolaTerceiraLinhaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "O", "O"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		assertFalse(existeGanhador);
	}
	
	@Test //adicionado
	public void naoDeveConfirmarGanhadorBolaPrimeiraColunaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"O", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"O", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		assertFalse(existeGanhador);
	}
	
	@Test //adicionado
	public void naoDeveConfirmarGanhadorBolaSegundaColunaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "O", ""}, 
										  			  {"", "O", ""}, 
										  			  {"", "", ""}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		assertFalse(existeGanhador);
	}
	
	@Test //adicionado
	public void naoDeveConfirmarGanhadorBolaTerceiraColunaIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"", "", ""}, 
										  			  {"", "", "O"}, 
										  			  {"", "", "O"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		assertFalse(existeGanhador);
	}
	
	@Test //adicionado
	public void naoDeveConfirmarGanhadorXisTransversalIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"X", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", "X"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "X");
		assertFalse(existeGanhador);
	}
	
	@Test //adicionado
	public void naoDeveConfirmarGanhadorBolaTransversalIncompleta() throws Exception {
		String[][] tabuleiroInicial = new String[][] {{"O", "", ""}, 
										  			  {"", "", ""}, 
										  			  {"", "", "O"}};
		boolean existeGanhador = JogoDaVelha.existeGanhador(tabuleiroInicial, "O");
		assertFalse(existeGanhador);
	}
	
	
	
}
