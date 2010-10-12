package ca.ulaval.amtur8.GenerateurInfLMP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DisjunctionFormula implements Formula {
	
	private Collection<ConjunctionFormula> formulas;

	public DisjunctionFormula(ConjunctionFormula newCFormula) {
		formulas = new ArrayList<ConjunctionFormula>();
		formulas.add(newCFormula);
	}
	
	public DisjunctionFormula() {
		formulas = new ArrayList<ConjunctionFormula>();
	}

	public boolean canDo(ModalFormula f) {
		Iterator<ConjunctionFormula> iteratorOverPredicate = this.getIterator();
		while (iteratorOverPredicate.hasNext()) {
			if (!iteratorOverPredicate.next().canDo(f)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean canDo(ConjunctionFormula f) {
		Iterator<ConjunctionFormula> iteratorOverPredicate = this.getIterator();
		while (iteratorOverPredicate.hasNext()) {
			if (!iteratorOverPredicate.next().canDo(f)) {
				return false;
			}
		}
		return true;
	}

	public boolean canDo(DisjunctionFormula f) {
		Iterator<ConjunctionFormula> iteratorOverPredicate = this.getIterator();
		while (iteratorOverPredicate.hasNext()) {
			if (!iteratorOverPredicate.next().canDo(f)) {
				return false;
			}
		}
		return true;
	}

	private Iterator<ConjunctionFormula> getIterator() {
		return this.formulas.iterator();
	}

	public boolean isDoneBy(ConjunctionFormula conjunctionFormula) {
		Iterator<ConjunctionFormula> iteratorOverConclusion = this.getIterator();
		while (iteratorOverConclusion.hasNext()) {
			if (conjunctionFormula.canDo(iteratorOverConclusion.next())) {
				return true;
			}
		}
		return false;
	}

	public boolean isDoneBy(ModalFormula modalFormula) {
		Iterator<ConjunctionFormula> iteratorOverConclusion = this.getIterator();
		while (iteratorOverConclusion.hasNext()) {
			if (modalFormula.canDo(iteratorOverConclusion.next())) {
				return true;
			}
		}
		return false;
	}
}
