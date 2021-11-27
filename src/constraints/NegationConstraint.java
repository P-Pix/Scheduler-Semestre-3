package constraints;

import java.util.Map;
import java.util.Set;

public class NegationConstraint implements Constraint {
    private final Constraint m_negationConstraint;

    public NegationConstraint(Constraint constraint) {
        this.m_negationConstraint = constraint;
    }

    @Override
    public Set<Activity> getActivities() {
        return this.m_negationConstraint.getActivities();
    }

    @Override
    public boolean isSatisfied(Map<Activity, Integer> map) {
        return !this.m_negationConstraint.isSatisfied(map);
    }
}