package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CafeVo;

public class CafeDao {
	
	SqlSessionFactory factory;
	
	//single-ton : 객체 1개만생성해서 사용(서비스)하자
	static CafeDao single = null;

	public static CafeDao getInstance() {

		if (single == null)
			single = new CafeDao();
		return single;
	}

	public CafeDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<CafeVo> selectList(){
		List<CafeVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("cafe.cafe_list",list);
		
		sqlSession.close();
		
		return list;
	}

	public int insert(CafeVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("cafe.cafe_insert",vo);
		
		sqlSession.close();
		
		return res;
	}

	public CafeVo selectOne(int c_idx) {
		// TODO Auto-generated method stub
		CafeVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		//작업요청수행
		vo = sqlSession.selectOne("cafe.cafe_select_one",c_idx);
		
		//트랜잭션 : commit():적용  or rollback():취소
		
		//sqlSession.commit();//수동
		
		//반납
		sqlSession.close();
		
		
		return vo;
	}

	public int update(CafeVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		//작업요청수행
		res = sqlSession.update("cafe.cafe_update",vo);
		
		sqlSession.close();
		
		return res;
	}

	public int delete(int c_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		//작업요청수행
		res = sqlSession.delete("cafe.cafe_delete",c_idx);
		
		sqlSession.close();
		
		
		return res;
	}
	
	public List<CafeVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<CafeVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		//작업(요청)수행
		list = sqlSession.selectList("cafe.cafe_cafe_condition",map);
		
		
		sqlSession.close();

		return list;
	}
	
public List<CafeVo> SelectList1(Map map1) {
		
		List<CafeVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("cafe.cafe_selectList", map1);
		
	
		sqlSession.close();

		
		return list;
	}

}
