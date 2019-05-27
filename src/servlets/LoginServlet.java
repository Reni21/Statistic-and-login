package servlets;

import entities.User;
import databases.AccountsDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("isExists", true);
        session.setAttribute("isValidData", true);
        String login = req.getParameter("log");
        String password = req.getParameter("pas");
        if ("".equals(login) || "".equals(password)) {
            req.getRequestDispatcher("index.jsp").include(req, resp);
        }

        AccountsDB accountsDB = AccountsDB.getInstance();
        Map<String, String> userMap = accountsDB.getUsers();
        session.setAttribute("users", userMap);

        String act = req.getParameter("act");
        if (act.equals("Sign in")) {
            if (userMap.containsKey(login)) {
                session.setAttribute("user_login", login);
                req.getRequestDispatcher("views/account.jsp").include(req, resp); // sign in success
            } else {
                session.setAttribute("isExists", false);
                req.getRequestDispatcher("index.jsp").include(req, resp); // incorrect login or password
            }
        } else if (act.equals("Sign up")) {
            if (userMap.containsKey(login)) {
                session.setAttribute("isValidData", false);
                req.getRequestDispatcher("index.jsp").include(req, resp); // user with such login name is already exist
            } else {
                createNewUser(session, accountsDB, login, password);
                req.getRequestDispatcher("views/account.jsp").include(req, resp); // sign up success
            }
        }
    }

    public void createNewUser(HttpSession session, AccountsDB accountsDB, String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        accountsDB.createAccount(login, password);
        session.setAttribute("user_login", login);
        session.setAttribute("user", user);
    }

    @Override // code for log out
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String out = req.getParameter("out");
        HttpSession session = req.getSession(false);

        if ("exit".equals(out) && (session != null)) {
            session.removeAttribute("user_login");
        }

        resp.sendRedirect("index.jsp");
    }
}
