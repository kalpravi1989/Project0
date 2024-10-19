import Controllers.AdminController;
import Controllers.InstructorContoller;
import Controllers.ParticipantContoller;
import io.javalin.Javalin;

public class Launcher {
    public static void main(String[] args) {
        var app= Javalin.create().start(7000);
        app.before("/participants",ctx->{
            if(AdminController.ses==null){
                System.out.println("session is null");
                throw new IllegalArgumentException("you must log in before doing this");
            }
        });
        app.before("/participants/*",ctx->{
            if(AdminController.ses==null){
                System.out.println("session is null");
                throw new IllegalArgumentException("you must log in before doing this");
            }
        });
        app.before("/instructors",ctx->{
            if(AdminController.ses==null){
                System.out.println("session is null");
                throw new IllegalArgumentException("you must log in before doing this");
            }
        });
        app.before("/instructors/*",ctx->{
            if(AdminController.ses==null){
                System.out.println("session is null");
                throw new IllegalArgumentException("you must log in before doing this");
            }
        });
        app.exception(IllegalArgumentException.class,(e,ctx)->{
           ctx.status();
           ctx.result(e.getMessage());
        });
        app.get("/",ctx->ctx.result("Hello there"));

        InstructorContoller iC=new InstructorContoller();
        ParticipantContoller pC=new ParticipantContoller();
        AdminController ac = new AdminController();
        app.get("/instructors",iC.getAllInstrctors);

        app.post("/instructors", iC.insertInstrctors);
        app.get("/instructors/{id}",iC.getInstructorsById);
        
        app.get("/participants/{id}",pC.getParticipantById);
        app.get("/participants",pC.getAllParticipant);
        app.patch("/participants/{id}", pC.updateParticipant);
        app.delete("/participants/{id}", pC.deleteParticipant);

        app.post("/admin",ac.loginHandler);

    }
}
