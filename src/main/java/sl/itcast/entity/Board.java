package sl.itcast.entity;

import java.util.Date;

public class Board {
    private String id;
    private String tableName;
    private Date orderData;
    private int tableStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Date getOrderData() {
        return orderData;
    }

    public void setOrderData(Date orderData) {
        this.orderData = orderData;
    }

    public int getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(int tableStatus) {
        this.tableStatus = tableStatus;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", tableName='" + tableName + '\'' +
                ", orderdata=" + orderData +
                ", tableStatus=" + tableStatus +
                '}';
    }
}
