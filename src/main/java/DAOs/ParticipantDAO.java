package DAOs;

import models.Instructor;
import models.Participant;
import utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO implements ParticipantDAOInterface {
    @Override
    public List<Participant> getAllParticipants() {
        try (Connection conn = ConnectionUtils.getConnection()) {
            List<Participant> participantList = new ArrayList<Participant>();
            String sql = "SELECT * FROM Participants";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) { //ParticipantName, Email, EnrollmentDate
                Participant pt = new Participant(rs.getInt("participantid"),
                        rs.getString("participantname"),
                        rs.getString("email"),
                        rs.getDate("enrollmentdate"),
                        rs.getInt("instructor_id"));
                participantList.add(pt);
            }
            return participantList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Participant getParticipantById(int id) {
        try (Connection conn = ConnectionUtils.getConnection()) {
            String sql = "SELECT * from PARTICIPANTS WHERE participantid= ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Participant participant = new Participant(
                        rs.getInt("participantid"),
                        rs.getString("participantname"),
                        rs.getString("email"),
                        rs.getDate("enrollmentdate"),
                        rs.getInt("instructor_id"));
                return participant;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Participant updateParticipant(int participant_id, String email) {
        try(Connection conn=ConnectionUtils.getConnection()){
            String sql="update  participants set email= ? where participantid= ?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,email);
            ps.setInt(2,participant_id);
            ps.executeUpdate();
            Participant pr= getParticipantById(participant_id);
            return pr;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Participant insertParticipant(Participant participant) {
        return null;
    }


    @Override
    public boolean deleteParticipant(int participant_id) {
        int affectedRows=0;
        try (Connection conn = ConnectionUtils.getConnection()) {
            String sql = "DELETE FROM participants WHERE participantid= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, participant_id);
            affectedRows=ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows>0;

    }
}
