package Controllers;

import DAOs.ParticipantDAO;
import io.javalin.http.Handler;
import jakarta.servlet.http.Part;
import models.Instructor;
import models.Participant;

import java.util.List;


public class ParticipantContoller<List> {
    ParticipantDAO pDAO=new ParticipantDAO();
    public Handler getAllParticipant=ctx->{
        java.util.List<Participant> participants=pDAO.getAllParticipants();
        ctx.json(participants);
        ctx.status(200);
    };
    public Handler getParticipantById=(ctx->{

        int p_id=Integer.parseInt(ctx.pathParam("id"));
        System.out.println(p_id);
        Participant participant=pDAO.getParticipantById(p_id);
        if(p_id<=0){
            ctx.result("ID must be greater than zero!");
            ctx.status(400); //Bad Request
        }
        if(participant==null){
            ctx.result("Role ID: " + p_id + " not found");
            ctx.status(404);
        }else {
            System.out.println(participant);
            ctx.json(participant);
            ctx.status(200);
        }
    });
    public Handler updateParticipant=(ctx->{
        int parti_id=Integer.parseInt(ctx.pathParam("id"));
        String newEmail=ctx.body();
        Participant updatedParti=pDAO.updateParticipant(parti_id,newEmail);
        ctx.status(200);
        ctx.json(updatedParti);

    });

    public Handler deleteParticipant=(ctx->{
        int parti_id=Integer.parseInt(ctx.pathParam("id"));
        System.out.println(parti_id);
        boolean isdeleted= pDAO.deleteParticipant(parti_id);
        System.out.println(isdeleted);
        if(isdeleted){
            ctx.status(204).result("participant with ID "+parti_id+" deleted successfully");
        }else{
            ctx.result("participant with ID "+parti_id+" not found");
            ctx.status(404);
        }

    });
}
