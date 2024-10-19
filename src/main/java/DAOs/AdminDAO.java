package DAOs;

import models.Admin;
import utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO implements AdminDAOInterface{
    @Override
    public Admin login(String username, String password) {
            try(Connection conn = ConnectionUtils.getConnection()){
                String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, username);
                ps.setString(2, password);
                System.out.println(username);
                System.out.println(password);
                ResultSet rs = ps.executeQuery();

                //Instantiate a RoleDAO to use the getRoleById method


                if(rs.next()) {

                    return new Admin(
                            rs.getString("username"),
                            rs.getString("password")

                    );

                }
            } catch (SQLException e){
                e.printStackTrace();
                System.out.println("Couldn't login user");
            }


        return null;
        }
}
