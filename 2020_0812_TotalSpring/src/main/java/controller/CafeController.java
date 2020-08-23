package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import dao.HitsDao;
import dao.MemberDao;
import dao.ReviewDao;
import service.CafeService;
import vo.CafeVo;
import vo.HitsVo;
import vo.MemberVo;
import vo.ReviewVo;

@Controller
public class CafeController {
	
	
	// DispatcherServlet이 자동연결(Injection)
	@Autowired
	ServletContext application;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	CafeService cafe_service;
	

	
	//메인으로
	@RequestMapping("/index.do")
	public String main_list(Model model) {

	List<CafeVo> list1 = cafe_service.main_list();
			
			
	model.addAttribute("list1", list1);

	//Dispatcher(forward)
	return "index";
			
	}
		//카페등록
	@RequestMapping("/cafe/cafe_insert.do")
	public String cafe_insert(CafeVo vo,@RequestParam MultipartFile c_photo_file) throws Exception {
			
			
			
			
			String web_path = "/resources/upload/";
			String abs_path = application.getRealPath(web_path);
			System.out.println(abs_path);
			String filename = "no_file";
			
			/// 업로드된 파일이 있으면
			if (c_photo_file.isEmpty() == false) {
				// 업로드된 파일명 구하기
				filename = c_photo_file.getOriginalFilename();

				File f = new File(abs_path, filename);

				// 동일파일(명)이 있냐?
				if (f.exists()) {
					long t = System.currentTimeMillis();
					filename = String.format("%d_%s", t, filename);
					f = new File(abs_path, filename);
				}

				// 임시저장된 파일을 지정된 위치로 복사
				c_photo_file.transferTo(f);
			}
			
			String m_zipcode = vo.getM_addr();
			String m_addr = vo.getM_zipcode();
			StringBuffer sb = new StringBuffer();
			sb.append(m_zipcode);
			sb.append(m_addr);
			String c_addr = sb.toString();
			vo.setC_addr(c_addr);
			vo.setC_photo(filename);
			
			
			
			int res = cafe_service.insert(vo);
			
			return"redirect:../member/mypage_list.do";
			
			//Dispatcher(forward)
		
		}

	
	
	
	
		//카페 등록폼
		@RequestMapping("/cafe/insert_form.do")
		public String insert_form() {
			

			//Dispatcher(forward)
			return "content/mypage/cafeWrite";
		}
		
		//카페삭제
		@RequestMapping("/cafe/cafe_delete.do")
		public String cafe_delete(int c_idx) {
				
				
				
				CafeVo vo = cafe_service.selectOne(c_idx);
				
				String web_path = "/resources/upload/";
				String abs_path = application.getRealPath(web_path);
			
				File f = new File(abs_path,vo.getC_photo());
				
				f.delete();
				
				
				int res = cafe_service.delete(c_idx);
				
				
				return "redirect:../member/member_adminpage_form.do";

				
			}
		
		//카페 테크별 분류
		@RequestMapping("/cafe/cafe_tag.do")
		public String cafe_tag(String c_tag,int c_i,Model model) {
				
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

				List<CafeVo> list = cafe_service.tag_list(map);
				List<CafeVo> list1 = cafe_service.tag_size(map1);
				int b = (int) Math.ceil(list1.size()/5.0);
				//System.out.println(b);
				
				model.addAttribute("b", b);
				model.addAttribute("list1", list1);
				model.addAttribute("list", list);

				
				


				return "content/cafe/cafe_tag";
				
			}
		
		//카페 지역별 분류
		@RequestMapping("/cafe/cafe_sort.do")
		public String cafe_sort(String c_addr,int c_i,Model model) {
				
				//		if(search==null)search="null";
						//System.out.println(search);
						//검색옵션 Map으로 포장
						Map map = new HashMap();
						map.put("c_i", c_i);

						//이름+내용
						if(c_addr!=null ) {
								//     key = value
								//       name=길동
								//     content=길동
							map.put("c_addr", c_addr);
							//System.out.println(map);
						}
						Map map1 = new HashMap();
						

						//이름+내용
						if(c_addr!=null ) {
								//     key = value
								//       name=길동
								//     content=길동
							map1.put("c_addr", c_addr);
							//System.out.println(map);
						}
			
						
						
						List<CafeVo> list = cafe_service.local_list(map);
						List<CafeVo> list1 = cafe_service.local_size(map1);
				
						int b = (int) Math.ceil(list1.size()/5.0);
						//System.out.println(b);
						
						model.addAttribute("b", b);
						model.addAttribute("list1", list1);
						model.addAttribute("list", list);
			  
			  		//Dispatcher(forward)
					return  "content/cafe/cafe_list";
					
				
			}
		
