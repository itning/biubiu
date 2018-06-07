package sl.itcast.service.Impl;

import sl.itcast.dao.impl.BoardDao;
import sl.itcast.entity.Board;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.IBoardServise;

import java.util.List;

/**
 * @author 舒露
 */
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
        boardDao.add(board);
    }

    @Override
    public void delect(String id) {
        boardDao.delect(id);
    }

    @Override
    public void updata(Board board) {
        boardDao.updata(board);

    }

    @Override
    public Board FindBoarderById(String id) {
        return boardDao.FindBoarderById(id);
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
