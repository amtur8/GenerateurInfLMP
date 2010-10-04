package amtur8.GenerateurInfLMP;

import java.util.Collection;
import java.util.Iterator;



public class ConjunctionFormula implements Formula {

	private Collection<ModalFormula> formulas;
	
	@Override
	public boolean hasAction(Label action) {
		Iterator<ModalFormula> it = formulas.iterator();
		while (it.hasNext()) {
			if ((it.next()).hasAction(action)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean models(Formula f) {
		if (f instanceof ModalFormula) {
			Iterator<ModalFormula> it = formulas.iterator();
			while (it.hasNext()) {
				if ((it.next()).models(f)) {
					return true;
				}
			}
		}
		else {
			Iterator<ModalFormula> it1 = formulas.iterator();
			ModalFormula fTemp;
			Iterator<ModalFormula> it2;
			boolean ok = false;
			while (it1.hasNext()) {
				fTemp = it1.next();
				it2 = ((ConjunctionFormula) f).getIterator();
				while (it2.hasNext()) {
					if (fTemp.models(it2.next())) {
						ok = true;
					}
				}
				if (!ok) {
					return false;
				}
				ok = false;
			}
		}
		return false;
	}

	private Iterator<ModalFormula> getIterator() {
		return formulas.iterator();
	}

}