		//카페 수정폼 
		@RequestMapping("/cafe/update_form.do")
		public String update_form(int c_idx,Model model) {
			
				
				CafeVo vo = cafe_service.selectOne(c_idx);

				model.addAttribute("vo", vo);

				return "content/mypage/cafeEdit";
				
			}
		//카페 수정
		@RequestMapping("/cafe/cafe_update.do")
		public String cafe_update(CafeVo vo)  {
			CafeVo vo1 = cafe_service.selectOne(vo.getC_idx());
				vo.setC_photo(vo1.getC_photo());
			
				
				
				String m_zipcode = vo.getM_addr();
				String m_addr = vo.getM_zipcode();
				StringBuffer sb = new StringBuffer();
				sb.append(m_zipcode);
				sb.append(m_addr);
				String c_addr = sb.toString();
				vo.setC_addr(c_addr);
				
				
				int res = cafe_service.update(vo);

				return"redirect:../member/member_adminpage_form.do";
			}
	
	






	//카페 상세보기
	@RequestMapping("/cafe/cafe_detail_form.do")
	public String cafe_detail_form(int c_idx,Model model) {
			
			
			
			CafeVo vo = cafe_service.selectOne(c_idx);
			

			
			
			List<ReviewVo> list =  cafe_service.review_list(c_idx);
			ReviewVo vo2 = cafe_service.review_grade(c_idx);
			
			
			//c_idx에 조회수가 있니
			
			 
			HitsVo vo4 = new HitsVo(c_idx);
		
			HitsVo res_vo = cafe_service.hit_exist(c_idx);


			if(res_vo==null) {
				
			//조회수등록
			int res = cafe_service.hit_insert(vo4);
				
			}else {//이미 등록되어있는경우
				
			int res = cafe_service.hit_update(vo4);
			}
			HitsVo hu = cafe_service.hit_exist(c_idx);
			
			
			
			model.addAttribute("hu", hu);
			model.addAttribute("vo", vo);
			model.addAttribute("list", list);
			model.addAttribute("vo2", vo2);

			return  "content/cafe/cafe_detail";
			
			
		}
	
	//카페 파일 업로드 
		@RequestMapping(value = "/cafe/image_cafe_update.do", produces = "text/json;charset=utf-8;")
		@ResponseBody
		public String image_cafe_update(int c_idx,@RequestParam MultipartFile c_photo_file) throws Exception{
			String web_path = "/resources/upload/";
			String abs_path = application.getRealPath(web_path);
			String filename = "no_file";
			
			CafeVo vo = cafe_service.selectOne(c_idx);
			
			String old_photo = vo.getC_photo();

			File old_f = new File(abs_path, old_photo);
			
			// 이전 이미지 삭제
			old_f.delete();
			
			
			/// 업로드된 파일이 있으면
			if (c_photo_file.isEmpty() == false) {
			
				
				// 업로드된 파일명 구하기
				filename = c_photo_file.getOriginalFilename();

				File f = new File(abs_path, filename);

				// 동일파일(명)이 있냐?
				if (f.exists()) {
					long t = System.currentTimeMillis();
					filename = String.format("%d_%s", t, filename);
					f = new File(abs_path, filename);
				}

				// 임시저장된 파일을 지정된 위치로 복사
				c_photo_file.transferTo(f);
			}
			vo.setC_photo(filename);
			
			int res = cafe_service.cafe_image_update(vo);

			boolean bResult = false;
			
			String json = String.format("{\"filename\":\"%s\"}",vo.getC_photo());

			return json;

		}

}
