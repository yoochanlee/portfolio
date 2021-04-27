package index;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CafeDao;
import dao.MemberDao;
import vo.CafeVo;
import vo.MemberVo;

/**
 * Servlet implementation class MemberListAction
 */
@WebServlet("/list.do")
public class MainAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	List<CafeVo> list4 = CafeDao.getInstance().selectList();
		
		
		request.setAttribute("list4", list4);
		
		

		//Dispatcher(forward)
		String forward_page = "index.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}