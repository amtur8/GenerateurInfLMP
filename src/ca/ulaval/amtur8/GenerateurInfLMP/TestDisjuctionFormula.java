package ca.ulaval.amtur8.GenerateurInfLMP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDisjuctionFormula {

	private DisjunctionFormula bottom, dTop, dmodalF;
	private ConjunctionFormula cModalF;
	private ModalFormula modalF;
	
	@Before
	public void setUp() throws Exception {
		bottom = DisjunctionFormula.BOTTOM;
		dTop = DisjunctionFormula.DTOP;
		modalF = new ModalFormula(new Label("a"), 0.5, dTop);
		cModalF = new ConjunctionFormula(modalF);
		dmodalF = new DisjunctionFormula(cModalF);
	}

	@Test
	public void bottomCanDoTop() {
		assertTrue(bottom.canDo(dTop));
	}

	@Test
	public void topCanNotDoBottom() {
		assertFalse(dTop.canDo(bottom));
	}
	
	@Test
	public void modalFormulaCanDoTop() {
		assertTrue(dmodalF.canDo(dTop));
	}
}
