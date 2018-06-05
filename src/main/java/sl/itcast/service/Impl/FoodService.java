package sl.itcast.service.Impl;

import sl.itcast.dao.impl.FoodDao;
import sl.itcast.dao.oracle_impl.IFoodDao;
import sl.itcast.entity.Food;
import sl.itcast.entity.FoodType;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.IFoodService;

import java.util.List;

public class FoodService implements IFoodService {
    private IFoodDao foodDao;

    public FoodService() {
        foodDao = BeanFactory.getInstance("foodDao", FoodDao.class);
    }

    @Override
    public List<FoodType> FindTypeList() {
        return foodDao.FindTypeList();
    }

    @Override
    public void add(Food food) {
        foodDao.add(food);
    }

    @Override
    public void delete(String id) {
        foodDao.delete(id);
    }

    @Override
    public void updata(Food food) {
foodDao.updata(food);
    }

    @Override
    public List<Food> query() {
        return foodDao.query();
    }

    @Override
    public Food findById(String id) {
        return foodDao.findById(id);
    }

    @Override
    public List<Food> query(String keyword) {
        return foodDao.query(keyword);
    }
}
