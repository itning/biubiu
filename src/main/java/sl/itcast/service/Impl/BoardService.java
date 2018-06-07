package sl.itcast.service.Impl;

import sl.itcast.dao.impl.BoardDao;
import sl.itcast.entity.Board;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.IBoardServise;

import javax.swing.border.Border;
import java.util.List;

public class BoardService implements IBoardServise {
    private BoardDao boardDao;

    public BoardService() {
        boardDao = BeanFactory.getInstance("BoardDao", BoardDao.class);
    }
    @Override
    public List<Board> FindBoardList() {
        return boardDao.FindBoardList();
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
