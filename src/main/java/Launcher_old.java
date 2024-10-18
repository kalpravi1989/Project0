import DAOs.InstructorDAO;
import DAOs.ParticipantDAO;
import models.Instructor;
import models.Participant;
import utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Launcher_old {

    public static void main(String[] args) {

        try(Connection conn= ConnectionUtils.getConnection()){
            System.out.println("Connected Successfully");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Connection Failed");
        }

        InstructorDAO insDAO=new InstructorDAO();
        Instructor ins=new Instructor("Ramesh Babu","Angular","ramesh@email.com");
        ParticipantDAO pr=new ParticipantDAO();

        insDAO.insertInstructor(ins);
        List<Instructor> instructors=insDAO.getAllInstructor();
        for(Instructor ins1:instructors){
            System.out.println(ins1);
        }

        List<Participant>participantList=pr.getAllParticipants();
        for(Participant pt1:participantList){
            System.out.println(pt1);
        }
    }
}
