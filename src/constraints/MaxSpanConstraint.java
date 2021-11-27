package constraints;

import java.util.Set;
import java.util.Map;

public class MaxSpanConstraint implements Constraint {

    private final Set<Activity> m_ensembleAct;
    private final int m_dureeMax;

    public MaxSpanConstraint(Set<Activity> ensembleAct, int dureeMax) {
        this.m_dureeMax = dureeMax;
        this.m_ensembleAct = ensembleAct;
    }

    @Override
    public boolean isSatisfied(Map<Activity, Integer> calendrier) {
        if (this.getActivities().isEmpty()) {
            return true;
        }
        int min = 32767;
        int max = 0;
        for (Activity act : this.m_ensembleAct) {
            if (calendrier.containsKey(act)) {
                if (calendrier.get(act) < min) {
                    min = calendrier.get(act);
                }
                if (calendrier.get(act) + act.getDuration() > max) {
                    max = calendrier.get(act) + act.getDuration();
                }
            }
        }
        return max - min <= this.m_dureeMax;
    }

    @Override
    public Set<Activity> getActivities() {
        return this.m_ensembleAct;
    }

}