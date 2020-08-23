package service;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import dao.CafeDao;
import dao.HitsDao;
import dao.MemberDao;
import dao.ReviewDao;
import vo.CafeVo;
import vo.HitsVo;
import vo.ReviewVo;

public class CafeServiceImpl implements CafeService {
	
	@Autowired
	CafeDao cafe_dao;
	@Autowired
	MemberDao member_dao;
	@Autowired
	ReviewDao review_dao;
	@Autowired
	HitsDao hits_dao;
	


	@Override
	public List<CafeVo> main_list() {
		// TODO Auto-generated method stub
		List<CafeVo> list1 = cafe_dao.selectList();

		//Dispatcher(forward)
		return list1 ;
	}


	@Override
	public int insert(CafeVo vo) {
		// TODO Auto-generated method stub
		return cafe_dao.insert(vo);
	}
	
	@Override
	public int delete(int c_idx) {
		
		return cafe_dao.delete(c_idx);
	}


	@Override
	public CafeVo selectOne(int c_idx) {
		// TODO Auto-generated method stub
		return cafe_dao.selectOne(c_idx);
	}
	@Override
	public List<CafeVo> tag_list(Map map) {
		
		return cafe_dao.selectList(map);
	} 
	@Override
	public List<CafeVo> tag_size(Map map1){
		
		return cafe_dao.SelectList1(map1);
	}


	@Override
	public List<CafeVo> local_list(Map map) {
		// TODO Auto-generated method stub
		return cafe_dao.selectList(map);
	}


	@Override
	public List<CafeVo> local_size(Map map1) {
		// TODO Auto-generated method stub
		return cafe_dao.SelectList1(map1);
	}


	@Override
	public int update(CafeVo vo) {
		// TODO Auto-generated method stub
		return cafe_dao.update(vo);
	}


	@Override
	public List<ReviewVo> review_list(int c_idx) {
		// TODO Auto-generated method stub
		return review_dao.SelectList(c_idx);
	}


	@Override
	public ReviewVo review_grade(int c_idx) {
		// TODO Auto-generated method stub
		return review_dao.selectOne_r(c_idx);
	}


	@Override
	public HitsVo hit_exist(int c_idx) {
		// TODO Auto-generated method stub
		return hits_dao.selectOne1(c_idx);
	}


	@Override
	public int hit_insert(HitsVo vo4) {
		// TODO Auto-generated method stub
		return hits_dao.insert(vo4);
	}


	@Override
	public int hit_update(HitsVo vo4) {
		// TODO Auto-generated method stub
		return hits_dao.update(vo4);
	}


	@Override
	public int cafe_image_update(CafeVo vo) {
		// TODO Auto-generated method stub
		return cafe_dao.image_update(vo);
	}
	
	
	
	
	
	
	
	
	
	
	
}

