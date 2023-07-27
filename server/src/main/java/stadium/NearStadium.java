package stadium;

import java.util.List;

import templocation.TempLocationDTO;

public class NearStadium { //DB데이터 중 제일 가까운 스타디움 가져오기
     List<StadiumDTO> stadiumList;
    TempLocationDTO location;
    public NearStadium(TempLocationDTO location) {
        StadiumDAO dao = new StadiumDAO();
        
        stadiumList = dao.getStadiumList();
        this.location = location;
        dao.close();
    }

    private double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public String dstnc_clac() { // 최소거리 구장 구하는 메소드
        double dis = Double.MAX_VALUE;
        StadiumDTO dto = new StadiumDTO();

        for (StadiumDTO stdto : stadiumList) {
            double staX = stdto.getX();
            double staY = stdto.getY();
            double disa = euclideanDistance(location.getLatitude(), location.getLongitude(), staX, staY);

            if (dis > disa) {
                dis = disa;
                dto = stdto;
            }
        }
        	return dto.getStdId();
    }
}