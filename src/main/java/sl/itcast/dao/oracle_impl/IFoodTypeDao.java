package sl.itcast.dao.oracle_impl;

import sl.itcast.entity.Food;
import sl.itcast.entity.FoodType;

import java.util.List;

public interface IFoodTypeDao {

    /**
     * 添加
     */
    void save(FoodType foodType);

    /**
     * 更新
     */
    void update(FoodType foodType);

    /**
     * 删除
     */
    void delete(String id);

    /**
     * 根据主键查询
     */
    FoodType findById(String id);

    /**
     * 查询全部
     */
    List<FoodType> getAll();

    /**
     * 根据菜系名称查询
     */
    List<FoodType> getAll(String typeName);

}
