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

@WebServlet(name = "EditAdvertEditDescriptionServlet", urlPatterns = "/editAdvert/editDescription")
public class EditAdvertEditDescriptionServlet extends HttpServlet {
    private AdvertService advertService = new AdvertService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idAdvert = Long.parseLong(req.getParameter("id"));
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        req.setAttribute("id", idAdvert);
        Advert advert = advertService.getAdvert(idAdvert);
        req.setAttribute("advert", advert);
        String editDescription = req.getParameter("editDescription");
        if (editDescription != null) {
            req.setAttribute("choiceDescription", true);
        }
        String specificationAdvert = req.getParameter("specificationAdvert");
        if (specificationAdvert != null) {
            advertService.editSpecificationByIdAdvert(idAdvert,currentUser.getId(), specificationAdvert);
            resp.sendRedirect("/editAdvert?id=" + idAdvert);
        } else {
            getServletContext().getRequestDispatcher("/pages/editAdvert.jsp").forward(req, resp);
        }
    }

}
