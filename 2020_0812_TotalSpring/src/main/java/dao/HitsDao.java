package dao;

import vo.HitsVo;

public interface HitsDao {

	public HitsVo selectOne1(int c_idx);

	public int update(HitsVo vo);

	public int insert(HitsVo vo);

}
