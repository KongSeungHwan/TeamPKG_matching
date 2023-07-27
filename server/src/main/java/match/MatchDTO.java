package match;


public class MatchDTO {
	private String mcSrn;
	private String stdId;
	private String memId;
	private String mTime;
	private String team;
	private String state;
	public MatchDTO(){}
	public MatchDTO(String stdId, String memId, String mTime, String team) {
	    this.mcSrn = "seq_match_num.nextval";
	    this.stdId = stdId;
	    this.memId = memId;
	    this.team = team;
	    this.mTime = mTime;
	}
	public MatchDTO(String mcSrn, String stdId, String memId, String mTime, String team, String state){
		this.mcSrn = mcSrn;
		this.stdId = stdId;
		this.memId = memId;
		this.mTime = mTime;
		this.team = team;
		this.state = state;
	}
	public String getMcSrn() {
		return mcSrn;
	}
	public void setMcSrn(String mcSrn) {
		this.mcSrn = mcSrn;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getmTime() {
		return mTime;
	}
	public void setmTime(String mTime) {
		this.mTime = mTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
	
}
