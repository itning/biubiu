package sl.itcast.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import sl.itcast.dao.oracle_impl.IBoardDao;
import sl.itcast.entity.Board;
import sl.itcast.util.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 舒露
 */
public class BoardDao implements IBoardDao {
    @Override
    public List<Board> FindBoardList() {
        try {
            String sql = "SELECT * FROM dinnertable;";
            return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<>(Board.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Board board) {
        try {
            String sql = "INSERT INTO dinnertable VALUES(?,?,?,?)";
            JdbcUtils.getQuerrRunner().update(sql, board.getId(), board.getTableName(), board.getTableStatus(), board.getOrderData());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delect(String id) {

    }

    @Override
    public void updata(Board board) {

        try {
            String sql = "update dinnertable set tableStatus=?";
            JdbcUtils.getQuerrRunner().update(sql, 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Board FindBoarderById(String id) {

        try {
            String sql = "select * from dinnertable where id=?";
            return JdbcUtils.getQuerrRunner().query(sql,new BeanHandler<Board>(Board.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Board> query() {
        return null;
    }

    @Override
    public List<Board> query(String keyword) {
        return null;
    }
}
