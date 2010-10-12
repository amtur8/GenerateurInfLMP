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
		Iterator<ConjunctionFormula> it1 = formulas.iterator();
		Iterator<ConjunctionFormula> it2;
		ConjunctionFormula fTemp;
		boolean ok = false;
		while (it1.hasNext()) {
			fTemp = it1.next();
			it2 = f.getIterator();
			while (it2.hasNext() && !ok) {
				if (fTemp.canDo(it2.next())){
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
	
	@Override
	public boolean canDo(Formula f) {
		// TODO Auto-generated method stub
		return false;
	}

	private Iterator<ConjunctionFormula> getIterator() {
		return this.formulas.iterator();
	}
}
