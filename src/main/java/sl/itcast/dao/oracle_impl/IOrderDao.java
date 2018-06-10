package sl.itcast.dao.oracle_impl;

import sl.itcast.entity.Orders;
import sl.itcast.util.PageBean;

import java.util.List;

/**
 * @author 舒露
 */
public interface IOrderDao {
    public void add(Orders orders);
    public int getCount();
    public void update(Orders orders);
    public List<Orders> query();
    public void getAll(PageBean<Orders> pb);
    public int getTotalCount();

}
