package sl.itcast.servlet.frontend;

import sl.itcast.entity.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 舒露
 */
@WebServlet(name = "ShowClientCarServlet", urlPatterns = "/ShowClientCarServlet")
public class ShowClientCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String tableId = (String) session.getAttribute("tableId");
        @SuppressWarnings("unchecked")
        List<Food> list = (List<Food>) session.getAttribute(tableId);
        /*list.stream().forEach(food -> System.out.println(food));*/
        request.setAttribute("list",list);
        request.getRequestDispatcher("/sys/frontend/clientCart.jsp").forward(request,response);
    }
}
