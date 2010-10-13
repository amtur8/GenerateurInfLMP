package ca.ulaval.amtur8.GenerateurInfLMP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestConjunctionFormula {
	
	private ConjunctionFormula cModalF;
	private ModalFormula modalF;

	@Before
	public void setUp() throws Exception {
		modalF = new ModalFormula(new Label("a"), 0.5, DisjunctionFormula.DTOP);
		cModalF = new ConjunctionFormula(modalF);
	}

	@Test
	public void topCanNotDoModal() {
		assertFalse(ConjunctionFormula.TOP.canDo(cModalF));
	}

	@Test
	public void modalCanDoTop() {
		assertTrue(cModalF.canDo(ConjunctionFormula.TOP));
	}
}
