package models;

public class Instructor {
    private int instructor_id;
    private String instructor_name;
    private String expertise;
    private String instructor_email;

    public Instructor() {
    }

    public Instructor(String instructor_name, String expertise, String instructor_email) {
        this.instructor_name = instructor_name;
        this.expertise = expertise;
        this.instructor_email = instructor_email;
    }

    public Instructor(int instructor_id, String instructor_name, String expertise, String instructor_email) {
        this.instructor_id = instructor_id;
        this.instructor_name = instructor_name;
        this.expertise = expertise;
        this.instructor_email = instructor_email;
    }

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getInstructor_email() {
        return instructor_email;
    }

    public void setInstructor_email(String instructor_email) {
        this.instructor_email = instructor_email;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructor_id=" + instructor_id +
                ", instructor_name='" + instructor_name + '\'' +
                ", expertise='" + expertise + '\'' +
                ", instructor_email='" + instructor_email + '\'' +
                '}';
    }
}
