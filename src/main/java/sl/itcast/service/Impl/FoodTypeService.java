package sl.itcast.service.Impl;


import sl.itcast.dao.impl.FoodTypeDao;
import sl.itcast.dao.oracle_impl.IFoodTypeDao;
import sl.itcast.entity.FoodType;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.IFoodTypeService;

import java.util.List;

public class FoodTypeService implements IFoodTypeService {
    private IFoodTypeDao foodTypeDao;

    public FoodTypeService() {
        foodTypeDao = BeanFactory.getInstance("foodTypeDao", FoodTypeDao.class);
        System.out.println(foodTypeDao);
    }

    @Override
    public void save(FoodType foodType) {
        foodTypeDao.save(foodType);
    }

    @Override
    public void update(FoodType foodType) {
        foodTypeDao.update(foodType);
    }

    @Override
    public void delete(String id) {
        foodTypeDao.delete(id);
    }

    @Override
    public FoodType findById(String id) {
        return foodTypeDao.findById(id);
    }

    @Override
    public List<FoodType> getAll() {
        return foodTypeDao.getAll();
    }

    @Override
    public List<FoodType> getAll(String typeName) {

        return foodTypeDao.getAll(typeName);
    }
}
