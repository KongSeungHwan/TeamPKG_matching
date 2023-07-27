package matchmember;

import java.util.Date;

public class MemberDTO {
	private String memberId;
	private String memberName;
	private String birth;
	private String level;
	private String gender;
	private String phoneNumber;
	private String email;
	private String nickName;
	private String password;
	private String memberTypeId;
	private Date regDate;
	private String statement;
	
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMemberTypeId() {
		return memberTypeId;
	}
	public void setMemberTypeId(String memberTypeId) {
		this.memberTypeId = memberTypeId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getinputCode() {
		return memberId;
	}

}
