package models;

import java.util.Date;

public class Participant {
    private int participant_id;
    private String participant_name;
    private String participant_email;
    private Date enrollment_date;
    private int instructor_id;

    public Participant() {
    }

    public Participant(int participant_id,String participant_name, String participant_email, Date enrollment_date,int instructor_id) {
       this.participant_id=participant_id;
        this.participant_name = participant_name;
        this.participant_email = participant_email;
        this.enrollment_date = enrollment_date;
        this.instructor_id=instructor_id;
    }
    public Participant(String participant_name, String participant_email, Date enrollment_date,int instructor_id) {
        this.participant_name = participant_name;
        this.participant_email = participant_email;
        this.enrollment_date = enrollment_date;
        this.instructor_id=instructor_id;
    }


    public int getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(int participant_id) {
        this.participant_id = participant_id;
    }

    public String getParticipant_name() {
        return participant_name;
    }

    public void setParticipant_name(String participant_name) {
        this.participant_name = participant_name;
    }

    public String getParticipant_email() {
        return participant_email;
    }

    public void setParticipant_email(String participant_email) {
        this.participant_email = participant_email;
    }

    public Date getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(Date enrollment_date) {
        this.enrollment_date = enrollment_date;
    }
    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id= instructor_id;
    }
    @Override
    public String toString() {
        return "Participant{" +
                "participant_id=" + participant_id +
                ", participant_name='" + participant_name + '\'' +
                ", participant_email='" + participant_email + '\'' +
                ", enrollment_date=" + enrollment_date +
                "instructor_id="+instructor_id +
        '}';
    }
}
