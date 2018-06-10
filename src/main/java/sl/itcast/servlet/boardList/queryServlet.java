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

/**
 * @author 舒露
 */
@WebServlet(name = "queryServlet", urlPatterns = "/queryServlet")
public class queryServlet extends HttpServlet {
    private BoardService boardService = BeanFactory.getInstance("BoardService", BoardService.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Board> list=boardService.query(keyword);
        request.setAttribute("list",list);
        this.getServletContext().getRequestDispatcher("/sys/boardList.jsp").forward(request,response);

    }
}
