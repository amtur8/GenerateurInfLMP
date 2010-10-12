package ca.ulaval.amtur8.GenerateurInfLMP;

public class ModalFormula implements Formula {

	private Label action;
	private double probability;
	private DisjunctionFormula formula;
	
	@Override
	public boolean canDo(Formula f) {
		return false;
	}
	
	public boolean hasAction(Label action) {
		return this.action.equals(action);
	}
	
	public int compareProbability(int probability) {
		return 0;
	}
	
	public boolean canDo(ModalFormula formule) {
		if (!formule.hasAction(this.action)) {
			return false;
		}
		if (formule.getProbability() > this.probability) {
			return false;
		}
		return formule.getFormula().canDo(this.formula);
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

	private Label getAction() {
		return this.action;
	}

	private DisjunctionFormula getFormula() {
		return formula;
	}

	private double getProbability() {
		return probability;
	}

	public ModalFormula(Label action, double d,
			DisjunctionFormula formula) {
		super();
		this.action = action;
		this.probability = d;
		this.formula = formula;
	}	
}
