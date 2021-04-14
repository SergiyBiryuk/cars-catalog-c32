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

@WebServlet(name = "EditAdvertEditYearServlet", urlPatterns = "/editAdvert/editYear")
public class EditAdvertEditYearServlet extends HttpServlet {
    private AdvertService advertService = new AdvertService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idAdvert = Long.parseLong(req.getParameter("id"));
        req.setAttribute("id", idAdvert);
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        Advert advert = advertService.getAdvert(idAdvert);
        req.setAttribute("advert", advert);
        List<Integer> listYear = advertService.listYear();
        req.setAttribute("listYear", listYear);
        String editYear = req.getParameter("editYear");
        if (editYear != null) {
            req.setAttribute("choiceYear", true);
        }
        String newYear = req.getParameter("newYear");
        if (newYear != null){
        int newYear1 = Integer.parseInt(newYear);
            advertService.editYearByIdAdvert(idAdvert,currentUser.getId(), newYear1);
            resp.sendRedirect("/editAdvert?id=" + idAdvert);
        }
        else {
            getServletContext().getRequestDispatcher("/pages/editAdvert.jsp").forward(req, resp);
        }
    }
    }

