package amtur8.GenerateurInfLMP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOfCanDoMethodsConjunctFormula {
	
	private ConjunctionFormula cTop, cModalF;
	private ModalFormula modalF;

	@Before
	public void setUp() throws Exception {
		cTop = new ConjunctionFormula();
		modalF = new ModalFormula(new Label("a"), 0.5, new DisjunctionFormula(cTop));
		cModalF = new ConjunctionFormula(modalF);
	}

	@Test
	public void topCanNotDoModal() {
		assertFalse(cTop.canDo(cModalF));
	}

	@Test
	public void modalCanDoTop() {
		assertTrue(cModalF.canDo(cTop));
	}
}
