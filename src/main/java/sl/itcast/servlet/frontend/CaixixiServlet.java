package sl.itcast.servlet.frontend;

import sl.itcast.entity.Food;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.Impl.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 舒露
 */
@WebServlet(name = "CaixixiServlet", urlPatterns = "/CaixixiServlet")
public class CaixixiServlet extends HttpServlet {
    private FoodService foodService = BeanFactory.getInstance("foodService", FoodService.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Food food = foodService.findById(request.getParameter("id"));
        food.setImg("/img/"+food.getImg());
        request.setAttribute("food",food);
        request.getRequestDispatcher("/sys/frontend/caixiangxi.jsp").forward(request, response);
    }
}
