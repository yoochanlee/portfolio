package controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ReviewDao;
import service.ReviewService;
import vo.ReviewVo;

@Controller
public class ReviewController {
	
	
	
	// DispatcherServletÀÌ ÀÚµ¿¿¬°á(Injection)
	@Autowired
	ServletContext application;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ReviewService review_service;
	
	
	//¸®ºä»èÁ¦
	@RequestMapping("/review/review_delete.do")
	public String review_delete(int r_idx) {
			
			
			int res = review_service.review_delete(r_idx);
			
			return "redirect:../member/mypage_list.do";
		
		}
	
	//¸®ºäµî·Ï
	@RequestMapping("/review/review_insert.do")
	public String review_insert(ReviewVo vo) {
			
			String r_ip = request.getRemoteAddr();
			vo.setR_ip(r_ip);
			int res = review_service.review_insert(vo);
			
			return "redirect:../cafe/cafe_detail_form.do?c_idx=" + vo.getC_idx();

			

		}
	
	//¸®ºä¼öÁ¤
	@RequestMapping("/review/mypage_review_update.do")
	public String mypage_review_update(ReviewVo vo) {			

			int res = review_service.review_update(vo);

			
			return "redirect:../member/mypage_list.do";
		}
	
	//¸®ºä¼öÁ¤ Æû 
	@RequestMapping("/review/review_update_form.do")
	public String review_update_form(int r_idx,Model model) {
			
			
			ReviewVo vo = review_service.review_selectone(r_idx);
			
			model.addAttribute("vo", vo);

			//Dispatcher(forward)
			return "content/mypage/review";
			
		}
}
