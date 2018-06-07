package sl.itcast.servlet.boardList;

import sl.itcast.entity.Board;
import sl.itcast.factory.BeanFactory;
import sl.itcast.service.Impl.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 舒露
 */
@WebServlet(name = "SaveBoardServlet",urlPatterns ="/SaveBoardServlet")
public class SaveBoardServlet extends HttpServlet {
    private BoardService boardService= BeanFactory.getInstance("BoardService", BoardService.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String bName = request.getParameter("bName");
        Board board = new Board();
        board.setId(UUID.randomUUID().toString());
        board.setTableName(bName);
        boardService.add(board);
        this.getServletContext().getRequestDispatcher("/BoardListServlet").forward(request,response);
    }
}
