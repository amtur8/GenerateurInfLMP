package amtur8.GenerateurInfLMP;

public class ModalFormula implements Formula {

	private Label action;
	private float probability;
	private DisjunctionFormula formula;
	
	@Override
	public boolean canDo(Formula f) {
		return false;
	}
	
	public boolean canDo(ModalFormula f) {
		if (f.getAction() != this.action) {
			return false;
		}
		if (f.getProbability() < this.probability) {
			return false;
		}
		return f.getFormula().canDo(this.formula);
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

	private Formula getFormula() {
		return formula;
	}

	private float getProbability() {
		return probability;
	}	
}
