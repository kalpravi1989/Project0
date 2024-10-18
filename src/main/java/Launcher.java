import Controllers.InstructorContoller;
import Controllers.ParticipantContoller;
import io.javalin.Javalin;

public class Launcher {
    public static void main(String[] args) {
        var app= Javalin.create().start(7000);
        app.get("/",ctx->ctx.result("Hello there"));

        InstructorContoller iC=new InstructorContoller();
        ParticipantContoller pC=new ParticipantContoller();
        app.get("/instructors",iC.getAllInstrctors);

        app.post("/instructors", iC.insertInstrctors);
        app.get("/instructors/{id}",iC.getInstructorsById);

        app.get("/participants/{id}",pC.getParticipantById);
        app.delete("/participants/{id}", pC.deleteParticipant);

    }
}
