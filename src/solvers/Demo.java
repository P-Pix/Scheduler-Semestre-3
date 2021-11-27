package solvers;

import java.util.HashSet;
import constraints.*;

public class Demo{
	
	public static void main(String[] args)
	{
		/*Demonstration pour le tri */
		HashSet<PrecedenceConstraint> contrainte = new HashSet<>();
		HashSet<Activity> activite = new HashSet<>();
	
		HashSet<PrecedenceConstraint> contrainteExamen = new HashSet<>();
		HashSet<Activity> activiteExamen = new HashSet<>();

		Activity seLever = new Activity("Se lever",1);
		Activity travail = new Activity("Aller au travail",15);
		Activity douche = new Activity("Prendre douche",10);
		Activity dents = new Activity("Se brosser les dents",3);
		Activity habiller = new Activity("S'habiller",2);
		Activity dejeuner = new Activity("Petit dejeuner",15);

		Activity examen = new Activity("Passer examen",15);
		Activity reviser = new Activity("Reviser le sujet",15);
		Activity connaissance = new Activity("prendre connaissance du sujet", 15);

		PrecedenceConstraint d = new PrecedenceConstraint(seLever,dejeuner);
		PrecedenceConstraint e = new PrecedenceConstraint(seLever,habiller);
		PrecedenceConstraint f = new PrecedenceConstraint(dejeuner,dents);
		PrecedenceConstraint g = new PrecedenceConstraint(douche,habiller);
		PrecedenceConstraint h = new PrecedenceConstraint(dents,travail);
		PrecedenceConstraint i = new PrecedenceConstraint(habiller,travail);
		PrecedenceConstraint j = new PrecedenceConstraint(dejeuner,travail);

		PrecedenceConstraint k = new PrecedenceConstraint(reviser,examen);	
		PrecedenceConstraint l = new PrecedenceConstraint(examen,connaissance);
		PrecedenceConstraint m = new PrecedenceConstraint(connaissance,reviser);	

		contrainte.add(d);
		contrainte.add(e);
		contrainte.add(f);
		contrainte.add(g);
		contrainte.add(h);
		contrainte.add(i);
		contrainte.add(j);
		
		activite.add(seLever);
		activite.add(travail);
		activite.add(douche);
		activite.add(dents);
		activite.add(habiller);
		activite.add(dejeuner);

		activiteExamen.add(examen);
		activiteExamen.add(reviser);
		activiteExamen.add(connaissance);

		contrainteExamen.add(k);
		contrainteExamen.add(l);
		contrainteExamen.add(m);
		
		TopologicalSorter Test = new TopologicalSorter();
		System.out.println( "Ordre d'actions si possibles : " + Test.bruteForceSort(activiteExamen,contrainteExamen));
		
		System.out.println( "Ordre d'actions si possibles : " + Test.bruteForceSort(activite,contrainte));
	}
}
