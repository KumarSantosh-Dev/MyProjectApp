package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "whUserTab")
public class WhUserType {
	
	@Id
	@GeneratedValue
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "userType")
	private String userType;
	
	@Column(name = "userCode")
	private String userCode;
    
	@Column(name = "userFor")
	private String userFor;
	
	@Column(name = "userEmail")
	private String userEmail;
	
	@Column(name = "userContact")
	private String userContact;
	
	@Column(name = "userIdType")
	private String userIdType;
	
	@Column(name = "otherIdType")
	private String otherIdType;
	
	@Column(name = "idNum")
	private String idNum;

	
	
	public WhUserType() {
		super();
	}
	
	

	public WhUserType(Integer userId) {
		super();
		this.userId = userId;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserIdType() {
		return userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}

	public String getOtherIdType() {
		return otherIdType;
	}

	public void setOtherIdType(String otherIdType) {
		this.otherIdType = otherIdType;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	@Override
	public String toString() {
		return "WhUserType [userId=" + userId + ", userType=" + userType + ", userCode=" + userCode + ", userFor="
				+ userFor + ", userEmail=" + userEmail + ", userContact=" + userContact + ", userIdType=" + userIdType
				+ ", otherIdType=" + otherIdType + ", idNum=" + idNum + "]";
	}

	
}
