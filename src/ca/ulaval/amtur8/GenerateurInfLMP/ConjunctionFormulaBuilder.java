package ca.ulaval.amtur8.GenerateurInfLMP;

import java.util.ArrayList;
import java.util.Collection;

public class ConjunctionFormulaBuilder implements FormulaBuilder {
	private Collection<ModalFormula> aInclure = new ArrayList<ModalFormula>();
	
	public ConjunctionFormulaBuilder withNewModal(ModalFormula modal) {
		this.aInclure.add(modal);
		return this;
	}
	
	public ConjunctionFormulaBuilder withNewConjunction(ConjunctionFormula conjunction) {
		this.aInclure.addAll(conjunction.getFormulas());
		return this;
	}
	
	public ConjunctionFormula build() {
		return new ConjunctionFormula(aInclure);
	}
}
