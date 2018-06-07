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
import java.util.List;

@WebServlet(name = "BoardListServlet",urlPatterns = "/BoardListServlet")
public class BoardListServlet extends HttpServlet {
    private BoardService boardService= BeanFactory.getInstance("BoardService", BoardService.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<Board> list=boardService.FindBoardList();
        request.setAttribute("list",list);
        this.getServletContext().getRequestDispatcher("/sys/boardList.jsp").forward(request,response);
    }
}
