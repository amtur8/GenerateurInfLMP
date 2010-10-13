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

	public DisjunctionFormula(Collection<ConjunctionFormula> aInclure) {
		formulas = aInclure;
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

	public Collection<? extends ConjunctionFormula> getFormulas() {
		return formulas;
	}

	@Override
	public Formula and(Formula f2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Formula and(DisjunctionFormula f2) {
		Formula endFormula = new DisjunctionFormula();
		for (ConjunctionFormula cf : this.formulas) {
			endFormula = endFormula.or(f2.and(cf));
		}
		return endFormula;
	}
	
	public Formula and(ConjunctionFormula f2) {
		for (ConjunctionFormula cf : this.formulas) {
			cf.and(f2);
		}
		return this;
	}

	@Override
	public Formula or(Formula f2) {
		return f2.or(this);
	}
	
	public Formula or(DisjunctionFormula f2) {
		this.formulas.addAll(f2.getFormulas());
		return this;
	}

	@Override
	public boolean canDo(Formula formule) {
		return formule.isDoneBy(this);
	}

	@Override
	public boolean isDoneBy(Formula formule) {
		return formule.canDo(this);
	}	
}
