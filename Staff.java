package RefDefCwk;

public class Staff {
    private String name;
    private int experience;
    private int retainer;
    private boolean ciscoPrograms;
    private int hourlyRate;
    private boolean isHired;

    private Staff(String name, int experience, int retainer, boolean ciscoPrograms, int hourlyRa){
        this.name = name;
        this.experience = experience;
        this.retainer = retainer;
        this.ciscoPrograms = ciscoPrograms;
        this.hourlyRate = hourlyRa;
        this.isHired = false;
    }
    // Getter method for name
    public String getName() {
        return name;
    }

    // Other getter and setter methods as needed
    public int getExperience() {
        return experience;
    }

    public double getRetainer() {
        return retainer;
    }

    public boolean isCiscoCertified() {
        return ciscoCertified;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", retainer=" + retainer +
                ", ciscoPrograms=" + ciscoPrograms +
                ", hourlyRate=" + hourlyRate +
                ", isHired=" + isHired +
                '}';
    }


}
