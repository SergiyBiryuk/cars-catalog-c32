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

@WebServlet(urlPatterns = "/editAdvert")
public class EditAdvertServlet extends HttpServlet {

    private AdvertService advertService = new AdvertService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idAdvert = Long.parseLong(req.getParameter("id"));
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        req.setAttribute("id", idAdvert);
        Advert advert = advertService.getAdvertByIdAdvertAndIdUser(idAdvert, currentUser.getId());
        req.setAttribute("advert", advert);
        getServletContext().getRequestDispatcher("/pages/editAdvert.jsp").forward(req, resp);

    }


}