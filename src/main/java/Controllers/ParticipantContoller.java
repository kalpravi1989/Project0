package Controllers;

import DAOs.ParticipantDAO;
import io.javalin.http.Handler;
import models.Instructor;
import models.Participant;

public class ParticipantContoller {
    ParticipantDAO pDAO=new ParticipantDAO();

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
