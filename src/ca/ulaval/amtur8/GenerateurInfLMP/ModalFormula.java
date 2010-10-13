package ca.ulaval.amtur8.GenerateurInfLMP;

public class ModalFormula implements Formula {

	private Label action;
	private double probability;
	private DisjunctionFormula formula;
	
	public ModalFormula(Label action, double d,
			DisjunctionFormula formula) {
		super();
		this.action = action;
		this.probability = d;
		this.formula = formula;
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
		return f.isDoneBy(this);
	}
	
	public boolean canDo(DisjunctionFormula f) {
		return f.isDoneBy(this);
	}

	@Override
	public Formula and(Formula f2) {
		return f2.and(new ConjunctionFormula(this));
	}

	@Override
	public Formula or(Formula f2) {
		return f2.or(new DisjunctionFormula(new ConjunctionFormula(this)));
	}

	@Override
	public boolean canDo(Formula formule) {
		return formule.isDoneBy(this);
	}

	@Override
	public boolean isDoneBy(Formula formule) {
		return formule.canDo(this);
	}	
}
