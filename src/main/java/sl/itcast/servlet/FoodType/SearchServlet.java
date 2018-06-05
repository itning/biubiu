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

public class SearchServlet extends HttpServlet {
    private FoodTypeService foodTypeService = BeanFactory.getInstance("foodTypeService", FoodTypeService.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String keyword=request.getParameter("keyword");
        List<FoodType> list=foodTypeService.getAll(keyword);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/sys/cuisineList.jsp").forward(request,response);
    }
}
