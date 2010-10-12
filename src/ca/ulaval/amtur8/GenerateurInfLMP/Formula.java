package ca.ulaval.amtur8.GenerateurInfLMP;

public interface Formula {

	boolean canDo(ModalFormula formule);

	boolean canDo(ConjunctionFormula f);

	boolean canDo(DisjunctionFormula f);
}
