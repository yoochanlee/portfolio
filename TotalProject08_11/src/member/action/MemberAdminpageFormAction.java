package member.action;

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
import dao.ReviewDao;
import vo.CafeVo;
import vo.MemberVo;
import vo.ReviewVo;

/**
 * Servlet implementation class MemberAdminpageFormAction
 */
@WebServlet("/member_adminpage_form.do")
public class MemberAdminpageFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("¾ÈµÅ");
		
		List<MemberVo> list = MemberDao.getInstance().selectList();
		List<CafeVo> list1 = CafeDao.getInstance().selectList();
		List<ReviewVo>list2= ReviewDao.getInstance().SelectList();
		
		
		request.setAttribute("list", list);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		
		//Dispatcher(forward)
		String forward_page = "content/mypage/admin_mypage.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}
