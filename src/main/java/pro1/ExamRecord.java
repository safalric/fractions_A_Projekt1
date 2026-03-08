package pro1;

public class ExamRecord {
    private String personId;
    private Fraction score;

    public ExamRecord(String personId, Fraction score) {
        this.personId = personId;
        this.score = score;
    }

    public String getPersonId() {
        return personId;
    }

    public Fraction getScore() {
        return score;
    }
}

