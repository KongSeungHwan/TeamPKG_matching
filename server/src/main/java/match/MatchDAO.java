package match;

import java.sql.SQLException;

import common.ConnectDB;

public class MatchDAO extends ConnectDB{
	public int insertMatch(String std_id,String mem_id,String team,String st_time){
	    String sql = "insert into match(mtc_sr, std_id, mem_id, team,st_time) values (SEQ_MATCH_NUM.NEXTVAL, ?, ?, ?,? )";
	    try {
	        psmt = con.prepareStatement(sql);
	        psmt.setString(1, std_id);
	        psmt.setString(2,mem_id );
	        psmt.setString(3, team);
	        psmt.setString(4, st_time);

	        
	        return psmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return 0;
	}
}
