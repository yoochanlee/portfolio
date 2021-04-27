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
 * Servlet implementation class CafeSortAction
 */
@WebServlet("/cafe/cafe_sort.do")
public class CafeSortAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�˻�ī�װ�
				request.setCharacterEncoding("utf-8");
				
				//�˻��� �ޱ�
				String c_addr = request.getParameter("c_addr");
				int c_i = Integer.parseInt(request.getParameter("c_i"));
		//		if(search==null)search="null";
				//System.out.println(search);
				//�˻��ɼ� Map���� ����
				Map map = new HashMap();
				map.put("c_i", c_i);

				//�̸�+����
				if(c_addr!=null ) {
						//     key = value
						//       name=�浿
						//     content=�浿
					map.put("c_addr", c_addr);
					//System.out.println(map);
				}
				Map map1 = new HashMap();
				

				//�̸�+����
				if(c_addr!=null ) {
						//     key = value
						//       name=�浿
						//     content=�浿
					map1.put("c_addr", c_addr);
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
			String forward_page = "../content/cafe/cafe_list.jsp";
			RequestDispatcher disp = request.getRequestDispatcher(forward_page);
			disp.forward(request, response);

		
	}
}