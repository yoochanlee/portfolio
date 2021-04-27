package dao;

import java.util.List;

import vo.ReviewVo;

public interface ReviewDao {

	public int Insert(ReviewVo vo);

	public List<ReviewVo> SelectList(int c_idx);

	public ReviewVo selectOne_r(int c_idx);

	public List<ReviewVo> SelectList1(int m_idx);

	public List<ReviewVo> SelectList();

	public int delete(int r_idx);

	public ReviewVo selectOne(int r_idx);

	public int update(ReviewVo vo);
	
	

}
