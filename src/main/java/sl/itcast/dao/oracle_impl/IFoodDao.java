package sl.itcast.dao.oracle_impl;


import sl.itcast.entity.Food;
import sl.itcast.entity.FoodType;

import java.util.List;

public interface IFoodDao {
    List<FoodType> FindTypeList();

    void add(Food food);

    void delete(String id);

    void updata(Food food);

    List<Food> query();

    Food findById(String id);

    List<Food> query(String keyword);
}
