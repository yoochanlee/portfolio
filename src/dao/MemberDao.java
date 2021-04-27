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
//single-ton : ��ü 1���������ؼ� ���(����)����
	static MemberDao single = null;

	public static MemberDao getInstance() {

		if (single == null)
			single = new MemberDao();
		return single;
	}

	public MemberDao() {
		// TODO Auto-generated constructor stub
	}
	
	//ȸ����� ��ȸ
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "select * from member";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatment��ü ������
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet������
			rs = pstmt.executeQuery();

			//��ü���ڵ带 vo�� ������ ArrayList�� �߰�
			while (rs.next()) {
				//record�� ���� ��ü ����
				MemberVo vo = new MemberVo();

				//record->vo�� �ű��
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_id(rs.getString("m_id"));
				vo.setM_name(rs.getString("m_name"));
				vo.setM_pwd(rs.getString("m_pwd"));
				vo.setM_zipcode(rs.getString("m_zipcode"));
				vo.setM_addr(rs.getString("m_addr"));
				vo.setM_ip(rs.getString("m_ip"));
				vo.setM_regdate(rs.getString("m_regdate"));
				vo.setM_grade(rs.getString("m_grade"));
				

				//ArrayList�߰�
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
	
	//m_idx�� �ش�Ǵ� ȸ������ 1�� ���
	
	public MemberVo selectOne(int m_idx) {

		MemberVo vo = null;
		String sql = "select * from member where m_idx=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatment��ü ������
			pstmt = conn.prepareStatement(sql);
			
			//2-2 pstmt parameter setting
			pstmt.setInt(1, m_idx);

			//3.ResultSet������
			rs = pstmt.executeQuery();

			//��ü���ڵ带 vo�� ������ ��ȯ
			if (rs.next()) {
				//record�� ���� ��ü ����
				vo = new MemberVo();

				//record->vo�� �ű��
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
	
	//m_id�� �ش�Ǵ� ȸ������ 1���� ������
	public MemberVo selectOne(String m_id) {

		MemberVo vo = null;
		String sql = "select * from member where m_id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatment��ü ������
			pstmt = conn.prepareStatement(sql);
			
			//2-2 pstmt parameter setting
			pstmt.setString(1, m_id);

			//3.ResultSet������
			rs = pstmt.executeQuery();

			//��ü���ڵ带 vo�� ������ ��ȯ
			if (rs.next()) {
				//record�� ���� ��ü ����
				vo = new MemberVo();

				//record->vo�� �ű��
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
			//1.Connection ���
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement ���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter ����
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getM_name());
			pstmt.setString(3, vo.getM_pwd());
			pstmt.setString(4, vo.getM_zipcode());
			pstmt.setString(5, vo.getM_addr());
			pstmt.setString(6, vo.getM_ip());
			pstmt.setString(7, vo.getM_grade());
			
			//4.DB ó��: insert/update/delete
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
			//1.Connection ���
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement ���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter ����
			pstmt.setInt(1, m_idx);
			
			//4.DB ó��: insert/update/delete
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
			//1.Connection ���
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatement ���
			pstmt = conn.prepareStatement(sql);
			//3.pstmt parameter ����
			pstmt.setString(1, vo.getM_id());
			pstmt.setString(2, vo.getM_name());
			pstmt.setString(3, vo.getM_pwd());
			pstmt.setString(4, vo.getM_zipcode());
			pstmt.setString(5, vo.getM_addr());
			pstmt.setString(6, vo.getM_ip());
			pstmt.setString(7, vo.getM_grade());
			pstmt.setInt(8, vo.getM_idx());
			
			//4.DB ó��: insert/update/delete
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
