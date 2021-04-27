package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;


public class MemberDaoImpl implements MemberDao {

	SqlSession sqlSession;
	
	
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<MemberVo> selectList(){
		
		List<MemberVo> list = null;
		
		
		
		//�۾���ûMy����
		list = sqlSession.selectList("member.member_list");
		
		
		
		
		return list;
	}
	
	public int insert(MemberVo vo) {
		int res = 0;
		
		

		//�۾���û����
		res = sqlSession.insert("member.member_insert",vo);
		
		
		
		
		return res;
	}
	
	public MemberVo selectOne(String m_id) {

		MemberVo vo = null;
		
		
		
		//�۾���û����
		vo = sqlSession.selectOne("member.member_login_one",m_id);
		
		

		return vo;
	}
	
	public MemberVo selectOne(int m_idx) {

		MemberVo vo = null;
		
		
		
		//�۾���û����
		vo = sqlSession.selectOne("member.member_modify_one",m_idx);
		
		

		return vo;
	}

	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		
		

		//�۾���û����
		res = sqlSession.insert("member.member_update",vo);
		
		
		return res;
	}
	
	public int image_update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		
		

		//�۾���û����
		res = sqlSession.update("member.member_image_update",vo);
		
		
		return res;
	}
	
	

	public int delete(int m_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		
		

		//�۾���û����
		res = sqlSession.insert("member.member_delete",m_idx);
		
		
		return res;
	}
	
}
