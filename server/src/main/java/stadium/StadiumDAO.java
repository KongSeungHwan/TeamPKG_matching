package stadium;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnectDB;

public class StadiumDAO extends ConnectDB{
	
	public List<StadiumDTO> getStadiumList(){
		String sql = "SELECT s.* FROM stadium s WHERE s.std_id NOT IN (SELECT m.std_id FROM match m JOIN templocation t ON m.std_id = t.stadium_id)";
		StadiumDTO dto = null;
		List<StadiumDTO> list = new ArrayList<>();
		try {
			psmt=con.prepareStatement(sql);
			rs= psmt.executeQuery();
			while(rs.next()){
				dto=new StadiumDTO();
				dto.setStdId(rs.getString("std_id"));
				dto.setStdName(rs.getNString("std_name"));
				dto.setX(rs.getDouble("coordinate_x"));
				dto.setY(rs.getDouble("coordinate_y"));
				dto.setStartTime(rs.getString("serv_st_time"));
				dto.setEndTime(rs.getString("serv_end_time"));
				dto.setpNumber(rs.getString("p_number"));
				dto.setImageUrl(rs.getString("img_url"));
				dto.setManagerName(rs.getString("mng_name"));
				dto.setViewDetails(rs.getString("view_details"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}
	 public List<StadiumDTO> getAvailableStadiums(String inputTime, int inputPlayers) {
		 	List<StadiumDTO> availableStadiums = new ArrayList<>();
	        try {
	            String sql = "SELECT * FROM stadium WHERE available_time = ? AND available_players >= ?";
	            psmt = con.prepareStatement(sql);
	            psmt.setString(1, inputTime);
	            psmt.setInt(2, inputPlayers);
	            rs = psmt.executeQuery();

	            while (rs.next()) {
	                StadiumDTO stadium = new StadiumDTO();
	                stadium.setStdId(rs.getString("id"));
	                stadium.setX(rs.getDouble("x"));
	                stadium.setY(rs.getDouble("y"));
	                stadium.setAvailableTime(rs.getString("available_time"));
	                stadium.setAvailablePlayers(rs.getInt("available_players"));
	                availableStadiums.add(stadium);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 

	        return availableStadiums;
	    }
	
}
