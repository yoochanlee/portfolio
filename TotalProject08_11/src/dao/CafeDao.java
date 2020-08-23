package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CafeVo;

public class CafeDao {
	
	SqlSessionFactory factory;
	
	//single-ton : ��ü 1���������ؼ� ���(����)����
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
		
		//�۾���û����
		vo = sqlSession.selectOne("cafe.cafe_select_one",c_idx);
		
		//Ʈ����� : commit():����  or rollback():���
		
		//sqlSession.commit();//����
		
		//�ݳ�
		sqlSession.close();
		
		
		return vo;
	}

	public int update(CafeVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		//�۾���û����
		res = sqlSession.update("cafe.cafe_update",vo);
		
		sqlSession.close();
		
		return res;
	}

	public int delete(int c_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		//�۾���û����
		res = sqlSession.delete("cafe.cafe_delete",c_idx);
		
		sqlSession.close();
		
		
		return res;
	}
	
	public List<CafeVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<CafeVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		//�۾�(��û)����
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
