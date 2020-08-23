package dao;

import org.apache.ibatis.session.SqlSession;

import vo.HitsVo;

public class HitsDaoImpl implements HitsDao {
	

		SqlSession sqlSession;
		
		
		
		public void setSqlSession(SqlSession sqlSession) {
			this.sqlSession = sqlSession;
		}



		public HitsVo selectOne1(int c_idx){
			HitsVo vo = null; 
			
			
			
			vo = sqlSession.selectOne("hits.hits_select",c_idx);
			
			
			
			return vo;
		}

		
		
		public int update(HitsVo vo) {
			// TODO Auto-generated method stub
			int res = 0;
			
			
			
			//작업요청수행
			res = sqlSession.update("hits.hits_update",vo);
			
			
			return res;
		}
		
		public int insert(HitsVo vo) {
			// TODO Auto-generated method stub
			int res = 0;
			
			
			
			res = sqlSession.insert("hits.hits_insert",vo);
			
			
			
			return res;
		}
				

	
}
