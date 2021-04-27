package cafe.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CafeDao;
import vo.CafeVo;

/**
 * Servlet implementation class CafeTagSortAction
 */
@WebServlet("/cafe/cafe_tag.do")
public class CafeTagSortAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String c_tag = request.getParameter("c_tag");
		int c_i = Integer.parseInt(request.getParameter("c_i"));
		//		if(search==null)search="null";
				//System.out.println(search);
				//검색옵션 Map으로 포장
		Map map = new HashMap();
		map.put("c_i", c_i);

		//이름+내용
		if(c_tag!=null ) {
				//     key = value
				//       name=길동
				//     content=길동
			map.put("c_tag", c_tag);
			//System.out.println(map);
		}
		Map map1 = new HashMap();
		

		//이름+내용
		if(c_tag!=null ) {
				//     key = value
				//       name=길동
				//     content=길동
			map1.put("c_tag", c_tag);
			//System.out.println(map);
		}

		List<CafeVo> list = CafeDao.getInstance().selectList(map);
		List<CafeVo> list1 = CafeDao.getInstance().SelectList1(map1);
		int b = (int) Math.ceil(list1.size()/5.0);
		//System.out.println(b);
		
		request.setAttribute("b", b);
		request.setAttribute("list1", list1);
		request.setAttribute("list", list);

		
		

		//Dispatcher(forward)
		String forward_page = "../content/cafe/cafe_tag.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}
