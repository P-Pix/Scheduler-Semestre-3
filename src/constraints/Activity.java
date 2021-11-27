package constraints;

public class Activity {

    private final String m_description;

    private final int m_temps;

    public Activity(String descript, int t) {
        this.m_description = descript;
        this.m_temps = t;
    }

    public String getDescription() {
        return this.m_description;
    }

    @Override
    public String toString() {
        return this.m_description + " : " + this.m_temps;
    }

    public int getDuration() {
        return this.m_temps;
    }

}
