package cafe.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CafeDao;
import vo.CafeVo;

/**
 * Servlet implementation class CafeInsertFormAction
 */
@WebServlet("/cafe/update_form.do")
public class CafeUpdateFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		
		CafeVo vo = CafeDao.getInstance().selectOne(c_idx);
		
		
		
		
		request.setAttribute("vo", vo);
		

		//Dispatcher(forward)
		String forward_page = "../content/mypage/cafeEdit.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}