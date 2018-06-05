package sl.itcast.servlet.FoodType;

import sl.itcast.entity.FoodType;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.Impl.FoodTypeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CuisineListServlet extends HttpServlet {
    private FoodTypeService foodTypeService=BeanFactory.getInstance("foodTypeService",FoodTypeService.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<FoodType> list=foodTypeService.getAll();
        request.setAttribute("list",list);
        try {
            this.getServletContext().getRequestDispatcher("/sys/cuisineList.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
