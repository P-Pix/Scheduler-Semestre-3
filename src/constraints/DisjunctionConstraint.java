package constraints;

import java.util.Map;
import java.util.Set;

public class DisjunctionConstraint implements Constraint {
    private final Constraint m_disjunctionConstraint1;
    private final Constraint m_disjunctionConstraint2;

    public DisjunctionConstraint(Constraint constraint1, Constraint constraint2) {
        this.m_disjunctionConstraint1 = constraint1;
        this.m_disjunctionConstraint2 = constraint2;
    }

    @Override
    public Set<Activity> getActivities() {
        Set<Activity> allConstraint = this.m_disjunctionConstraint1.getActivities();
        allConstraint.addAll(this.m_disjunctionConstraint2.getActivities());
        return allConstraint;
    }

    @Override
    public boolean isSatisfied(Map<Activity, Integer> assignment) {
        return this.m_disjunctionConstraint1.isSatisfied(assignment) || this.m_disjunctionConstraint2.isSatisfied(assignment);
    }
}