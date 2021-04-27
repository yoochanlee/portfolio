package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.CafeDao;
import dao.MemberDao;
import dao.ReviewDao;
import vo.CafeVo;
import vo.MemberVo;
import vo.ReviewVo;

public class MemberServiceImpl implements MemberService {
	
	@Autowired
	CafeDao cafe_dao;
	@Autowired
	MemberDao member_dao;
	@Autowired
	ReviewDao review_dao;

	@Override
	public int member_insert(MemberVo vo) {
		// TODO Auto-generated method stub
		return member_dao.insert(vo);
	}

	@Override
	public int member_delete(int m_idx) {
		// TODO Auto-generated method stub
		return member_dao.delete(m_idx);
	}

	@Override
	public MemberVo member_selectone(int m_idx) {
		// TODO Auto-generated method stub
		return member_dao.selectOne(m_idx);
	}

	@Override
	public List<MemberVo> member_selectList() {
		// TODO Auto-generated method stub
		return member_dao.selectList();
	}

	@Override
	public List<CafeVo> cafe_selectList() {
		// TODO Auto-generated method stub
		return cafe_dao.selectList();
	}

	@Override
	public List<ReviewVo> review_selectList() {
		// TODO Auto-generated method stub
		return review_dao.SelectList();
	}

	@Override
	public MemberVo member_login(String m_id) {
		// TODO Auto-generated method stub
		return member_dao.selectOne(m_id);
	}

	@Override
	public List<ReviewVo> review_selectone(int m_idx) {
		// TODO Auto-generated method stub
		return review_dao.SelectList1(m_idx);
	}

	@Override
	public int member_update(MemberVo vo) {
		// TODO Auto-generated method stub
		return member_dao.update(vo);
	}

	@Override
	public int image_update(MemberVo vo) {
		// TODO Auto-generated method stub
		return member_dao.image_update(vo);
	}
	
	
	
	
	
	
	
	
	
	
	

	
}
