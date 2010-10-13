package ca.ulaval.amtur8.GenerateurInfLMP;

import java.util.ArrayList;
import java.util.Collection;

public class DisjunctionFormula implements Formula {
	
	private Collection<ConjunctionFormula> formulas;
	public static final DisjunctionFormula DTOP = new DisjunctionFormula(ConjunctionFormula.TOP);
	public static final DisjunctionFormula BOTTOM = new DisjunctionFormula();

	public DisjunctionFormula(ConjunctionFormula newCFormula) {
		formulas = new ArrayList<ConjunctionFormula>();
		formulas.add(newCFormula);
	}
	
	public DisjunctionFormula() {
		formulas = new ArrayList<ConjunctionFormula>();
	}

	public boolean canDo(ModalFormula modalFormula) {
		for (ConjunctionFormula c : formulas) {
			if (!c.canDo(modalFormula)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean canDo(ConjunctionFormula conjunctionFormula) {
		for (ConjunctionFormula c : formulas) {
			if (!c.canDo(conjunctionFormula)) {
				return false;
			}
		}
		return true;
	}

	public boolean canDo(DisjunctionFormula disjunctionFormula) {
		for (ConjunctionFormula c : formulas) {
			if (!c.canDo(disjunctionFormula)) {
				return false;
			}
		}
		return true;
	}

	public boolean isDoneBy(ConjunctionFormula conjunctionFormula) {
		for (ConjunctionFormula c : formulas) {
			if (conjunctionFormula.canDo(c)) {
				return true;
			}
		}
		return false;
	}

	public boolean isDoneBy(ModalFormula modalFormula) {
		for (ConjunctionFormula c : formulas) {
			if (modalFormula.canDo(c)) {
				return true;
			}
		}
		return false;
	}
}
