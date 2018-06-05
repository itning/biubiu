package sl.itcast.servlet.Food;

import sl.itcast.entity.Food;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.Impl.FoodService;
import sl.itcast.service.Impl.FoodTypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class foodServlet extends HttpServlet {
    private FoodService foodService = BeanFactory.getInstance("foodService", FoodService.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Food> list=foodService.query();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/sys/foodList.jsp").forward(request,response);
    }
}
