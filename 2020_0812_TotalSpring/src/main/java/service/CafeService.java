package service;

import java.util.List;
import java.util.Map;

import vo.CafeVo;
import vo.HitsVo;
import vo.ReviewVo;

public interface CafeService {

	
	List<CafeVo> main_list();
	
	int insert(CafeVo vo);
	
	int delete(int c_idx);
	
	int update(CafeVo vo);
	
	CafeVo selectOne(int c_idx);
	
	List<CafeVo> tag_list(Map map);
	
	List<CafeVo> tag_size(Map map1);
	
	List<CafeVo> local_list(Map map);
	
	List<CafeVo> local_size(Map map1);
	
	List<ReviewVo> review_list(int c_idx);
	
	ReviewVo review_grade(int c_idx);
	
	HitsVo hit_exist(int c_idx);
	
	int hit_insert(HitsVo vo4);
	
	int hit_update(HitsVo vo4);

	int cafe_image_update(CafeVo vo);
    
    
	
	
	

}
