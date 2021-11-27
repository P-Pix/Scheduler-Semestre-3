package constraints;

import java.util.HashMap;
import java.util.HashSet;

public class Demo {

    public static void main(String[]args){
		
		System.out.println("Bonjour");
		Activity a = new Activity("Attacher vélo",2);
		Activity b = new Activity("Aller à la fac",15);
		Activity c = new Activity("Se reposer",10);		
		System.out.println(a.getDescription());

		HashSet<Activity> ensembleAct = new HashSet<>();
		ensembleAct.add(a);
		ensembleAct.add(b);
		ensembleAct.add(c);

		HashMap<Activity,Integer> calendrier = new HashMap<>();
		calendrier.put(a, 15);
		calendrier.put(b,82);
		calendrier.put(c,72);
		
		
		PrecedenceConstraint PC = new PrecedenceConstraint(b,a);
		System.out.println("On peut aller à la fac au temps 2 et attacher le vélo à 18 " + PC.isSatisfied(2,18));
		System.out.println("\nOn peut aller à la fac au temps 82 et attacher le vélo à 15  " + PC.isSatisfied(calendrier));

		MeetConstraint MC = new MeetConstraint(a,b);
		MeetConstraint MCBis = new MeetConstraint(c,b);
		System.out.println("\nOn peut commencer à aller à la fac dès qu'on termine de se reposer à la minute 82" + MCBis.isSatisfied(calendrier));
		System.out.println("\nOn peut commencer à attacher le vélo à la minute 15 et qu'on a fini d'aller à la fac ?" + MC.isSatisfied(calendrier));
		
		/*Démonstration pour les contraintes avec gap  */

		Activity TP = new Activity("TP",15);
		Activity CM = new Activity("CM",60);
		PrecedenceConstraintWithGap contrainteTestWithGap = new PrecedenceConstraintWithGap(CM,TP,15,300);
		System.out.println(" Test de la contrainte avec un gap : " + contrainteTestWithGap.isSatisfied(30,50));
		MaxSpanConstraint MSP = new MaxSpanConstraint(ensembleAct,50);

        System.out.println(MSP.isSatisfied(calendrier));
		
	
		
		
		
	}
    
}
