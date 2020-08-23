package service;

import vo.ReviewVo;

public interface ReviewService {
	
	int review_delete(int r_idx);
	
	int review_insert(ReviewVo vo);
	
	int review_update(ReviewVo vo);
	
	ReviewVo review_selectone(int r_idx);
}
