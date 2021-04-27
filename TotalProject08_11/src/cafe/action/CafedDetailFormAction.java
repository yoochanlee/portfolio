package cafe.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CafeDao;
import dao.HitsDao;
import dao.ReviewDao;
import vo.CafeVo;
import vo.HitsVo;
import vo.ReviewVo;

/**
 * Servlet implementation class CafedDetailFormAction
 */
@WebServlet("/cafe/cafe_detail_form.do")
public class CafedDetailFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		
		CafeVo vo = CafeDao.getInstance().selectOne(c_idx);
		

		
		
		List<ReviewVo> list =  ReviewDao.getInstance().SelectList(c_idx);
		ReviewVo vo2 = ReviewDao.getInstance().selectOne_r(c_idx);
		
		
		// m_idx멤버의 장바구니의 p_idx 있냐? 
		HitsVo vo4 = new HitsVo(c_idx);
		
		
		
				
		HitsVo res_vo = HitsDao.getInstance().selectOne1(c_idx);


		if(res_vo==null) {
			
		//장바구니등록
		int res = HitsDao.getInstance().insert(vo4);
			
		}else {//이미 등록되어있는경우
			
		int res = HitsDao.getInstance().update(vo4);
		}
		HitsVo hu = HitsDao.getInstance().selectOne1(c_idx);
		
		
		
		request.setAttribute("hu", hu);
		request.setAttribute("vo", vo);
		
		request.setAttribute("list", list);
		request.setAttribute("vo2", vo2);
		

		//Dispatcher(forward)
		String forward_page = "../content/cafe/cafe_detail.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		
	}

}