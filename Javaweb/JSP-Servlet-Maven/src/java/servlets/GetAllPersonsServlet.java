package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MongoDBPersonDAO;
import model.Person;
import com.mongodb.MongoClient;

@WebServlet("/")
public class GetAllPersonsServlet extends HttpServlet {

  private static final long serialVersionUID = -7060758261496829915L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
    MongoDBPersonDAO personDAO = new MongoDBPersonDAO(mongo);
    List<Person> persons = personDAO.readAllPerson();
    request.setAttribute("persons", persons);
    RequestDispatcher rd = getServletContext().getRequestDispatcher("/persons.jsp");
    rd.forward(request, response);
  }

}