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
		ConjunctionFormula newCFormula = new ConjunctionFormula(f);
		DisjunctionFormula newDFormula = new DisjunctionFormula(newCFormula);
		return this.canDo(newDFormula);
	}
	
	public boolean canDo(ConjunctionFormula f) {
		DisjunctionFormula newFormula = new DisjunctionFormula(f);
		return this.canDo(newFormula);
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
	
	@Override
	public boolean canDo(Formula f) {
		// TODO Auto-generated method stub
		return false;
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
}
