package amtur8.GenerateurInfLMP;

import java.util.Collection;

public class DisjunctionFormula implements Formula {
	
	private Collection<ConjunctionFormula> formulas;

	public DisjunctionFormula(ConjunctionFormula newCFormula) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasAction(Label action) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canDo(Formula f) {
		// TODO Auto-generated method stub
		return false;
	}

}
