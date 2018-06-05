package sl.itcast.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import sl.itcast.dao.oracle_impl.IFoodTypeDao;
import sl.itcast.entity.FoodType;
import sl.itcast.util.JdbcUtils;

import java.util.List;

public class FoodTypeDao implements IFoodTypeDao {
    @Override
    public void save(FoodType foodType) {
        String sql = "INSERT INTO foodType VALUES(?,?)";
        try {
            JdbcUtils.getQuerrRunner().update(sql, foodType.getId(),foodType.getTypeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(FoodType foodType) {
        String sql = "update foodType set typeName=? where id=?";
        try {
            JdbcUtils.getQuerrRunner().update(sql, foodType.getTypeName(),foodType.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String id) {
        String sql = "delete from foodType where id=?";
        try {
            JdbcUtils.getQuerrRunner().update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public FoodType findById(String id) {
        String sql = "select * from foodType where id=?";
        try {
            return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<>(FoodType.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FoodType> getAll() {
        String sql = "select * from foodType";
        try {
            return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<FoodType>(FoodType.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @Override
    public List<FoodType> getAll(String typeName) {
        String sql = "select * from foodType where typeName like ?";
        try {
            return JdbcUtils.getQuerrRunner()
                    .query(sql, new BeanListHandler<FoodType>(FoodType.class),"%" + typeName + "%");
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
