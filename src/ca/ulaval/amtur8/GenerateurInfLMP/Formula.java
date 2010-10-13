package ca.ulaval.amtur8.GenerateurInfLMP;

public interface Formula {
	
	boolean canDo(Formula formule);

	boolean canDo(ModalFormula formule);

	boolean canDo(ConjunctionFormula formule);

	boolean canDo(DisjunctionFormula formule);
	
	boolean isDoneBy(Formula formule);

	Formula and(Formula f2);

	Formula or(Formula f2);
}
