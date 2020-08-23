package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ReviewVo;

public class ReviewDao {
	SqlSessionFactory factory;
	
	//single-ton : 객체 1개만생성해서 사용(서비스)하자
	static ReviewDao single = null;

	public static ReviewDao getInstance() {

		if (single == null)
			single = new ReviewDao();
		return single;
	}

	public ReviewDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public int Insert(ReviewVo vo) {
		
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("review.review_insert",vo);
		
		sqlSession.close();
		
		return res;
	}
	
	public List<ReviewVo> SelectList(int c_idx) {
		
		List<ReviewVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("review.review_selectone", c_idx);
		
	
		sqlSession.close();

		
		return list;
	}
	

public ReviewVo selectOne_r(int c_idx) {
	// TODO Auto-generated method stub
	ReviewVo vo = null;
	
	SqlSession sqlSession = factory.openSession();
	
	vo = sqlSession.selectOne("review.review_grade",c_idx);
			
	sqlSession.close();
	
	return vo;
}
public List<ReviewVo> SelectList1(int m_idx) {
		
		List<ReviewVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("review.review_selectone_my", m_idx);
		
	
		sqlSession.close();

		
		return list;
	}
public List<ReviewVo> SelectList() {
		
		List<ReviewVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("review.review_select");
		
	
		sqlSession.close();

		
		return list;
	}

public int delete(int r_idx) {
	// TODO Auto-generated method stub
	int res = 0;
	
	SqlSession sqlSession = factory.openSession(true);
	
	res = sqlSession.delete("review.review_delete",r_idx);
	
	sqlSession.close();
	
	
	return res;
}

public ReviewVo selectOne(int r_idx) {
	// TODO Auto-generated method stub
	ReviewVo vo = null;
	
	SqlSession sqlSession = factory.openSession();
	
	vo = sqlSession.selectOne("review.review_selectone_up",r_idx);
			
	sqlSession.close();
	
	return vo;
}

public int update(ReviewVo vo) {
	// TODO Auto-generated method stub
	int res = 0;
	
	SqlSession sqlSession = factory.openSession(true);
	
	res = sqlSession.update("review.review_update",vo);
	
	sqlSession.close();
	
	return res;
}

}
