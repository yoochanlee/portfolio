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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberUpdateAction
 */
@WebServlet("/update.do")
public class MemberUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//m_id=hong1234121&m_pwd=flzldi12%40&c_pwd=flzldi12%40&m_name=이유찬&m_gender=on&m_tel1=011&m_tel2=3442&m_tel3=1214&m_email=leee302%40naver.com&m_photo=
		request.setCharacterEncoding("utf-8");
		

		
		String web_path = "/upload/";//웹경로
		//웹경로->절대경로
		ServletContext application = request.getServletContext();
		//저장위치
		String abs_path = application.getRealPath(web_path);
		
		//업로드될 파일의 크기제한
		int max_size = 1024*1024*100; //100MB
		//객체 생성과 동시에 업로드가 완료                                                        저장위치       저장크기        수신인코딩           중복이름못하게 하는거 
		MultipartRequest mr = new MultipartRequest(request, abs_path, max_size, "utf-8", new DefaultFileRenamePolicy());
		
		//업로드 된 파일이름 얻어오기
		String m_photo ="NULL";
		File f = mr.getFile("m_photo");//<form parame name="p_photo">
		if(f!=null) {
			m_photo = f.getName();
		}
//m_id=admin1234&m_pwd=flzldi12%40&c_pwd=flzldi12%40&m_name=이유찬&m_gender=남성&m_tel1=010&m_tel2=5420&m_tel3=5585&m_email=leee302%40naver.com&m_photo=&m_grade=일반
		int m_idx = Integer.parseInt(mr.getParameter("m_idx"));
		String m_id = mr.getParameter("m_id");
		String m_pwd = mr.getParameter("m_pwd");
		String m_name = mr.getParameter("m_name");
		String m_gender = mr.getParameter("m_gender");
		String m_tel1 = mr.getParameter("m_tel1");
		String m_tel2 = mr.getParameter("m_tel2");
		String m_tel3 = mr.getParameter("m_tel3");
		String m_email = mr.getParameter("m_email");
		String m_grade = mr.getParameter("m_grade");
		StringBuffer sb = new StringBuffer();
		sb.append(m_tel1);
		sb.append("-");
		sb.append(m_tel2);
		sb.append("-");
		sb.append(m_tel3);
		String m_tel = sb.toString();
		String m_ip = request.getRemoteAddr();
		
		MemberVo vo = new MemberVo(m_idx, m_id, m_pwd, m_name, m_gender, m_tel, m_email, m_photo, m_grade, m_ip);
		
		int res = MemberDao.getInstance().update(vo);
		
		
		//session.removeAttribute("user");
		HttpSession session = request.getSession();
		MemberVo user1 = (MemberVo) session.getAttribute("user");
		m_grade = user1.getM_grade();
		
		
		if(m_grade.equals("일반")) {
		
		MemberVo user = MemberDao.getInstance().selectOne(m_id);
		
		session.setAttribute("user", user);
		
		}
		
		response.sendRedirect("mypage_list.do");
		
	}

}
