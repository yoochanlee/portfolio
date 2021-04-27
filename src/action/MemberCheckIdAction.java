package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.binding.StringFormatter;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//1.수신인코딩설정
		request.setCharacterEncoding("utf-8");
		
		//2.parameter(m_id)
		String m_id = request.getParameter("m_id");
		
		//3.DB조회
		MemberVo vo = MemberDao.getInstance().selectOne(m_id);
		
		boolean bResult = false;//기본값:사용못함
		
		if(vo==null) {//DB내에 등록된 정보가 없을경우
			bResult = true;//사용가능
		}
		
		String json = String.format("{\"result\":%b}", bResult);
		
		//결과응답
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json);
		
		
		
	}

}
