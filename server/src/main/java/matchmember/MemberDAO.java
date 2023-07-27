package matchmember;

import java.sql.SQLException;

import common.ConnectDB;

public class MemberDAO extends ConnectDB {
	public int insertMember(MemberDTO member) {
		
		String sql = "insert into MEMBER"
				+ "	(M_ID,M_NAME,M_BIRTH,M_LEVEL,M_GENDER,P_NUMBER,EMAIL,NICKNAME,PASSWORD,M_TYPECODE,REG_DATE,STATE) "
				+ " values(SEQ_MEMBER_NUM.NEXTVAL,?,?,?,?,?,?,SEQ_MEMBER_NUM.NEXTVAL,?,?,SYSDATE,0)";//0.로그아웃 상태 1. 로그인 상태 2.매칭중 3. 수락/거절 선택 4. 다른 팀원 수락 대기 중
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, member.getMemberName());
			psmt.setString(2, member.getBirth());
			psmt.setString(3, member.getLevel());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getPhoneNumber());
			psmt.setString(6, member.getEmail());
			psmt.setString(7, member.getPassword());
			psmt.setString(8, member.getMemberTypeId());
			return psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원가입 중 오류");
			e.printStackTrace();
		} 
		return 0;
	}
	public MemberDTO getMember(String id) {
		String sql="select * from member where m_id=?";
		MemberDTO dto=null;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setBirth(rs.getString("m_birth"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("m_gender"));
				dto.setLevel(rs.getString("m_level"));
				dto.setMemberId(rs.getString("m_id"));
				dto.setMemberName(rs.getString("m_name"));
				dto.setMemberTypeId(rs.getString("m_typecode"));
				dto.setNickName(rs.getString("nickname"));
				dto.setPassword(rs.getString("password"));
				dto.setPhoneNumber(rs.getString("p_number"));
				dto.setRegDate(rs.getDate("reg_date"));
				dto.setStatement(rs.getString("state"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return dto;
	}
	public int updateStatement(String id,String state) {
		String sql="update member set state= ? where m_id= ?"; //flag 가 2일 때 state 상태 변경
		int res = 0;
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, state);
			psmt.setString(2, id);
			return psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return res;
	}
}
