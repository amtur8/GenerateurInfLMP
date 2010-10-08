package amtur8.GenerateurInfLMP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOfCanDoMethodsDisjuctFormula {

	private DisjunctionFormula bottom, dTop, dmodalF;
	private ConjunctionFormula cTop, cModalF;
	private ModalFormula modalF;
	
	@Before
	public void setUp() throws Exception {
		cTop = new ConjunctionFormula();
		bottom = new DisjunctionFormula();
		dTop = new DisjunctionFormula(cTop);
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
