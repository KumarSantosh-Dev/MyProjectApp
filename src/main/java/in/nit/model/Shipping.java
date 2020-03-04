package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Shipping {
	
	@Id
	@GeneratedValue
	@Column(name = "shipId")
    private Integer shpId;
	
	@Column(name = "shipCod")
	private String shpCode;
	@Column(name = "refNo")
	private String shpRefNo;
	@Column(name = "corRefNo")
	private String corirRefNo;
	@Column(name = "cntDtls")
	private String contactDtls;
	@Column(name = "shpOrdCod")
	private String slOrdCode;
	@Column(name = "note")
	private String description;
	@Column(name = "blTAdrs")
	private String blToAddrs;
	@Column(name = "shpTAdrs")
	private String shpToAddrs;
	
	
	public Shipping() {
		super();
	}


	public Shipping(Integer shpId) {
		super();
		this.shpId = shpId;
	}


	public Integer getShpId() {
		return shpId;
	}


	public void setShpId(Integer shpId) {
		this.shpId = shpId;
	}


	public String getShpCode() {
		return shpCode;
	}


	public void setShpCode(String shpCode) {
		this.shpCode = shpCode;
	}


	public String getShpRefNo() {
		return shpRefNo;
	}


	public void setShpRefNo(String shpRefNo) {
		this.shpRefNo = shpRefNo;
	}


	public String getCorirRefNo() {
		return corirRefNo;
	}


	public void setCorirRefNo(String corirRefNo) {
		this.corirRefNo = corirRefNo;
	}


	public String getContactDtls() {
		return contactDtls;
	}


	public void setContactDtls(String contactDtls) {
		this.contactDtls = contactDtls;
	}


	public String getSlOrdCode() {
		return slOrdCode;
	}


	public void setSlOrdCode(String slOrdCode) {
		this.slOrdCode = slOrdCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getBlToAddrs() {
		return blToAddrs;
	}


	public void setBlToAddrs(String blToAddrs) {
		this.blToAddrs = blToAddrs;
	}


	public String getShpToAddrs() {
		return shpToAddrs;
	}


	public void setShpToAddrs(String shpToAddrs) {
		this.shpToAddrs = shpToAddrs;
	}


	@Override
	public String toString() {
		return "Shipping [shpId=" + shpId + ", shpCode=" + shpCode + ", shpRefNo=" + shpRefNo + ", corirRefNo="
				+ corirRefNo + ", contactDtls=" + contactDtls + ", slOrdCode=" + slOrdCode + ", description="
				+ description + ", blToAddrs=" + blToAddrs + ", shpToAddrs=" + shpToAddrs + "]";
	}
	
	
}
