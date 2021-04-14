package by.catalog.web.filter;

import by.catalog.domain.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CheckCurrentUserFilter", servletNames = {"AddAdvertServlet",
        "ChangeCurrentAdvertServlet", "EditProfileServlet", "InterestingAdvertServlet",
        "MessageServlet", "PersonalAccountServlet", "RemoveAdvertServlet", "SaveAdvertServlet",
        "YouAdvertsServlet", "DestroyAdvertServlet", "EditAdvertEditColorServlet", "EditAdvertEditDescriptionServlet",
        "EditAdvertEditModelMarkServlet", "EditAdvertEditPriceServlet", "EditAdvertEditYearServlet"})
public class CheckCurrentUserFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser == null){
            getServletContext().getRequestDispatcher("/pages/error.jsp").forward(req, res);
        }
        else {
            chain.doFilter(req, res);
        }
    }
}
