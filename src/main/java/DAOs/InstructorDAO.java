package DAOs;

import models.Instructor;
import utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAO implements InstructorDAOInterface{
    @Override
    public List<Instructor> getAllInstructor() {
        try(Connection conn= ConnectionUtils.getConnection()){
          String sql="SELECT * FROM Instructor";
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            ArrayList<Instructor> instructors=new ArrayList<>();
            while(rs.next()) {
                Instructor ins = new Instructor(
                        rs.getInt("instuctor_id"),
                        rs.getString("instructor_name"),
                        rs.getString("expertise"),
                        rs.getString("email")

                );
                instructors.add(ins);
            }
            return instructors;
        }catch(SQLException e){
            e.printStackTrace();
        }

       return null;
    }




    @Override
    public Instructor getInstructorById(int id) {
        try(Connection conn= ConnectionUtils.getConnection()) {
            String sql = "select * from instructor where instuctor_id= ?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Instructor ins = new Instructor(
                        rs.getInt("instuctor_id"),
                        rs.getString("instructor_name"),
                        rs.getString("expertise"),
                        rs.getString("email")

                );
                return ins;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Instructor insertInstructor(Instructor ins) {
        try(Connection conn=ConnectionUtils.getConnection()){
            String sql="insert into instructor(instructor_name,expertise,email) values (?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,ins.getInstructor_name());
            ps.setString(2, ins.getExpertise());
            ps.setString(3,ins.getInstructor_email());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ins;
    }

    @Override
    public String updateInstructorEmail(String email) {
        return "";
    }
}
