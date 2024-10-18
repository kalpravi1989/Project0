package DAOs;

import models.Instructor;

import java.util.List;

public interface InstructorDAOInterface {

    List<Instructor> getAllInstructor();

    String updateInstructorEmail(String email);
    Instructor getInstructorById(int id);


    Instructor insertInstructor(Instructor ins);

}
