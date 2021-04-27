package cafe.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CafeDao;
import dao.MemberDao;
import vo.CafeVo;

/**
 * Servlet implementation class MemberDeleteAction
 */
@WebServlet("/cafe/cafe_delete.do")
public class CafeDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		
		CafeVo vo = CafeDao.getInstance().selectOne(c_idx);
		
		String web_path = "/upload/";//À¥°æ·Î
		
		ServletContext application = request.getServletContext();
		
		String abs_path = application.getRealPath(web_path);
	
		
		File f = new File(abs_path,vo.getC_photo());
		
		f.delete();
		
		
		int res = CafeDao.getInstance().delete(c_idx);
		
		
		response.sendRedirect("../member_adminpage_form.do");

		
	}

}
