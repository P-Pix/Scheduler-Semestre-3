package solvers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import constraints.*;

public class TopologicalSorter {

    public TopologicalSorter() {

    }

    public ArrayList<Activity> bruteForceSort(HashSet<Activity> activite, HashSet<PrecedenceConstraint> constraints) {
        HashSet<Activity> copieAct = new HashSet<Activity>();
        copieAct.addAll(activite);
        boolean continuer;
        boolean ok;
        int utilise;
        utilise = copieAct.size();
        ArrayList<Activity> res = new ArrayList<>();
        while (utilise != 0) {
            continuer = false;
            for (Activity act : copieAct) {
                ok = true;
                for (PrecedenceConstraint constr : constraints) {
                    if (constr.getSecond().equals(act) && (!res.contains(constr.getFirst()))) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    if (!res.contains(act)) {
                        utilise -= 1;
                        res.add(act);
                    }
                    continuer = true;
                }
            }
            if (!continuer) {
                return null;
            }
        }
        for (int j = 0; j < res.size(); j++) {
            System.out.println(res.get(j).toString());
        }
        return res;
    }

    public HashMap<Activity, Integer> schedule(HashSet<Activity> activite, HashSet<PrecedenceConstraint> constraints) {
        ArrayList<Activity> actOrdonne = bruteForceSort(activite, constraints);
        if (actOrdonne == null) {
            return null;
        }
        HashMap<Activity, Integer> res = new HashMap<Activity, Integer>();
        if (actOrdonne.isEmpty()) {
            return res;
        }
        res.put(actOrdonne.get(0), 0);
        if (actOrdonne.size() >= 2) {
            for (int i = 1; i < actOrdonne.size(); i++) {
                res.put(actOrdonne.get(i), actOrdonne.get(i - 1).getDuration() + res.get(actOrdonne.get(i - 1)));
            }
        }
        return res;
    }
    public ArrayList<Activity> linearTimeSort(HashSet<Activity> HashActivity,
                                              HashSet<PrecedenceConstraint> HashPrecedence) {
        HashMap<Activity, Integer> nbPredecessor = new HashMap<>();
        HashMap<Activity, ArrayList<Activity>> successors = new HashMap<>();
        for (Activity a : HashActivity) {
            nbPredecessor.put(a, 0);
            successors.put(a, new ArrayList<>());
        }
        for (PrecedenceConstraint c : HashPrecedence) {
            nbPredecessor.replace(c.getSecond(), nbPredecessor.get(c.getSecond()) + 1);
            ArrayList<Activity> aList = successors.get(c.getFirst());
            aList.add(c.getSecond());
            successors.replace(c.getFirst(), aList);
        }

        ArrayList<Activity> L = new ArrayList<>();
        ArrayList<Activity> res = new ArrayList<>();

        for (Activity a : HashActivity) {
            if (nbPredecessor.get(a) == 0) {
                L.add(a);
            }
        }
        while (!L.isEmpty()) {
            Activity ac = L.get(0);
            res.add(ac);
            L.remove(ac);
            for (Activity a : successors.get(ac)) {
                nbPredecessor.replace(a, nbPredecessor.get(a) - 1);
                if (nbPredecessor.get(a) == 0) {
                    L.add(a);
                }
            }
        }
        if (res.size() == HashActivity.size()) {
            return res;
        }
        return null;
    }
}
