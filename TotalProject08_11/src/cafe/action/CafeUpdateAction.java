package cafe.action;

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

import dao.CafeDao;
import vo.CafeVo;

/**
 * Servlet implementation class CafeUpdateAction
 */
@WebServlet("/cafe/cafe_update.do")
public class CafeUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		String c_photo ="NULL";
		File f = mr.getFile("c_photo");//<form parame name="p_photo">
		if(f!=null) {
			c_photo = f.getName();
		}
		int c_idx = Integer.parseInt(mr.getParameter("c_idx"));
		String c_name = mr.getParameter("c_name");
		String m_zipcode = mr.getParameter("m_zipcode");
		String m_addr = mr.getParameter("m_addr");
		String c_tel = mr.getParameter("c_tel");
		String c_price = mr.getParameter("c_price");
		String c_park = mr.getParameter("c_park");
		String c_time = mr.getParameter("c_time");
		String c_hday = mr.getParameter("c_hday");
		String c_uri = mr.getParameter("c_uri");
		String c_menu1 = mr.getParameter("c_menu1");
		String c_menu2 = mr.getParameter("c_menu2");
		String c_menu3 = mr.getParameter("c_menu3");
		String c_menu4 = mr.getParameter("c_menu4");
		String c_tag = mr.getParameter("c_tag");
		
		String c_map = mr.getParameter("c_map");
		StringBuffer sb = new StringBuffer();
		sb.append(m_zipcode);
		sb.append(m_addr);
		String c_addr = sb.toString();
		
		CafeVo vo = new CafeVo(c_idx, c_name, c_addr, c_tel, c_price, c_park, c_time, c_hday, c_uri, c_map, c_photo, c_menu1, c_menu2, c_menu3, c_menu4, c_tag);
		
		int res = CafeDao.getInstance().update(vo);

		response.sendRedirect("../member_adminpage_form.do");
	}

}
