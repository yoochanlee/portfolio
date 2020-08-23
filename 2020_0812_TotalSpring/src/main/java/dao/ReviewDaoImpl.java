package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ReviewVo;

public class ReviewDaoImpl implements ReviewDao{
	
	SqlSession sqlSession;
	
	
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int Insert(ReviewVo vo) {
		
		int res = 0;
		
		
		
		res = sqlSession.insert("review.review_insert",vo);
		
		
		
		return res;
	}
	
	public List<ReviewVo> SelectList(int c_idx) {
		
		List<ReviewVo> list = null;
		
		
		
		list = sqlSession.selectList("review.review_selectone", c_idx);
		
	


		
		return list;
	}
	

public ReviewVo selectOne_r(int c_idx) {
	// TODO Auto-generated method stub
	ReviewVo vo = null;
	
	
	
	vo = sqlSession.selectOne("review.review_grade",c_idx);
			
	
	
	return vo;
}
public List<ReviewVo> SelectList1(int m_idx) {
		
		List<ReviewVo> list = null;
		
		
		
		list = sqlSession.selectList("review.review_selectone_my", m_idx);
		
	
		

		
		return list;
	}
public List<ReviewVo> SelectList() {
		
		List<ReviewVo> list = null;
		
		
		
		list = sqlSession.selectList("review.review_select");
		
	
		

		
		return list;
	}

public int delete(int r_idx) {
	// TODO Auto-generated method stub
	int res = 0;
	
	
	
	res = sqlSession.delete("review.review_delete",r_idx);
	
	
	
	
	return res;
}

public ReviewVo selectOne(int r_idx) {
	// TODO Auto-generated method stub
	ReviewVo vo = null;
	
	
	
	vo = sqlSession.selectOne("review.review_selectone_up",r_idx);
			
	
	
	return vo;
}

public int update(ReviewVo vo) {
	// TODO Auto-generated method stub
	int res = 0;
	
	
	
	res = sqlSession.update("review.review_update",vo);
	
	return res;
}

}
