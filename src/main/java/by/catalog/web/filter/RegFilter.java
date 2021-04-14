package by.catalog.web.filter;

import by.catalog.service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "RegServlet")

public class RegFilter extends HttpFilter {
    UserService userService = new UserService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String phone = req.getParameter("password");
        if (req.getMethod().equals("GET")) {
            chain.doFilter(req, res);
        }
        if (req.getMethod().equals("POST")) {
            boolean b1 = name.equals("") || lastName.equals("") || login.equals("") || password.equals("") || phone.equals("");
            boolean b2 = userService.checkUserByLogin(login);
            if (b1) {
                String message = "Enter all required data";
                req.setAttribute("messageReg", message);
                getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, res);
            }
            if (b2) {
                String message = "Login exists. Try another login";
                req.setAttribute("messageReg", message);
                getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, res);
            }
            if (!b1 || !b2) {
                chain.doFilter(req, res);
            }
        }
    }
}