package member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dao.ReviewDao;
import vo.MemberVo;
import vo.ReviewVo;

/**
 * Servlet implementation class MemberModifyFormAction
 */
@WebServlet("/mypage_list.do")
public class MemberMypageFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		int m_idx = user.getM_idx();
		//System.out.println(m_idx);
		MemberVo vo = MemberDao.getInstance().selectOne(m_idx);
		
		String m_grade = vo.getM_grade();
		
		
		String forward_page = "";
		if(m_grade.equals("°ü¸®ÀÚ")) {
			
			response.sendRedirect("member_adminpage_form.do");
			return;
		}
		
		List<ReviewVo> list = ReviewDao.getInstance().SelectList1(m_idx);
		
		request.setAttribute("list", list);
		
		
		
		forward_page ="/content/mypage/user_mypage.jsp";
				//Dispatcher(forward)
		
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}