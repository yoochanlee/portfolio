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
 * Servlet implementation class ReviewInsertAction
 */
@WebServlet("/review/review_insert.do")
public class ReviewInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		int r_grade = Integer.parseInt(request.getParameter("r_grade"));
		String r_pwd = request.getParameter("r_pwd");
		String r_cot = request.getParameter("r_cot");
		String r_ip = request.getRemoteAddr();
		
		ReviewVo vo = new ReviewVo(r_cot, m_idx, c_idx, r_grade, r_pwd, r_ip);
		
		int res = ReviewDao.getInstance().Insert(vo);
		
		response.sendRedirect("../cafe/cafe_detail_form.do?c_idx=" + vo.getC_idx());

		

	}

}