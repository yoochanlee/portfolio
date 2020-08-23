package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVo;


public class MemberDao {

	SqlSessionFactory factory;
	
	//single-ton : ��ü 1���������ؼ� ���(����)����
	static MemberDao single = null;

	public static MemberDao getInstance() {

		if (single == null)
			single = new MemberDao();
		return single;
	}

	public MemberDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<MemberVo> selectList(){
		
		List<MemberVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		//�۾���ûMy����
		list = sqlSession.selectList("member.member_list");
		
		
		sqlSession.close();
		
		return list;
	}
	
	public int insert(MemberVo vo) {
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		

		//�۾���û����
		res = sqlSession.insert("member.member_insert",vo);
		
		//Ʈ����� : commit():����  or rollback():���
		
		
		//sqlSession.commit();//����
		
		//�ݳ�
		sqlSession.close();
		
		
		return res;
	}
	
	public MemberVo selectOne(String m_id) {

		MemberVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		//�۾���û����
		vo = sqlSession.selectOne("member.member_login_one",m_id);
		
		//Ʈ����� : commit():����  or rollback():���
		
		//sqlSession.commit();//����
		
		//�ݳ�
		sqlSession.close();

		return vo;
	}
	
	public MemberVo selectOne(int m_idx) {

		MemberVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		//�۾���û����
		vo = sqlSession.selectOne("member.member_modify_one",m_idx);
		
		//Ʈ����� : commit():����  or rollback():���
		
		//sqlSession.commit();//����
		
		//�ݳ�
		sqlSession.close();

		return vo;
	}

	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		

		//�۾���û����
		res = sqlSession.insert("member.member_update",vo);
		
		//Ʈ����� : commit():����  or rollback():���
		
		
		//sqlSession.commit();//����
		
		//�ݳ�
		sqlSession.close();
		return res;
	}

	public int delete(int m_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		

		//�۾���û����
		res = sqlSession.insert("member.member_delete",m_idx);
		
		
		return res;
	}
	
}
