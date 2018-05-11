import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Karen 10 de mai de 2018
 */
public class TesteValidador {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testNumeros() {
		Validador validador = new Validador();
		assertEquals(true, validador.validateExpr("1"));
	}

	@Test
	public void testInicioOperador() {
		Validador validador = new Validador();
		assertEquals(false, validador.validateExpr(")"));
	}

	@Test
	public void testOperacaoSimples() {
		Validador validador = new Validador();
		String operacao = "a + b";
		assertEquals(true, validador.validateExpr(operacao.replaceAll("\\s+", "")));
	}

	@Test
	public void testOperacaoComParenteses() {
		Validador validador = new Validador();
		String operacao = "(a + b)";
		assertEquals(true, validador.validateExpr(operacao.replaceAll("\\s+", "")));
	}

	@Test
	public void testOperacaoFaltaParenteses() {
		Validador validador = new Validador();
		String operacao = "(a + b";
		assertEquals(false, validador.validateExpr(operacao.replaceAll("\\s+", "")));
	}
	
	@Test
	public void testOperacaoMaiorComParenteses() {
		Validador validador = new Validador();
		String operacao = "(a – (b * c) / 4)";
		assertEquals(false, validador.validateExpr(operacao.replaceAll("\\s+", "")));
	}

}
