package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.CafeDao;
import dao.MemberDao;
import dao.ReviewDao;
import service.MemberService;
import vo.CafeVo;
import vo.MemberVo;
import vo.ReviewVo;

@Controller
public class MemberController {

	// DispatcherServlet이 자동연결(Injection)
	@Autowired
	ServletContext application;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	@Autowired
	MemberService member_service;

	// 회원가입
	@RequestMapping("/member/member_insert.do")
	public String member_insert(MemberVo vo, @RequestParam MultipartFile m_photo_file) throws Exception {

		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
		System.out.println(abs_path);
		String filename = "no_file";

		/// 업로드된 파일이 있으면
		if (m_photo_file.isEmpty() == false) {
			// 업로드된 파일명 구하기
			filename = m_photo_file.getOriginalFilename();

			File f = new File(abs_path, filename);

			// 동일파일(명)이 있냐?
			if (f.exists()) {
				long t = System.currentTimeMillis();
				filename = String.format("%d_%s", t, filename);
				f = new File(abs_path, filename);
			}

			// 임시저장된 파일을 지정된 위치로 복사
			m_photo_file.transferTo(f);
		}

		String m_tel1 = vo.getM_tel1();
		String m_tel2 = vo.getM_tel2();
		String m_tel3 = vo.getM_tel3();

		// m_id=admin1234&m_pwd=flzldi12%40&c_pwd=flzldi12%40&m_name=이유찬&m_gender=남성&m_tel1=010&m_tel2=5420&m_tel3=5585&m_email=leee302%40naver.com&m_photo=&m_grade=일반

		StringBuffer sb = new StringBuffer();
		sb.append(m_tel1);
		sb.append("-");
		sb.append(m_tel2);
		sb.append("-");
		sb.append(m_tel3);
		String m_tel = sb.toString();
		String m_ip = request.getRemoteAddr();
		vo.setM_ip(m_ip);
		vo.setM_tel(m_tel);
		vo.setM_photo(filename);

		int res = member_service.member_insert(vo);

		return "redirect:../index.do";

	}

	// 관리자 회원 탈퇴
	@RequestMapping("/member/member_delete.do")
	public String member_admin_delete(int m_idx) {

		MemberVo vo = member_service.member_selectone(m_idx);

		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);

		File f = new File(abs_path, vo.getM_photo());

		f.delete();

		int res = member_service.member_delete(m_idx);

