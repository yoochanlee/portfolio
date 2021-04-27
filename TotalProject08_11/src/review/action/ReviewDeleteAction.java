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
 * Servlet implementation class ReviewDeleteAction
 */
@WebServlet("/review/review_delete.do")
public class ReviewDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		
		int res = ReviewDao.getInstance().delete(r_idx);
		
		response.sendRedirect("../mypage_list.do");
	
	}

}
