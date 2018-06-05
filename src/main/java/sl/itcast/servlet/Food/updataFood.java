package sl.itcast.servlet.Food;

import sl.itcast.entity.Food;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.Impl.FoodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class updataFood extends HttpServlet {
    private FoodService foodService = BeanFactory.getInstance("foodService", FoodService.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Food food = new Food();
        food.setId(request.getParameter("id"));
        food.setFoodName(request.getParameter("foodName"));
        food.setFoodType_id(request.getParameter("cid"));
        food.setMprice(Double.parseDouble(request.getParameter("mprice")));
        food.setPrice(Double.parseDouble(request.getParameter("price")));
        food.setRemark(request.getParameter("introduce"));
        food.setImg(request.getParameter("imageUrl"));
        foodService.updata(food);
        request.getRequestDispatcher("/foodServlet").forward(request,response);
    }
}
