package ca.ulaval.amtur8.GenerateurInfLMP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestModalFormula {

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
	public void testCanDoModalFormulaSameActionProbabilityGreaterThenTop() {
		ModalFormula sameFormulaWithOtherProbability = aModalFormula()
				.withProbability(0.5).build();
		ModalFormula formula = aModalFormula().withProbability(0.6).build();

		assertTrue(formula.canDo(sameFormulaWithOtherProbability));
	}

	@Test
	public void testCanNotDoModalFormulaDifferentAction() {
		assertFalse(modForm1.canDo(modForm3));
	}

	@Test
	public void testCanNotDoModalFormulaDifferentAction2() {
		assertFalse(modForm3.canDo(modForm2));
	}

	@Test
	public void testModalCanDoTop() {
		assertTrue(modForm1.canDo(top));
		assertFalse(top.canDo(modForm2));
	}

	@Test
	public void testModalCanDoDTop() {
		assertTrue(modForm1.canDo(dTop));
		assertFalse(dTop.canDo(modForm2));
	}

	@Test
	public void testCompareProbabilityEqualsShouldBeZero() {

	}

	private ModalFormulaBuilder aModalFormula() {
		return new ModalFormulaBuilder();
	}

	private class ModalFormulaBuilder {

		private Label label = new Label("a");
		private double probability = 0.5;
		private DisjunctionFormula dTop = new DisjunctionFormula(top);

		public ModalFormulaBuilder withProbability(double probability) {
			this.probability = probability;
			return this;
		}

		public ModalFormula build() {
			return new ModalFormula(label, probability, dTop);
		}
	}
}
