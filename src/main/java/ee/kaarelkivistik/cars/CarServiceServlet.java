package ee.kaarelkivistik.cars;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by kaarel on 23.03.16.
 */
@WebServlet(name = "CarServiceServlet")
public class CarServiceServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    private CarDAO carDAO;

    public CarServiceServlet() throws SQLException {
        carDAO = new CarDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawId = request.getParameter("id");

        int id = Integer.parseInt(rawId);

        try {
            response.getWriter().print(objectMapper.writeValueAsString(carDAO.findOneById(id)));
        } catch (SQLException e) {
            response.sendError(404);
        }
    }
}
