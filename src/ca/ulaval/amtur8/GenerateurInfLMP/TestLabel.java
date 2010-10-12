package ca.ulaval.amtur8.GenerateurInfLMP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLabel {

	private Label label1, label2, label3;
	private Object obj;
	
	@Before
	public void setUp() throws Exception {
		label1 = new Label("a");
		label2 = new Label("a");
		label3 = new Label("b");
		obj = new ModalFormula(label1, 0.5, null);
	}

	@Test
	public void testEqualsObject1() {
		assertTrue(label1.equals(label2));
	}

	@Test
	public void testEqualsObject2() {
		assertFalse(label1.equals(label3));
	}
	
	@Test
	public void testEqualsObject3() {
		assertFalse(label1.equals(obj));
	}
}
