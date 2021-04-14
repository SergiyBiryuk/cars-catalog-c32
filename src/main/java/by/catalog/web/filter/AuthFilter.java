package by.catalog.web.filter;

import by.catalog.domain.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", servletNames = {"RegServlet", "AuthServlet"})

public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("currentUser");
        if (user == null) {
            chain.doFilter(req, res);
        } else {
            req.setAttribute("message", "No action available");
            getServletContext().getRequestDispatcher("/").forward(req, res);
        }
    }
}