package sl.itcast.dao.oracle_impl;

import sl.itcast.entity.Board;

import java.util.List;

public interface IBoardDao {
    List<Board> FindBoardList();
    void add(Board board);
    void delect(String id);
    void updata(Board board);
    Board FindBoarderById(String id);
    List<Board> query();
    List<Board> query(String keyword);
}
