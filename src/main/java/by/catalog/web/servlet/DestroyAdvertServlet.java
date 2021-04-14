package by.catalog.web.servlet;

import by.catalog.domain.User;
import by.catalog.service.AdvertService;
;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/destroyAdvert", name = "DestroyAdvertServlet")
public class DestroyAdvertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdvertService advertService = new AdvertService();
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        long id = Long.parseLong(req.getParameter("id"));
        advertService.destroyAdvertByIdAdvert(id, currentUser.getId());
        advertService.destroyUserAdvertList(id);
        resp.sendRedirect("/pers/youAdvert");
    }
}
