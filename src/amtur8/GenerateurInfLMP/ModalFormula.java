package amtur8.GenerateurInfLMP;

public class ModalFormula implements Formula {

	private Label action;
	private float probability;
	private DisjunctionFormula formula;
	
	@Override
	public boolean models(Formula f) {
		if (f instanceof ConjunctionFormula) {
			return false;
		}
		if (!f.hasAction(action)) {
			return false;
		}
		if (((ModalFormula) f).getProbability() < probability) {
			return false;
		}
		return ((((ModalFormula) f).getFormula()).models(formula));
	}

	private Formula getFormula() {
		return formula;
	}

	private float getProbability() {
		return probability;
	}

	@Override
	public boolean hasAction(Label action) {
		return action == this.action;
	}
	
	
}
