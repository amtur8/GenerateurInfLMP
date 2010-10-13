package ca.ulaval.amtur8.GenerateurInfLMP;

import java.util.ArrayList;
import java.util.Collection;

public class ConjunctionFormula implements Formula {

	private Collection<ModalFormula> formulas;
	//private static final Collection<ModalFormula> EmptyFormulas = new ArrayList<ModalFormula>();
	public static final ConjunctionFormula TOP = new ConjunctionFormula(); 
	
	public ConjunctionFormula(ModalFormula modalFormula) {
		this.formulas = new ArrayList<ModalFormula>();
		this.formulas.add(modalFormula);
	}

	public ConjunctionFormula() {
		this.formulas = new ArrayList<ModalFormula>();
	}
	
	public ConjunctionFormula(Collection<ModalFormula> aInclure) {
		this.formulas = aInclure;
	}

	public boolean canDo(ModalFormula formula) {
		for (ModalFormula m : this.formulas) {
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
		for (ModalFormula m : this.formulas) {
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
		for (ModalFormula m : this.formulas) {
			if (!modalFormula.canDo(m)) {
				return false;
			}
		}
		return true;
	}

	public Collection<? extends ModalFormula> getFormulas() {
		return formulas;
	}
}
