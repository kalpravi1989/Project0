package DAOs;

import models.Admin;

public interface AdminDAOInterface {
    Admin login(String username,String password);
}
