package constraints;

public class PrecedenceConstraint extends BinaryConstraint{

    public PrecedenceConstraint(Activity activite1, Activity activite2){
        super(activite1,activite2);
    }

    @Override
    public boolean isSatisfied(int firstTime, int secondTime){
        return (firstTime + this.m_activite1.getDuration() <= secondTime);
    }
}
