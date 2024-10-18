package Controllers;

import DAOs.InstructorDAO;
import io.javalin.http.Handler;
import models.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorContoller {
    InstructorDAO iDAO = new InstructorDAO();
    public Handler getAllInstrctors=(ctx->{

        List<Instructor> instructors=iDAO.getAllInstructor();
        ctx.json(instructors);
        ctx.status(200);
    });

    public Handler insertInstrctors=(ctx->{
        Instructor newInstructor=ctx.bodyAsClass(Instructor.class);
        if(newInstructor.getInstructor_name()==null||newInstructor.getInstructor_name().isBlank()){
            ctx.result("Name is required");
            ctx.status(400);
        }
        if(newInstructor.getInstructor_email()==null||newInstructor.getInstructor_name().isBlank()){
            ctx.result("emailId is required");
            ctx.status(400);
        }
        if(newInstructor.getExpertise()==null||newInstructor.getInstructor_name().isBlank()){
            ctx.result("Expertise is required");
            ctx.status(400);
        }
        else {

            Instructor insertedIns = iDAO.insertInstructor(newInstructor);
            ctx.status(201);
            ctx.json(insertedIns);
        }

    });
    public Handler getInstructorsById=(ctx->{

        int ins_id=Integer.parseInt(ctx.pathParam("id"));
        System.out.println(ins_id);
        Instructor ins=iDAO.getInstructorById(ins_id);
        System.out.println(ins);
        ctx.json(ins);
        ctx.status(200);
    });
    public Handler updateEmail=ctx->{
        int role_id=Integer.parseInt(ctx.pathParam("Id"));
        String email=ctx.body();

     String newemail=   iDAO.updateInstructorEmail(email);

    };
}
