package by.catalog.web.servlet;

import by.catalog.domain.User;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveAdvertServlet", urlPatterns = "/saveAdvert")
public class SaveAdvertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //сюда приходит с главной страницы запрос на добавление объявления автотизованного юзера
        String id = req.getParameter("id");
        long idAdvert = Long.parseLong(id);
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        long idCurrentUser = currentUser.getId();
        AdvertService advertService = new AdvertService();
        advertService.saveAdvertToUserAdvertList(idAdvert, idCurrentUser);
        resp.sendRedirect("/advert?id=" + idAdvert);
    }
}

