package amtur8.GenerateurInfLMP;

import java.util.Collection;

public class DisjunctionFormula implements Formula {
	
	private Collection<ConjunctionFormula> formulas;

	@Override
	public boolean hasAction(Label action) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean models(Formula f) {
		// TODO Auto-generated method stub
		return false;
	}

}
