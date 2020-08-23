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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.javafx.binding.StringFormatter;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberInsertAction
 */
@WebServlet("/insert.do")
public class MemberInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String web_path = "/upload/";//�����
		//�����->������
		ServletContext application = request.getServletContext();
		//������ġ
		String abs_path = application.getRealPath(web_path);
		
		//���ε�� ������ ũ������
		int max_size = 1024*1024*100; //100MB
		//��ü ������ ���ÿ� ���ε尡 �Ϸ�                                                        ������ġ       ����ũ��        �������ڵ�           �ߺ��̸����ϰ� �ϴ°� 
		MultipartRequest mr = new MultipartRequest(request, abs_path, max_size, "utf-8", new DefaultFileRenamePolicy());
		
		//���ε� �� �����̸� ������
		String m_photo ="NULL";
		File f = mr.getFile("m_photo");//<form parame name="p_photo">
		if(f!=null) {
			m_photo = f.getName();
		}
//m_id=admin1234&m_pwd=flzldi12%40&c_pwd=flzldi12%40&m_name=������&m_gender=����&m_tel1=010&m_tel2=5420&m_tel3=5585&m_email=leee302%40naver.com&m_photo=&m_grade=�Ϲ�
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
		
		
		
		
		MemberVo vo = new MemberVo(m_id, m_pwd, m_name, m_gender, m_tel, m_email, m_photo, m_grade, m_ip);
		
		int res =  MemberDao.getInstance().insert(vo);
		
		response.sendRedirect("list.do");
		
		

	}

}
