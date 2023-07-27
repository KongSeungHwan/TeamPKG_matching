package stadium;

public class StadiumDTO {
	private String stdId;
	private String stdName;
	private String link;
	private double x; // 위도
	private double y; // 경도
	private String startTime;
	private String endTime;
	private String pNumber;
	private String imageUrl;
	private String managerName;
	private String viewDetails;
	private String availableTime;
	private int availablePlayers;
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getpNumber() {
		return pNumber;
	}
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getViewDetails() {
		return viewDetails;
	}
	public void setViewDetails(String viewDetails) {
		this.viewDetails = viewDetails;
	}
	@Override
	public String toString() {
		
		return getStdId();
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public int getAvailablePlayers() {
		return availablePlayers;
	}
	public void setAvailablePlayers(int availablePlayers) {
		this.availablePlayers = availablePlayers;
	}
	
}
