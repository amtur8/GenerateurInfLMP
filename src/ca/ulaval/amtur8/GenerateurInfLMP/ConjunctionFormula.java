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
	
	public boolean canDo(ModalFormula f) {
		ConjunctionFormula newFormula = new ConjunctionFormula(f);
		return this.canDo(newFormula);
	}
	
	public boolean canDo(ConjunctionFormula f) {
		Iterator<ModalFormula> it1;
		ModalFormula fTemp;
		Iterator<ModalFormula> it2 = f.getIterator();
		boolean ok = false;
		while (it2.hasNext()) {
			fTemp = it2.next();
			it1 = this.getIterator();
			while (it1.hasNext() && !ok) {
				if (it1.next().canDo(fTemp)) {
					ok = true;
				}
			}
			if (!ok) {
				return false;
			}
			ok = false;
		}
		return true;
	}
	
	public boolean canDo(DisjunctionFormula f) {
		DisjunctionFormula newFormula = new DisjunctionFormula(this);
		return newFormula.canDo(f);
	}

	private Iterator<ModalFormula> getIterator() {
		return formulas.iterator();
	}
}
