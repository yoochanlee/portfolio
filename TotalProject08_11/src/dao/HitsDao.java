package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.HitsVo;

public class HitsDao {
	

		SqlSessionFactory factory;
		
		//single-ton : 객체 1개만생성해서 사용(서비스)하자
		static HitsDao single = null;

		public static HitsDao getInstance() {

			if (single == null)
				single = new HitsDao();
			return single;
		}

		public HitsDao() {
			// TODO Auto-generated constructor stub
			factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		}
		public HitsVo selectOne1(int c_idx){
			HitsVo vo = null; 
			
			SqlSession sqlSession = factory.openSession();
			
			vo = sqlSession.selectOne("hits.hits_select",c_idx);
			
			sqlSession.close();
			
			return vo;
		}

		
		
		public int update(HitsVo vo) {
			// TODO Auto-generated method stub
			int res = 0;
			
			SqlSession sqlSession = factory.openSession(true);
			
			//작업요청수행
			res = sqlSession.update("hits.hits_update",vo);
			sqlSession.close();
			
			
			return res;
		}
		
		public int insert(HitsVo vo) {
			// TODO Auto-generated method stub
			int res = 0;
			
			SqlSession sqlSession = factory.openSession(true);
			
			res = sqlSession.insert("hits.hits_insert",vo);
			
			sqlSession.close();
			
			return res;
		}
				

	
}
