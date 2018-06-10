package sl.itcast.servlet.frontend;

import sl.itcast.entity.Food;
import sl.itcast.entity.OrderDetail;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.Impl.FoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 舒露
 */
@WebServlet(name = "CaidanServlet", urlPatterns = "/CaidanServlet")
public class CaidanServlet extends HttpServlet {
    private FoodService foodService = BeanFactory.getInstance("foodService", FoodService.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Food> list = foodService.query();
        List<Food> list1=list.stream().map(food -> {
            if(food.getImg()!=null) {
                food.setImg("/img/" + food.getImg());
            }
           return food;
        }).collect(Collectors.toList());
        HttpSession session = request.getSession();
        session.setAttribute(request.getParameter("id"),new HashMap<String,Food>());
        request.setAttribute("list", list1);
        request.getRequestDispatcher("/sys/frontend/caidan.jsp").forward(request, response);
    }
}
