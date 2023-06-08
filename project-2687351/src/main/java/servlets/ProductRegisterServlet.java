package servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.beans.User;
import model.repository.Repository;
import model.repository.UseRepositoryImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registerProduct", value = "/registerProduct")
public class ProductRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  Paso 1 collect all from data recibe la informacion


        // todo paso 5 write the message back to the page in client browser



    }
}


