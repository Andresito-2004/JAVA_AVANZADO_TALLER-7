package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.User;
import model.repository.Repository;
import model.repository.UseRepositoryImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registerUser", value = "/registerUser")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  Paso 1 collect all from data recibe la informacion
        String user_firstName = request.getParameter("user_firstName");
        String user_lastname = request.getParameter("user_lastname");
        String user_lastEmail = request.getParameter("user_lastEmail");
        String user_lastPassword = request.getParameter("user_lastPassword");

        // paso 2  fill it up in a User bean trae los set que son los que modifican
        User user = new User();
        user.setUser_firstname(user_firstName);
        user.setUser_lastname(user_lastname);
        user.setUser_email(user_lastEmail);
        user.setUser_password(user_lastPassword);

        // paso 3 call repository layer anda save the user object to db ejecuta la insert para la bd
        Repository<User> repository =  new UseRepositoryImpl();
        int rows = 0;
        try {
            repository.saveObj(user);
        } catch (SQLException e) {
            e.printStackTrace();// muestra la pila de errores
        }
        // paso 4 prepare an information message for user about success or failure of the operation, muestra si fue exitoso o no
        if (rows==0){
            System.out.println("Ocurrio un error");
        }
        else {
            System.out.println("Registro exitoso");
        }
        // todo paso 5 write the message back to the page in client browser



    }
}
