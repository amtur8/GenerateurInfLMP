package amtur8.GenerateurInfLMP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOfCanDoMethods {
	
	private Label action, action2;
	private ConjunctionFormula top; 
	private DisjunctionFormula dTop;
	private ModalFormula modForm1, modForm2, modForm3;

	@Before
	public void setUp() throws Exception {
		action = new Label("a");
		action2 = new Label("b");
		top = new ConjunctionFormula(); 
		dTop = new DisjunctionFormula(top);
		modForm1 = new ModalFormula(action, 0.5, dTop);
		modForm2 = new ModalFormula(action, 0.6, dTop);
		modForm3 = new ModalFormula(action2, 0.5, dTop);
	}

	@Test
	public void testCanDoModalFormula() {
		assertTrue(modForm2.canDo(modForm1));
		assertFalse(modForm1.canDo(modForm3));
		assertFalse(modForm3.canDo(modForm2));
	}
}
