package server;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import match.MatchDAO;
import matchmember.MemberDAO;
import matchmember.MemberDTO;
import stadium.NearStadium;
import templocation.TempLocationDAO;
import templocation.TempLocationDTO;



@SuppressWarnings("serial")
@WebServlet("/ServerController.do")
public class ServerController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TempLocationDAO tdao = new TempLocationDAO();
		List<TempLocationDTO> list = tdao.getAllTempLocations();
		System.out.print("시스템:");
		try {Thread.sleep(250);} catch (InterruptedException e1) {}
		if(list.size()>=12) {
			System.out.println("매칭 연산 존재");
			MatchDAO matdao = new MatchDAO();
			for (TempLocationDTO e : list) tdao.updateTempLocation(e, new NearStadium(e).dstnc_clac());
			
			try {Thread.sleep(250);} catch (InterruptedException e1) {}
			
			list = tdao.getAllTempLocations();

			Map<String, List<TempLocationDTO>> locationMap = list.stream()
					.filter(e -> {
						try {Thread.sleep(250);} catch (InterruptedException e1) {}
						MemberDAO dao = new MemberDAO();
						MemberDTO dto = dao.getMember(e.getUserId());
						dao.close();
						return dto.getStatement().equals("1");
					})
					.collect(Collectors.groupingBy(TempLocationDTO::getStdId, Collectors.toList()));



			for (Map.Entry<String, List<TempLocationDTO>> entry : locationMap.entrySet()) {
				List<TempLocationDTO> filteredListByStdId = entry.getValue();

				// Filter by want_time
				Map<String, List<TempLocationDTO>> filteredListByWantTime = filteredListByStdId.stream()
						.collect(Collectors.groupingBy(TempLocationDTO::getWantTime, Collectors.toList()));

				for (Map.Entry<String, List<TempLocationDTO>> timeEntry : filteredListByWantTime.entrySet()) {
					List<TempLocationDTO> tempList = timeEntry.getValue();

					if (tempList.size() >= 12) {

						tempList.stream().filter(e->e.getExpress().equals("0"))
						.forEach(e->{
							try {Thread.sleep(250);} catch (InterruptedException e1) {}
							TempLocationDAO dao= new TempLocationDAO();
							
							//이 부분
							MemberDAO mdao = new MemberDAO();
							if(mdao.getMember(e.getUserId()).getMemberTypeId().equals("0")) dao.updateExpress(e,"2"); else dao.updateExpress(e,"1");								
							mdao.close();//디버깅때문에 바꿈 dao.updateExpress(e,"1"); << 원래코드 
							//
							
							dao.close(); //스타디움/날짜 기준 모두 일치하는 템프로케들 중 express 가 0인 애들만 1로 고침
						});

						List<TempLocationDTO> resultList=tempList.stream().filter(e->e.getExpress().equals("2")).collect(Collectors.toList());
						Collections.shuffle(resultList);//무작위로 섞는다.
						if (resultList.size() % 12 == 0) {
							for (int i = 0; i < resultList.size(); i++) {
								TempLocationDTO t = resultList.get(i);
								matdao.insertMatch(t.getStdId(), t.getUserId(), t.getWantTime(), (i < 6) ? "A" : "B"); //횟수별로 팀 정함
								tdao.deleteTempLocation(t);
							}

						}
					}
				}

				matdao.close();
				tdao.close();
				}
		}else {
			System.out.println("매칭 신청자 없음");
		}
	}

}


