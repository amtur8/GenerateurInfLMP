package ca.ulaval.amtur8.GenerateurInfLMP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestModalFormula {

	private ConjunctionFormula top;
	private DisjunctionFormula dTop;
	@Before
	public void setUp() throws Exception {
		top = new ConjunctionFormula();
		dTop = new DisjunctionFormula(top);
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
		ModalFormula formula = aModalFormula().withLabel("a").build();
		ModalFormula formulaWithADifferentAction = aModalFormula().withLabel("b").build();
		assertFalse(formula.canDo(formulaWithADifferentAction));
	}

	@Test
	public void testModalCanDoTop() {
		ModalFormula formula = aModalFormula().build();
		assertTrue(formula.canDo(top));
		assertFalse(top.canDo(formula));
	}

	@Test
	public void testModalCanDoDTop() {
		ModalFormula formula = aModalFormula().build();
		assertTrue(formula.canDo(dTop));
		assertFalse(dTop.canDo(formula));
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
		
		public ModalFormulaBuilder withLabel(String label) {
			this.label = new Label(label);
			return this;
		}

		public ModalFormula build() {
			return new ModalFormula(label, probability, dTop);
		}
	}
}
