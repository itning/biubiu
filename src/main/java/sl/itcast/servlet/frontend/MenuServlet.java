package sl.itcast.servlet.frontend;

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

@WebServlet(name = "MenuServlet",urlPatterns = "/MenuServlet")
public class MenuServlet extends HttpServlet {
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
        this.getServletContext().getRequestDispatcher("/sys/frontend/frontend.jsp").forward(request,response);
    }
}
