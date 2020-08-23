package service;

import java.util.List;

import vo.CafeVo;
import vo.MemberVo;
import vo.ReviewVo;

public interface MemberService {

	int member_insert(MemberVo vo);
	
	int member_delete(int m_idx);
	
	MemberVo member_selectone(int m_idx);
	
	List<MemberVo> member_selectList();
	
	List<CafeVo> cafe_selectList();
	
	List<ReviewVo>review_selectList();
	
	List<ReviewVo>review_selectone(int m_idx);
	
	MemberVo member_login(String m_id);

	int member_update(MemberVo vo);

	int image_update(MemberVo vo);
	
	
}
