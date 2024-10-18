package DAOs;

import models.Participant;

import java.util.List;

public interface ParticipantDAOInterface {

    List<Participant> getAllParticipants();
    Participant getParticipantById(int id);
    Participant updateParticipant(int participant_id,String email);
    Participant insertParticipant(Participant participant);
    boolean deleteParticipant(int participant_id);
}
