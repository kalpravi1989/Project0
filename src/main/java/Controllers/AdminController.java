package Controllers;
import DAOs.AdminDAO;
import io.javalin.http.Handler;
import jakarta.servlet.http.HttpSession;
import models.Admin;


public class AdminController {
    AdminDAO aDAO = new AdminDAO();
    public static HttpSession ses;
    public Handler loginHandler = (ctx -> {
        Admin admin=ctx.bodyAsClass(Admin.class);
        System.out.println(admin.getPassword());
        System.out.println(admin.getUsername());
        Admin loggedAdmin = aDAO.login(admin.getUsername(), admin.getPassword());

        if(loggedAdmin != null){
            ses=ctx.req().getSession();
            ses.setAttribute("username",loggedAdmin.getUsername());
            ses.setAttribute("password",loggedAdmin.getPassword());
            System.out.println("admin "+ses.getAttribute("username"));
            ctx.status(200);
            ctx.result("login successfully");



        } else {
            ses=null;
            ctx.status(401);
            ctx.result("Login failed! Try again.");
        }

    });
}
