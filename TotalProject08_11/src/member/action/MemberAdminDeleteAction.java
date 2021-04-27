package member.action;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberDeleteAction
 */
@WebServlet("/member_delete.do")
public class MemberAdminDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		MemberVo vo = MemberDao.getInstance().selectOne(m_idx);
		
		String web_path = "/upload/";//À¥°æ·Î
		
		ServletContext application = request.getServletContext();
		
		String abs_path = application.getRealPath(web_path);
	
		
		File f = new File(abs_path,vo.getM_photo());
		
		f.delete();
		
		int res = MemberDao.getInstance().delete(m_idx);
		
		response.sendRedirect("member_adminpage_form.do");

		
	}

}
