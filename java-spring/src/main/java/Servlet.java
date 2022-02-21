import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// A class passa a ser um servlet por causa do extends HttpServlet
@WebServlet(urlPatterns = "/teste") // Onde a url vai bater
public class Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>" +
                        "<body>\n" +
                        "\n" +
                            "<h1> Hello World!!</h1>\n" +
                        "\n" +
                        "</body> " +
                    "</html>");
    }

}
