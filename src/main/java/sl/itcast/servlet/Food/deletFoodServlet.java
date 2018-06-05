package sl.itcast.servlet.Food;

import sl.itcast.factory.BeanFactory;
import sl.itcast.service.Impl.FoodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deletFoodServlet extends HttpServlet {
    private FoodService foodService = BeanFactory.getInstance("foodService", FoodService.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        foodService.delete(id);
        request.getRequestDispatcher("/foodServlet").forward(request,response);
    }
}
