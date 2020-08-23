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
 * Servlet implementation class ReviewUpdateAction
 */
@WebServlet("/review/mypage_review_update.do")
public class ReviewUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		String r_cot = request.getParameter("r_cot");
		int r_grade = Integer.parseInt(request.getParameter("r_grade"));
		String r_pwd = request.getParameter("r_pwd");
		
		
		ReviewVo vo = new ReviewVo(r_idx, r_cot, r_grade, r_pwd);
		
		int res = ReviewDao.getInstance().update(vo);

		
		response.sendRedirect("../mypage_list.do");
	}

}
