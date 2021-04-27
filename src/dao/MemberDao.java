package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.MemberVo;

public class MemberDao {
//single-ton : 객체 1개만생성해서 사용(서비스)하자
	static MemberDao single = null;

	public static MemberDao getInstance() {

		if (single == null)
			single = new MemberDao();
		return single;
	}

	public MemberDao() {
		// TODO Auto-generated constructor stub
	}
	
	//회원목록 조회
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "select * from member";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatment객체 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet얻어오기
			rs = pstmt.executeQuery();

			//전체레코드를 vo로 포장후 ArrayList에 추가
			while (rs.next()) {
				//record를 담을 객체 생성
				MemberVo vo = new MemberVo();

				//record->vo로 옮긴다
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcode"));
				vo.setM_addr(rs.getString("m_addr"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_regdate(rs.getString("m_regdate"));
				vo.setM_grade(rs.getString("m_grade"));
				

				//ArrayList추가
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}
	
	//m_idx에 해당되는 회원정보 1건 얻기
	
	public MemberVo selectOne(int m_idx) {

		MemberVo vo = null;
		String sql = "select * from member where m_idx=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatment객체 얻어오기
			pstmt = conn.prepareStatement(sql);
			
			//2-2 pstmt parameter setting
			pstmt.setInt(1, m_idx);

			//3.ResultSet얻어오기
			rs = pstmt.executeQuery();

			//전체레코드를 vo로 포장후 반환
			if (rs.next()) {
				//record를 담을 객체 생성
				vo = new MemberVo();

				//record->vo로 옮긴다
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcode"));
				vo.setM_addr(rs.getString("m_addr"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_regdate(rs.getString("m_regdate"));
				vo.setM_grade(rs.getString("m_grade"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}
	
	//m_id에 해당되는 회원정보 1건을 얻어오기
	public MemberVo selectOne(String m_id) {

		MemberVo vo = null;
		String sql = "select * from member where m_id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatment객체 얻어오기
			pstmt = conn.prepareStatement(sql);
			
			//2-2 pstmt parameter setting
			pstmt.setString(1, m_id);

			//3.ResultSet얻어오기
			rs = pstmt.executeQuery();

			//전체레코드를 vo로 포장후 반환
			if (rs.next()) {
				//record를 담을 객체 생성
				vo = new MemberVo();

				//record->vo로 옮긴다
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcode"));
				vo.setM_addr(rs.getString("m_addr"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_regdate(rs.getString("m_regdate"));
				vo.setM_grade(rs.getString("m_grade"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}
	
	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values((select nvl(max(m_idx),0)+1 from member),?,?,?,?,?,?,sysdate,?)";
		
		try {
			//1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter 설정
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getM_name());
			pstmt.setString(3, vo.getM_pwd());
			pstmt.setString(4, vo.getM_zipcode());
			pstmt.setString(5, vo.getM_addr());
			pstmt.setString(6, vo.getM_ip());
			pstmt.setString(7, vo.getM_grade());
			
			//4.DB 처리: insert/update/delete
			res = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	public int delete(int m_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from member where m_idx=?";
		
		try {
			//1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter 설정
			pstmt.setInt(1, m_idx);
			
			//4.DB 처리: insert/update/delete
			res = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
	}
	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member set m_id=?,m_name=?,m_pwd=?,m_zipcode=?,m_addr=?,m_ip=?,m_grade=? where m_idx=?";
		
		try {
			//1.Connection 얻기
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement 얻기
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter 설정
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getM_name());
			pstmt.setString(3, vo.getM_pwd());
			pstmt.setString(4, vo.getM_zipcode());
			pstmt.setString(5, vo.getM_addr());
			pstmt.setString(6, vo.getM_ip());
			pstmt.setString(7, vo.getM_grade());
			pstmt.setInt(8, vo.getM_idx());
			
			//4.DB 처리: insert/update/delete
			res = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
}
