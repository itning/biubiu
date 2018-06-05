package sl.itcast.servlet.FoodType;

import sl.itcast.entity.FoodType;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.Impl.FoodTypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateCuisineServlet extends HttpServlet {
    private FoodTypeService foodTypeService=BeanFactory.getInstance("foodTypeService",FoodTypeService.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String id=request.getParameter("id");
       FoodType foodType=foodTypeService.findById(id);
       request.setAttribute("foodType",foodType);
       request.getRequestDispatcher("/sys/updateCuisine.jsp").forward(request,response);
    }
}
