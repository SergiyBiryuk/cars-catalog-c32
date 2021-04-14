package by.catalog.web.servlet;

import by.catalog.domain.User;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/removeAdvert", name = "RemoveAdvertServlet")
public class RemoveAdvertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String id = req.getParameter("id");
        long idAdvert = Long.parseLong(id);
        AdvertService advertService = new AdvertService();
        advertService.removeInterestingAdvert(idAdvert, currentUser.getId());
        resp.sendRedirect("/advert?id=" + idAdvert);

    }
}
