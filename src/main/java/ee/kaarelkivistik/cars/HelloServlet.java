package ee.kaarelkivistik.cars;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by kaarel on 23.03.16.
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            new CarDAO().update(new Car(1, "u wot", "u wot", 1337, "u wot m8"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.getWriter().append("good good, even better yeah top kek!");

    }
}