		return "redirect:member_adminpage_form.do";

	}

	// 관리자 페이지
	@RequestMapping("/member/member_adminpage_form.do")
	public String member_adminpage_form(Model model) {

		// System.out.println("안돼");

		List<MemberVo> list = member_service.member_selectList();
		List<CafeVo> list1 = member_service.cafe_selectList();
		List<ReviewVo> list2 = member_service.review_selectList();

		model.addAttribute("list", list);
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);

		// Dispatcher(forward)
		return "content/mypage/admin_mypage";

	}

	// 중복아이디 체크
	@RequestMapping(value = "/member/check_id.do", produces = "text/json;charset=utf-8;")
	@ResponseBody
	public String check_id(String m_id) {
		// 1.수신인코딩설정

		// 3.DB조회
		MemberVo vo = member_service.member_login(m_id);

		boolean bResult = false;// 기본값:사용못함

		if (vo == null) {// DB내에 등록된 정보가 없을경우
			bResult = true;// 사용가능
		}

		String json = String.format("{\"result\":%b}", bResult);

		return json;

	}

	// 회원탈퇴
	@RequestMapping("/member/member_admin_delete.do")
	public String member_delete(int m_idx, HttpServletRequest request) {

		MemberVo vo = member_service.member_selectone(m_idx);

		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);

		File f = new File(abs_path, vo.getM_photo());

		f.delete();

		int res = member_service.member_delete(m_idx);

		session = request.getSession();
		session.removeAttribute("user");

		return "redirect:index.do";

	}

	// 회원가입창
	@RequestMapping("/member/insert_form.do")
	public String insert_form() {

		// Dispatcher(forward)
		return "/content/user/user_join";

	}

	// 로그인 아이디 비밀번호 체크
	@RequestMapping(value = "/login.do", produces = "text/json;charset=utf-8;")
	@ResponseBody
	public String login(String m_id, String m_pwd) {

		// 3.m_id에 해당되는 객체 1개얻어오기
		MemberVo user = member_service.member_login(m_id);

		// System.out.println(m_id);
		String result = "";
		if (user == null) {
			result = "fail_id";
		} else {
			// 비밀번호체크
			if (user.getM_pwd().equals(m_pwd) == false) {
				result = "fail_pwd";
			} else {
				// 로그인 성공
				result = "success";
				// 로그인 정보를 세션에 넣는다
				session = request.getSession();
				session.setAttribute("user", user);

			}

		}

		// 결과정보(JSON)
		String json = String.format("{\"result\":\"%s\"}", result);

		return json;

	}

	// 로그아웃
	@RequestMapping("/logout.do")
	public String logout() {
		session = request.getSession();
		session.removeAttribute("user");

		return "redirect:index.do";
	}

	// 내가쓴 글 페이지
	@RequestMapping("/member/myadmin_review.do")
	public String myadmin_review(Model model) {

		session = request.getSession();

		MemberVo user = (MemberVo) session.getAttribute("user");

		int m_idx = user.getM_idx();

		List<ReviewVo> list = member_service.review_selectone(m_idx);

		model.addAttribute("list", list);

		// Dispatcher(forward)
		return "content/mypage/myadmin_reviewList";

	}

	// 마이페이지 관리자랑 나누기
	@RequestMapping("/member/mypage_list.do")
	public String mypage_list(Model model) {

		session = request.getSession();

		MemberVo user = (MemberVo) session.getAttribute("user");

		int m_idx = user.getM_idx();
		// System.out.println(m_idx);
		MemberVo vo = member_service.member_selectone(m_idx);

		String m_grade = vo.getM_grade();

		String forward_page = "";
		if (m_grade.equals("관리자")) {

			return "redirect:member_adminpage_form.do";

		}

		List<ReviewVo> list = member_service.review_selectone(m_idx);

		model.addAttribute("list", list);

		return "content/mypage/user_mypage";

	}

	// 회원수정 폼
	@RequestMapping("/member/update_form.do")
	public String update_form(Model model, int m_idx) {

		MemberVo vo = member_service.member_selectone(m_idx);
		// System.out.println(m_idx);

		model.addAttribute("vo", vo);

		// Dispatcher(forward)
		return "content/user/user_edit";

	}

	// 회원수정
	@RequestMapping("/member/member_update.do")
	public String member_update(MemberVo vo, Model model) throws Exception {
		MemberVo select = member_service.member_selectone(vo.getM_idx());
		
		vo.setM_photo(select.getM_photo());
		

		String m_tel1 = vo.getM_tel1();
		String m_tel2 = vo.getM_tel2();
		String m_tel3 = vo.getM_tel3();

		// m_id=admin1234&m_pwd=flzldi12%40&c_pwd=flzldi12%40&m_name=이유찬&m_gender=남성&m_tel1=010&m_tel2=5420&m_tel3=5585&m_email=leee302%40naver.com&m_photo=&m_grade=일반

		StringBuffer sb = new StringBuffer();
		sb.append(m_tel1);
		sb.append("-");
		sb.append(m_tel2);
		sb.append("-");
		sb.append(m_tel3);
		String m_tel = sb.toString();
		String m_ip = request.getRemoteAddr();
		vo.setM_ip(m_ip);
		vo.setM_tel(m_tel);
		

		int res = member_service.member_update(vo);
		
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		user.setM_name(user.getM_name());	

		return "redirect:../index.do";

	}

	@RequestMapping("/member/member_image_update")
	public String member_image_update(MemberVo vo,@RequestParam MultipartFile m_photo_file) throws Exception{

		MemberVo select = member_service.member_selectone(vo.getM_idx());

		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
		String filename = "no_file";

		String old_photo = select.getM_photo();

		File old_f = new File(abs_path, old_photo);
		
		// 이전 이미지 삭제
		old_f.delete();
		/// 업로드된 파일이 있으면
		if (m_photo_file.isEmpty() == false) {

			// 업로드된 파일명 구하기
			filename = m_photo_file.getOriginalFilename();

			File f = new File(abs_path, filename);

			// 동일파일(명)이 있냐?
			if (f.exists()) {
				long t = System.currentTimeMillis();
				filename = String.format("%d_%s", t, filename);
				f = new File(abs_path, filename);
			}

			// 임시저장된 파일을 지정된 위치로 복사
			m_photo_file.transferTo(f);

		}
		
		vo.setM_photo(filename);
		int res = member_service.image_update(vo);
			

		MemberVo user = (MemberVo) session.getAttribute("user");
		user.setM_photo(filename);	
			
		
			
			
		return "redirect:mypage_list.do";

	}

}
