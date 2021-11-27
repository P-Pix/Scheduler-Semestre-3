package constraints;

import java.util.Map;
import java.util.Set;

public abstract class BinaryConstraint implements Constraint {

    protected Activity m_activite1;
    protected Activity m_activite2;

    public BinaryConstraint(Activity activite1, Activity activite2) {
        this.m_activite1 = activite1;
        this.m_activite2 = activite2;
    }

    @Override
    public Set<Activity> getActivities() {
        return Set.of(this.m_activite1, this.m_activite2);
    }

    public Activity getFirst() {
        return this.m_activite1;
    }

    public Activity getSecond() {
        return this.m_activite2;
    }
    
    public abstract boolean isSatisfied(int datedebut, int datedebut2);

    @Override
    public boolean isSatisfied(Map<Activity,Integer> calendrier) {
		return this.isSatisfied(calendrier.get(this.m_activite1),calendrier.get(this.m_activite2));
    }

}