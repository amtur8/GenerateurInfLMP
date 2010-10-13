package ca.ulaval.amtur8.GenerateurInfLMP;

public class ModalFormulaBuilder implements FormulaBuilder {
	private Label label = new Label("a");
	private double probability = 0.5;
	private DisjunctionFormula formula = DisjunctionFormula.DTOP;

	public ModalFormulaBuilder withProbability(double probability) {
		this.probability = probability;
		return this;
	}
	
	public ModalFormulaBuilder withLabel(String label) {
		this.label = new Label(label);
		return this;
	}

	public ModalFormula build() {
		return new ModalFormula(label, probability, formula);
	}
}
