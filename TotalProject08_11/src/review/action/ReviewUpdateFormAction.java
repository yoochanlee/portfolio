package review.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import vo.ReviewVo;

/**
 * Servlet implementation class ReviewUpdateFormAction
 */
@WebServlet("/review/review_update_form.do")
public class ReviewUpdateFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		
		ReviewVo vo = ReviewDao.getInstance().selectOne(r_idx);
		
		request.setAttribute("vo", vo);

		//Dispatcher(forward)
		String forward_page = "../content/mypage/review.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}
