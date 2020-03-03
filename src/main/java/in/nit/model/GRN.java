package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grntab")
public class GRN {
    @Id
    @GeneratedValue
    @Column(name = "gid")
	private Integer grnId;
    @Column(name = "gcode")
	private String grnCode;
    @Column(name = "gtype")
	private String grnType;
    @Column(name = "ordcode")
	private String ordCode;
    @Column(name = "gdesc")
	private String grnDesc;
    
	public GRN() {
		super();
	}

	public GRN(Integer grnId) {
		super();
		this.grnId = grnId;
	}

	public Integer getGrnId() {
		return grnId;
	}

	public void setGrnId(Integer grnId) {
		this.grnId = grnId;
	}

	public String getGrnCode() {
		return grnCode;
	}

	public void setGrnCode(String grnCode) {
		this.grnCode = grnCode;
	}

	public String getGrnType() {
		return grnType;
	}

	public void setGrnType(String grnType) {
		this.grnType = grnType;
	}

	public String getOrdCode() {
		return ordCode;
	}

	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}

	public String getGrnDesc() {
		return grnDesc;
	}

	public void setGrnDesc(String grnDesc) {
		this.grnDesc = grnDesc;
	}

	@Override
	public String toString() {
		return "GRN [grnId=" + grnId + ", grnCode=" + grnCode + ", grnType=" + grnType + ", ordCode=" + ordCode
				+ ", grnDesc=" + grnDesc + "]";
	}
	
    
}
