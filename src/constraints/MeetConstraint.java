package constraints;

public class MeetConstraint extends PrecedenceConstraint{
    

    public MeetConstraint(Activity activite1, Activity activite2){
        super(activite1,activite2);
    }

    @Override
    public boolean isSatisfied(int datedebut, int datedebut2){
        return datedebut + this.m_activite1.getDuration() == datedebut2;
    }

}
