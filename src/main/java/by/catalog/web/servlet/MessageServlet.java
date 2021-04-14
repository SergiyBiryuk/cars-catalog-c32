package by.catalog.web.servlet;

import by.catalog.domain.User;
import by.catalog.service.AdvertService;
import by.catalog.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "MessageServlet", urlPatterns = "/MessageServlet")
public class MessageServlet extends HttpServlet {

    AdvertService advertService = new AdvertService();
    MessageService messageService = new MessageService();

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addMessage = req.getParameter("addMessage");
        long idAdvert = Long.parseLong(req.getParameter("id"));
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        long idCurrentUser = currentUser.getId();
        messageService.saveMessage(idAdvert, idCurrentUser, addMessage);
        resp.sendRedirect("/advert?id=" + idAdvert);
    }
}
