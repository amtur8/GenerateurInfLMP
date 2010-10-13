package ca.ulaval.amtur8.GenerateurInfLMP;

import java.util.ArrayList;
import java.util.Collection;

public class DisjunctionFormulaBuilder implements FormulaBuilder {
	private Collection<ConjunctionFormula> aInclure = new ArrayList<ConjunctionFormula>();
	
	public DisjunctionFormulaBuilder withNewModal(ModalFormula modal) {
		this.aInclure.add(new ConjunctionFormulaBuilder().withNewModal(modal).build());
		return this;
	}
	
	public DisjunctionFormulaBuilder withNewConjunction(ConjunctionFormula conjunction) {
		this.aInclure.add(conjunction);
		return this;
	}
	
	public DisjunctionFormulaBuilder withNewDisjunction(DisjunctionFormula disjunction) {
		this.aInclure.addAll(disjunction.getFormulas());
		return this;
	}
	
	public DisjunctionFormula build() {
		return new DisjunctionFormula(aInclure);
	}
}
