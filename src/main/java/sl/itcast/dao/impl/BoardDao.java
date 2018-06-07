package sl.itcast.dao.impl;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import sl.itcast.dao.oracle_impl.IBoardDao;
import sl.itcast.entity.Board;
import sl.itcast.util.JdbcUtils;

import javax.swing.border.Border;
import java.sql.SQLException;
import java.util.List;

public class BoardDao implements IBoardDao {
    @Override
    public List<Board> FindBoardList() {
        try {
            String sql="SELECT * FROM dinnertable;";
            return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<>(Board.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Board board) {

    }

    @Override
    public void delect(String id) {

    }

    @Override
    public void updata(Border border) {

    }

    @Override
    public Border FindBoarderById(String id) {
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
