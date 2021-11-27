package solvers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Random;

import constraints.*;

public class RandomScheduler {

    private final Random m_alea;

    public RandomScheduler(Random graine) {
        this.m_alea = graine;
    }

    public Map<Activity, Integer> generateOneSchedule(Set<Activity> ensembleAct, int dateMin, int dateMax) {
        Map<Activity, Integer> calendrier = new HashMap<>();
        if (ensembleAct.isEmpty()) {
            return calendrier;
        }
        if (dateMax < dateMin) {
            return calendrier;
        }
        if (dateMax == dateMin) {
            for (Activity act : ensembleAct) {
                calendrier.put(act, dateMin);
            }
            return calendrier;
        }
        int hasard;
        int difference;
        for (Activity act : ensembleAct) {
            difference = dateMax - dateMin;
            hasard = m_alea.nextInt(difference + 1);
            hasard += dateMin;
            calendrier.put(act, hasard);
        }
        return calendrier;
    }

    public Map<Activity, Integer> generateSchedule(Set<Activity> ensembleAct, Set<Constraint> ensembleCon, int dateMin,
            int dateMax, int nombreTirages) {
        Map<Activity, Integer> calendrier = new HashMap<>();
        if (ensembleAct == null || ensembleAct.isEmpty()) {
            return calendrier;
        }
        if (ensembleCon == null || ensembleCon.isEmpty()) {
            return generateOneSchedule(ensembleAct, dateMin, dateMax);
        }
        Verifier verifieur = new Verifier(ensembleCon);
        Map<Activity, Integer> temp = new HashMap<>();
        calendrier = generateOneSchedule(ensembleAct, dateMin, dateMax);
        for (int i = 1; i < nombreTirages; i++) {
            temp = generateOneSchedule(ensembleAct, dateMin, dateMax);
            if (verifieur.unsatisfied(temp).size() < verifieur.unsatisfied(calendrier).size()) {
                calendrier = temp;
            }
        }
        return calendrier;
    }
}