package sl.itcast.dao.impl;

import sl.itcast.dao.oracle_impl.IOrderDao;
import sl.itcast.entity.Orders;
import sl.itcast.util.PageBean;

import java.util.List;

/**
 * @author 舒露
 */
public class OrderDao implements IOrderDao {
    @Override
    public void add(Orders orders) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void update(Orders orders) {

    }

    @Override
    public List<Orders> query() {
        return null;
    }

    @Override
    public void getAll(PageBean<Orders> pb) {

    }

    @Override
    public int getTotalCount() {
        return 0;
    }
}
