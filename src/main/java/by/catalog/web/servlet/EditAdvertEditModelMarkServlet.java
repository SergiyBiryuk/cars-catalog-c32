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

@WebServlet(name = "EditAdvertEditModelMarkServlet", urlPatterns = "/editAdvert/editMarkModel")
public class EditAdvertEditModelMarkServlet extends HttpServlet {
    private AdvertService advertService = new AdvertService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idAdvert = Long.parseLong(req.getParameter("id"));
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        req.setAttribute("id", idAdvert);
        Advert advert = advertService.getAdvert(idAdvert);
        req.setAttribute("advert", advert);
        List listMark = advertService.returnSortMark();
        req.setAttribute("listMark", listMark);
        String editMarkModel = req.getParameter("editMarkModel");
        if (editMarkModel != null) {
            req.setAttribute("choiceMarkModel", true);
            req.setAttribute("choiceMark", true);
        }
        String editMark = req.getParameter("editMark");
        if (editMark != null) {
            req.setAttribute("choiceMarkModel", true);
            req.setAttribute("choiceModel", true);
        }

        String newMark = req.getParameter("newMark");
        req.setAttribute("newMark", newMark);
        if (newMark != null) {
            List listModel = advertService.returnModelByMark(newMark);
            req.setAttribute("listModel", listModel);
        }
        String newModel = req.getParameter("newModel");
        if (newMark != null && newModel != null) {
            advertService.editAdvertMarkAndModelByIdAdvert(idAdvert, currentUser.getId(), newMark, newModel);
            resp.sendRedirect("/editAdvert?id=" + idAdvert);
        } else {
            getServletContext().getRequestDispatcher("/pages/editAdvert.jsp").forward(req, resp);
        }
    }



}




