package sl.itcast.servlet.Food;

import sl.itcast.entity.Food;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.Impl.FoodService;
import sl.itcast.util.FileUpDownLoadUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class addServlet extends HttpServlet {
    private FoodService foodService = BeanFactory.getInstance("foodService", FoodService.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Food food = new Food();
        String id=UUID.randomUUID().toString();
        food.setId(id);
        Map<String,String> map=FileUpDownLoadUtils.FileUpLoad(request,id);
        /*Map<String, String> map = new XiaoShuLuFileUtils().setOutPutDir("D:\\img").setFileName(id).startUpload(request);*/
        System.out.println(map.size());
        food.setFoodName( map.get("foodName"));
        food.setFoodType_id(map.get("cid"));
        System.out.println(map.get("mprice"));
        food.setMprice(Double.parseDouble(map.get("mprice")));
        food.setPrice(Double.parseDouble(map.get("price")));
        food.setRemark(map.get("introduce"));
        food.setImg(map.get("imageUrl"));
        foodService.add(food);
        request.getRequestDispatcher("/foodServlet").forward(request,response);
    }
}
