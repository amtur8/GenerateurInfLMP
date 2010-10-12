package ca.ulaval.amtur8.GenerateurInfLMP;

public class ModalFormula implements Formula {

	private Label action;
	private double probability;
	private DisjunctionFormula formula;
	
	@Override
	public boolean canDo(Formula f) {
		return false;
	}
	
	public boolean canDo(ModalFormula formule) {
		return formule.isDoneBy(this.action, this.probability, this.formula);
	}
	
	private boolean isDoneBy(Label action2, double probability2,
			DisjunctionFormula formula2) {
		if (!this.action.equals(action2)) {
			return false;
		}
		if (this.probability > probability2) {
			return false;
		}
		return formula2.canDo(this.formula);
	}

	public boolean canDo(ConjunctionFormula f) {
		ConjunctionFormula newFormula = new ConjunctionFormula(this);
		return newFormula.canDo(f);
	}
	
	public boolean canDo(DisjunctionFormula f) {
		ConjunctionFormula newCFormula = new ConjunctionFormula(this);
		DisjunctionFormula newDFormula = new DisjunctionFormula(newCFormula);
		return newDFormula.canDo(f);
	}

	public ModalFormula(Label action, double d,
			DisjunctionFormula formula) {
		super();
		this.action = action;
		this.probability = d;
		this.formula = formula;
	}	
}
