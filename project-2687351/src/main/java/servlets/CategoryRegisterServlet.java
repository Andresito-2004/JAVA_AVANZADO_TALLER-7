package servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.beans.Category;
import model.beans.User;
import model.repository.CategoryRepositoryImpl;
import model.repository.Repository;
import model.repository.UseRepositoryImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registerCategory", value = "/registerCategory")
public class CategoryRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  Paso 1 collect all from data recibe la informacion
        String category_name = request.getParameter("category_name");

        // paso 2  fill it up in a User bean trae los set que son los que modifican
        Category category = new Category();
        category.setCategory_name(category_name);

        // paso 3 call repository layer anda save the user object to db ejecuta la insert para la bd
        Repository<Category> repository =  new CategoryRepositoryImpl();
        int rows = 0;
        try {
            repository.saveObj(category);
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
    }


}
