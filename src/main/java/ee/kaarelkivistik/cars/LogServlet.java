package ee.kaarelkivistik.cars;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LogServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter out = response.getWriter();

        try (Stream<String> stream = Files.lines(Paths.get("log.txt"))) {
            stream.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
