package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.domain.User;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/pers/interestingAdvert", name = "InterestingAdvertServlet")
public class InterestingAdvertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        AdvertService advertService = new AdvertService();
        List<Advert> allAdvertsFromUser = advertService.findAllInterestingAdverts(currentUser.getId());
        req.setAttribute("listAdvert", allAdvertsFromUser);
        req.getServletContext().getRequestDispatcher("/pages/interestingAdvert.jsp").forward(req, resp);
    }

}
