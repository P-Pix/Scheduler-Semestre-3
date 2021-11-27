package solvers;

import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import constraints.*;

public class Verifier {

    private Set<Constraint> m_ensembleContrainte;

    public Verifier(Set<Constraint> ensembleContrainte) {
        this.m_ensembleContrainte = ensembleContrainte;
    }

    public Set<Constraint> unsatisfied(Map<Activity, Integer> calendrier) {
        HashSet<Constraint> ensembleUnsatisfied = new HashSet<>();
        for (Constraint con : this.m_ensembleContrainte) {
            if (!con.isSatisfied(calendrier)) {
                ensembleUnsatisfied.add(con);
            }
        }
        return ensembleUnsatisfied;
    }
}