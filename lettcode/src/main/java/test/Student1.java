package test;

public class Student1 {

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    private String nameId;

    public int getAgeId() {
        return ageId;
    }

    public void setAgeId(int ageId) {
        this.ageId = ageId;
    }

    private int ageId;
    // public Student(){}


    @Override
    public String toString() {
        return "Student1{" +
                "nameId='" + nameId + '\'' +
                ", ageId=" + ageId +
                '}';
    }
}
