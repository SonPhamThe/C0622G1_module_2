package additional_exercise.bai1;

public class Candidate {
    private int studentCode = 0;
    private String name = "";
    private String birthday;
    private double mathScore = 0;
    private double literatureScore = 0;
    private double englishScore = 0;

    Candidate() {
    }

    Candidate(String name, double mathScore, double literatureScore, double englishScore) {
        this.name = name;
        if (mathScore < 0 || mathScore > 10 || literatureScore < 0 || literatureScore > 10 || englishScore < 0 || englishScore > 10) {
            System.out.println("Invalid input value, Score must be >= 0 and <=10");
        }
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.literatureScore = literatureScore;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        if (mathScore < 0 || mathScore > 10) {
            System.out.println("Invalid input value, Score mus be >=10 and <=10");
        }
        this.mathScore = mathScore;
    }

    public double getLiteratureScore() {
        return literatureScore;
    }

    public void setLiteratureScore(double literatureScore) {
        if (literatureScore < 0 || literatureScore > 10) {
            System.out.println("Invalid input value, Score mus be >=10 and <=10");
        }
        this.literatureScore = literatureScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        if (englishScore < 0 || englishScore > 10) {
            System.out.println("Invalid input value, Score mus be >=10 and <=10");
        }
        this.englishScore = englishScore;
    }

    public String getScore() {
        return "Candidate: " + this.name + "Math: " + this.mathScore + "english: " + englishScore + "literature: " + this.literatureScore;
    }

    public double getTotalScore() {
        return this.englishScore + this.literatureScore + this.mathScore;
    }

    public void setScore(double mathScore, double literatureScore, double englishScore) {
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.literatureScore = literatureScore;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "mathScore=" + mathScore +
                ", literatureScore=" + literatureScore +
                ", englishScore=" + englishScore +
                ",totalScore= " + getTotalScore() +
                '}';
    }
}
