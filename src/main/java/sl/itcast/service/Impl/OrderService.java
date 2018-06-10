package sl.itcast.service.Impl;

import sl.itcast.dao.impl.OrderDao;
import sl.itcast.entity.Orders;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.IOrderService;
import sl.itcast.util.PageBean;

import java.util.List;

public class OrderService implements IOrderService {
    private OrderDao orderDao;

    public OrderService() {
        orderDao = BeanFactory.getInstance("OrderDao", OrderDao.class);
    }
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
