package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.CafeVo;

public class CafeDaoImpl implements CafeDao{
	
	SqlSession sqlSession;
	
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<CafeVo> selectList(){
		List<CafeVo> list = null;
		
		
		
		list = sqlSession.selectList("cafe.cafe_list",list);
		
		
		
		return list;
	}

	public int insert(CafeVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		
		
		res = sqlSession.insert("cafe.cafe_insert",vo);
		
		
		
		return res;
	}

	public CafeVo selectOne(int c_idx) {
		// TODO Auto-generated method stub
		CafeVo vo = null;
		
		
		
		//작업요청수행
		vo = sqlSession.selectOne("cafe.cafe_select_one",c_idx);
		
		//트랜잭션 : commit():적용  or rollback():취소
		
		//sqlSession.commit();//수동
		
		//반납
		
		
		
		return vo;
	}

	public int update(CafeVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		
		
		//작업요청수행
		res = sqlSession.update("cafe.cafe_update",vo);
		
		
		return res;
	}

	public int delete(int c_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		
		
		//작업요청수행
		res = sqlSession.delete("cafe.cafe_delete",c_idx);
		
		
		return res;
	}
	
	public List<CafeVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<CafeVo> list = null;
		
		
		
		//작업(요청)수행
		list = sqlSession.selectList("cafe.cafe_cafe_condition",map);
		
		
		

		return list;
	}
	
public List<CafeVo> SelectList1(Map map1) {
		
		List<CafeVo> list = null;
		
		
		
		list = sqlSession.selectList("cafe.cafe_selectList", map1);
		
	
		

		
		return list;
	}

public int image_update(CafeVo vo) {
	// TODO Auto-generated method stub
	int res = 0;
	
	
	
	//작업요청수행
	res = sqlSession.update("cafe.cafe_image_update",vo);
	
	
	return res;
}

}
