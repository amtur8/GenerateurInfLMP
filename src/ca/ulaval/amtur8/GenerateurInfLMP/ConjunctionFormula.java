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
		Iterator<ModalFormula> iteratorOverConclusion = f.getIterator();
		while (iteratorOverConclusion.hasNext()) {
			if (!this.canDo(iteratorOverConclusion.next())) {
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

	public boolean isDoneBy(ModalFormula modalFormula) {
		Iterator<ModalFormula> iteratorOverConclusion = this.getIterator();
		while  (iteratorOverConclusion.hasNext()) {
			if (!modalFormula.canDo(iteratorOverConclusion.next())) {
				return false;
			}
		}
		return true;
	}
}
