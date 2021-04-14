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

@WebServlet(name = "EditAdvertEditPriceServlet", urlPatterns = "/editAdvert/editPrice")
public class EditAdvertEditPriceServlet extends HttpServlet {
    private AdvertService advertService = new AdvertService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idAdvert = Long.parseLong(req.getParameter("id"));
        req.setAttribute("id", idAdvert);
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        Advert advert = advertService.getAdvert(idAdvert);
        req.setAttribute("advert", advert);
       String editPrice = req.getParameter("editPrice");
        if (editPrice != null) {
            req.setAttribute("choicePrice", true);
        }
        String newPrice = req.getParameter("newPrice");
        try {
            if (newPrice != null && !newPrice.equals("") && Double.parseDouble(newPrice) > 0) {
                double newPrice1 = Double.parseDouble(newPrice);
                advertService.editPriceByIdAdvert(idAdvert,currentUser.getId(), newPrice1);
                resp.sendRedirect("/editAdvert?id=" + idAdvert);
            }
                else{
                    getServletContext().getRequestDispatcher("/pages/editAdvert.jsp").forward(req, resp);
            }
        }
        catch (NumberFormatException e) {
                getServletContext().getRequestDispatcher("/pages/editAdvert.jsp").forward(req, resp);
        }
    }
    }

