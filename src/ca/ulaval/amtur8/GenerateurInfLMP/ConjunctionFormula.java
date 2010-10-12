package ca.ulaval.amtur8.GenerateurInfLMP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



public class ConjunctionFormula implements Formula {

	private Collection<ModalFormula> formulas;
	
	public ConjunctionFormula(ModalFormula modalFormula) {
		formulas = new ArrayList<ModalFormula>();
		formulas.add(modalFormula);
	}

	public ConjunctionFormula() {
		formulas = new ArrayList<ModalFormula>();
	}

	@Override
	public boolean canDo(Formula f) {
		return false;
	}
	
	public boolean canDo(ModalFormula formula) {
		Iterator<ModalFormula> iteratorOverPredicate;
		iteratorOverPredicate = this.getIterator();
		while (iteratorOverPredicate.hasNext()) {
			if (iteratorOverPredicate.next().canDo(formula)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean canDo(ConjunctionFormula f) {
		ModalFormula temporaryFormula;
		Iterator<ModalFormula> iteratorOverConclusion = f.getIterator();
		while (iteratorOverConclusion.hasNext()) {
			temporaryFormula = iteratorOverConclusion.next();
			if (!this.canDo(temporaryFormula)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean canDo(DisjunctionFormula formula) {
		return formula.isDoneBy(this);
	}

	private Iterator<ModalFormula> getIterator() {
		return formulas.iterator();
	}
}
