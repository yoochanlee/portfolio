package dao;

import java.util.List;
import java.util.Map;

import vo.CafeVo;

public interface CafeDao {

	public List<CafeVo> selectList();

	public int insert(CafeVo vo);

	public CafeVo selectOne(int c_idx);

	public int update(CafeVo vo);

	public int delete(int c_idx);

	public List<CafeVo> selectList(Map map);

	public List<CafeVo> SelectList1(Map map1);

	public int image_update(CafeVo vo);

}
