package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ReviewDao;
import vo.ReviewVo;

public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao review_dao;

	@Override
	public int review_delete(int r_idx) {
		// TODO Auto-generated method stub
		return review_dao.delete(r_idx);
	}

	@Override
	public int review_insert(ReviewVo vo) {
		// TODO Auto-generated method stub
		return review_dao.Insert(vo);
	}

	@Override
	public int review_update(ReviewVo vo) {
		// TODO Auto-generated method stub
		return review_dao.update(vo);
	}

	@Override
	public ReviewVo review_selectone(int r_idx) {
		// TODO Auto-generated method stub
		return review_dao.selectOne(r_idx);
	}
	
	
	
	
	
	
	
	
}
