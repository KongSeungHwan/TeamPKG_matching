package templocation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnectDB;

public class TempLocationDAO extends ConnectDB{
    public TempLocationDTO getLocation(String id){
		 String sql="select * from TEMPLOCATION where MEM_ID= ?";
		 TempLocationDTO dto = new TempLocationDTO();
		 try {
			psmt= con.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				dto.setUserId(rs.getString("mem_id"));
				dto.setLatitude(rs.getDouble("COORDINATE_X"));
				dto.setLongitude(rs.getDouble("COORDINATE_Y"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return dto;
	}
    public int	updateTempLocation(TempLocationDTO dto,String st_id){
		 String sql="update templocation set stadium_id= ? where mem_id=?";
		 int res = 0;
		 try {
			psmt= con.prepareStatement(sql);
			psmt.setString(1, st_id);
			psmt.setString(2, dto.getUserId());
			res=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return res;
	}
    public int	deleteTempLocation(TempLocationDTO dto){
		 String sql="delete from templocation where tmp_idx = ? ";
		 int res = 0;
		 try {
			psmt= con.prepareStatement(sql);
			psmt.setString(1, dto.getTempIdx());
			res=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return res;
	}
    public int	updateExpress(TempLocationDTO dto,String express){
    	String sql="update templocation set express = ? where mem_id = ?";
		 int res = 0;
		 try {
			psmt= con.prepareStatement(sql);
			psmt.setString(1, express);
			psmt.setString(2, dto.getUserId());
			res=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return res;
    }
    
	public List<TempLocationDTO> getAllTempLocations() {
		List<TempLocationDTO> list = new ArrayList<>();
		 String sql="select * from TEMPLOCATION";
		 TempLocationDTO dto = null;
		 try {
			psmt= con.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				dto= new TempLocationDTO(rs.getString("tmp_idx"),rs.getString("mem_id"),rs.getDouble("COORDINATE_X"), rs.getDouble("COORDINATE_Y"),rs.getString("stadium_id"),rs.getString("time"),rs.getString("express"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}