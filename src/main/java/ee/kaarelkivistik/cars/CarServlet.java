package ee.kaarelkivistik.cars;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by kaarel on 24.03.16.
 */
public class CarServlet extends HttpServlet {

    private CarDAO carDAO;
    private CarLogger carLogger;

    public CarServlet() throws SQLException, IOException {
        carDAO = new CarDAO();
        carLogger = new CarLogger();

        carLogger.log("new CarServlet()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawId = request.getParameter("id");

        carLogger.log("CarServlet.doGet(...) - id=" + rawId);

        if(rawId == null) {
            try {
                ArrayList<Car> cars = carDAO.findAll();

                request.setAttribute("cars", cars);

                request.getRequestDispatcher("/cars.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();

                response.sendError(500);
            }
        } else {
            int id = Integer.parseInt(rawId);

            try {
                Car car = carDAO.findOneById(id);
                request.setAttribute("car", car);

                request.getRequestDispatcher("/car.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();

                response.sendError(500);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String year = request.getParameter("year");
        String review = request.getParameter("review");

        carLogger.log("CarServlet.doPost(...) - id=" + id + " brand=\"" + brand + "\" model=\"" + model + "\" year=\"" + year + "\"");

        CarForm carForm = new CarForm(id, brand, model, year, review);

        Map<String, String> errors = CarValidator.validateCarForm(carForm);
        boolean hasErrors = errors.keySet().size() > 0;

        if(!hasErrors) {
            Car car = new Car(id, brand, model, year, review);

            try {
                carDAO.update(car);
            } catch (SQLException e) {
                e.printStackTrace();

                response.sendError(500);
            }
        }

        request.setAttribute("car", carForm);
        request.setAttribute("errors", errors);
        request.setAttribute("hasErrors", hasErrors);

        request.getRequestDispatcher("/car.jsp").forward(request, response);
    }
}
