package solvers;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import constraints.*;

public class DemoCalendrierHasard{

    public static void main(String[] args){
        
        Random alea = new Random();
        Map<Activity,Integer> calendrier;
        HashSet<Activity> activites = new HashSet<>();
        HashSet<Constraint> contraintes = new HashSet<>();
        Activity a = new Activity("se lever",1);
		Activity b = new Activity("aller au travail",15);
		Activity c = new Activity("prendre une douche",10);
		Activity d = new Activity("se brosser les dents",3);
		Activity e = new Activity("s'habiller",2);
		Activity f = new Activity("petit dej",15);

        activites.add(a);
        activites.add(b);
        activites.add(c);
        activites.add(d);
        activites.add(e);
        activites.add(f);

        MaxSpanConstraint MSP = new MaxSpanConstraint(activites,100);
        MeetConstraint MC = new MeetConstraint(a,b);
		MeetConstraint MCBis = new MeetConstraint(c,b);
        PrecedenceConstraint PC = new PrecedenceConstraint(a,b);
        PrecedenceConstraint PC1 = new PrecedenceConstraint(c,b);
        PrecedenceConstraintWithGap PC2 = new PrecedenceConstraintWithGap(f,d,15,30);
        PrecedenceConstraint PC3 = new PrecedenceConstraint(a,b);
        
        contraintes.add(MSP);
        contraintes.add(MC);
        contraintes.add(MCBis);
        contraintes.add(PC);
        contraintes.add(PC1);
        contraintes.add(PC2);
        contraintes.add(PC3);

        RandomScheduler testHasard = new RandomScheduler(alea);
        
        calendrier = testHasard.generateSchedule(activites,contraintes,300,500,3);
        System.out.println(calendrier);

    }
}