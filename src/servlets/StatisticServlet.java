package servlets;

/**
 * this page user will see after he filled the test / servlet gives control to statistic.jsp
 */

import entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StatisticServlet", urlPatterns = "/statistic")
public class StatisticServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        if (isFilled(request)) {
            for (int i = 0; i < 2; i++) {
                user.addVoice(request.getParameter("q" + (i + 1)));
            }
        }
        request.getRequestDispatcher("views/statistic.jsp").include(request, response);
        /*
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/statistic.jsp");
            requestDispatcher.forward(request, response);
         */


    }

    public boolean isFilled(HttpServletRequest request) {
        for (int i = 0; i < 2; i++) {
            if (request.getParameter("q" + (i + 1)) == null) {
                return false;
            }
        }
        return true;
    }

}











