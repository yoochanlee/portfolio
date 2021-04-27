package dao;

import java.util.List;

import vo.MemberVo;

public interface MemberDao {

	public List<MemberVo> selectList();

	public int insert(MemberVo vo);

	public MemberVo selectOne(String m_id);

	public MemberVo selectOne(int m_idx);

	public int update(MemberVo vo);

	public int delete(int m_idx);
	
	public int image_update(MemberVo vo);
}
