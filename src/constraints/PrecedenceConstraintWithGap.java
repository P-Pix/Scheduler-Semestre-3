package constraints;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint{
	
	private final int m_delaiMin;
	private final int m_delaiMax;
	
	public PrecedenceConstraintWithGap (Activity activite1, Activity activite2, int delaiMin, int delaiMax){
		super(activite1,activite2);
		this.m_delaiMax = delaiMax;
		this.m_delaiMin = delaiMin;
	}
	
	@Override
	public boolean isSatisfied(int datedebut,int datedebut2){
		return ((datedebut + super.m_activite1.getDuration() + this.m_delaiMin) <= datedebut2) && (datedebut2 <= datedebut + super.m_activite1.getDuration() + this.m_delaiMax);
	}
}
