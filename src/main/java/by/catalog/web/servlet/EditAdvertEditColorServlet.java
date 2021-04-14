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

@WebServlet(name = "EditAdvertEditColorServlet", urlPatterns = "/editAdvert/editColor")
public class EditAdvertEditColorServlet extends HttpServlet {
    private AdvertService advertService = new AdvertService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idAdvert = Long.parseLong(req.getParameter("id"));
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        req.setAttribute("id", idAdvert);
        Advert advert = advertService.getAdvert(idAdvert);
        req.setAttribute("advert", advert);
        String[] colorList = advertService.colorList();
        req.setAttribute("colorList", colorList);
        String editColor = req.getParameter("editColor");
        if (editColor != null) {
            req.setAttribute("choiceColor", true);
        }
        String newColor = req.getParameter("newColor");
        if (newColor!=null){
            advertService.editColorByIdAdvert(idAdvert, currentUser.getId(), newColor);
            resp.sendRedirect("/editAdvert?id=" + idAdvert);
        }
        else {
            getServletContext().getRequestDispatcher("/pages/editAdvert.jsp").forward(req, resp);
        }
    }
}
