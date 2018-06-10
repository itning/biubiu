package sl.itcast.service;

import sl.itcast.entity.Orders;
import sl.itcast.util.PageBean;

import java.util.List;

public interface IOrderService {
    public void add(Orders orders);
    public int getCount();
    public void update(Orders orders);
    public List<Orders> query();
    public void getAll(PageBean<Orders> pb);
    public int getTotalCount();
}
