package sl.itcast.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import sl.itcast.dao.oracle_impl.IFoodDao;
import sl.itcast.entity.Food;
import sl.itcast.entity.FoodType;
import sl.itcast.util.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class FoodDao implements IFoodDao {

    @Override
    public List<FoodType> FindTypeList() {
        try {
            String sql = "SELECT typeName,id FROM foodtype;";
            return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<>(FoodType.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Food food) {
        try {
            String sql = "INSERT INTO food VALUES(?,?,?,?,?,?,?)";
            JdbcUtils.getQuerrRunner().update(sql,food.getId(),food.getFoodName(),food.getFoodType_id(),food.getPrice(),food.getMprice(),food.getRemark(),food.getImg());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql="DELETE FROM food WHERE id=?;";
            JdbcUtils.getQuerrRunner().update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updata(Food food) {
        String sql = "update food set foodName=?,foodType_id=?,price=?,mprice=?,remark=?,img=? where id=?";
        try {
            JdbcUtils.getQuerrRunner().update(sql, food.getFoodName(),food.getFoodType_id(),food.getPrice(),food.getMprice(),food.getRemark(),food.getImg(),food.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Food> query() {
        try {
            String sql = "SELECT  food.id,food.foodName,foodtype.typeName AS foodType_id,food.price,food.mprice,food.remark,food.img FROM food  join foodtype on food.foodType_id=foodtype.id;";
            return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Food>(Food.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Food findById(String id) {
        String sql = "select * from food where id=?";
        try {
            return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<>(Food.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Food> query(String keyword) {
        String sql = "select * from food where foodName like ?";
        try {
            return JdbcUtils.getQuerrRunner()
                    .query(sql, new BeanListHandler<Food>(Food.class),"%" + keyword + "%");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
