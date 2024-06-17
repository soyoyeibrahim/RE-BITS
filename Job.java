package RefDefCwk;

public class Job {
    private int jobNo;
    private String type;
    private int experienceRequired;
    private int hours;
    private int penalty;
    private boolean isCompleted;

    public Job(int jobNo, String type, int experienceRequired, int hours, int penalty) {
        this.jobNo = jobNo;
        this.type = type;
        this.experienceRequired = experienceRequired;
        this.hours = hours;
        this.penalty = penalty;
        this.isCompleted = false;
    }
    public int getJobNo(){
        return jobNo;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobNo=" + jobNo +
                ", type='" + type + '\'' +
                ", experienceRequired=" + experienceRequired +
                ", hours=" + hours +
                ", penalty=" + penalty +
                ", isCompleted=" + isCompleted +
                '}';
    }


}
