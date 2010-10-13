package ca.ulaval.amtur8.GenerateurInfLMP;

import java.util.ArrayList;
import java.util.Collection;

public class ConjunctionFormula implements Formula {

	private Collection<ModalFormula> formulas;
	
	public ConjunctionFormula(ModalFormula modalFormula) {
		formulas = new ArrayList<ModalFormula>();
		formulas.add(modalFormula);
	}

	public ConjunctionFormula() {
		formulas = new ArrayList<ModalFormula>();
	}
	
	public boolean canDo(ModalFormula formula) {
		for (ModalFormula m : formulas) {
			if (m.canDo(formula)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean canDo(ConjunctionFormula f) {
		return f.isDoneBy(this);
	}
	
	private boolean isDoneBy(ConjunctionFormula conjunctionFormula) {
		for (ModalFormula m : formulas) {
			if (!conjunctionFormula.canDo(m)) {
				return false;
			}
		}
		return true;
	}

	public boolean canDo(DisjunctionFormula formula) {
		return formula.isDoneBy(this);
	}

	public boolean isDoneBy(ModalFormula modalFormula) {
		for (ModalFormula m : formulas) {
			if (!modalFormula.canDo(m)) {
				return false;
			}
		}
		return true;
	}
}
